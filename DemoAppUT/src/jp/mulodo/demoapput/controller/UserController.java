package jp.mulodo.demoapput.controller;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import jp.mulodo.demoapput.database.DataBase;
import jp.mulodo.demoapput.error.ErrorAdd;
import jp.mulodo.demoapput.error.ErrorBase;
import jp.mulodo.demoapput.error.ErrorDelete;
import jp.mulodo.demoapput.error.ErrorLogin;
import jp.mulodo.demoapput.object.CustomerInfo;
import jp.mulodo.demoapput.object.User;

public class UserController {
	
	/**
	 * Login in system
	 * @throws ErrorBase 
	 * @throws ErrorLogin if error
	 * @parameter username and pass
	 */
	public static boolean login(String UserName,String Password ) throws ErrorBase,NullPointerException
	{
		for (User user : DataBase.lUsers) {
			boolean checkUserName = user.getUserName().equals(UserName);
			boolean checkPassword = user.getPassword().equals(Password);
			if (checkPassword && checkUserName )
			{
				return true;
			}
		}
		ErrorBase error = new ErrorLogin();
		throw error;
	}
	
	/**
	 * Add customer to array list
	 * @throws ErrorBase 
	 * @parameter customer
	 */
	public static boolean add (CustomerInfo customer) throws ErrorBase
	{
		if (customer != null)
		{
			DataBase.lCutomers.add(customer);
			return true;
		}
		ErrorBase error = new ErrorAdd();
		throw error;
	}
	
	/**
	 * Delete 1 object cusromer to array list
	 * @throws ErrorBase 
	 * @parameter id is index of array
	 */
	public static boolean delete (int ID) throws ErrorBase,IndexOutOfBoundsException
	{
		if (ID > 0 || ID < DataBase.lCutomers.size() )
		{
			DataBase.lCutomers.remove(ID);
			return true;
		}
		ErrorBase error = new ErrorDelete();
		throw error;
	}
	
	/**
	 * Get List Customer
	 */
	public static ArrayList<CustomerInfo> getAllCustomer() throws NullPointerException
	{
		return DataBase.lCutomers;
	}
	
	/**
	 * Get List User
	 */
	public static ArrayList<User> getAllUser() throws NullPointerException
	{
		return DataBase.lUsers;
	}
	
	
	
}
