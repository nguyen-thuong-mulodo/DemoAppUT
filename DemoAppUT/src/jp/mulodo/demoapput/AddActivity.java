package jp.mulodo.demoapput;

import jp.mulodo.demoapput.controller.UserController;
import jp.mulodo.demoapput.database.DataBase;
import jp.mulodo.demoapput.object.CustomerInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
/**
 * 
 * @author nguyenvantu
 *
 */
public class AddActivity extends FragmentActivity implements OnClickListener{
	private Button mBt_add;
	private EditText mEdt_name,mEdt_address,mEdt_email,mEdt_detail;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		DataBase dataBase = new DataBase();
		dataBase.initData();
		setContentView(R.layout.activity_add);
		mBt_add = (Button)findViewById(R.id.add_btn_add);
		mEdt_name = (EditText)findViewById(R.id.add_edt_name);
		mEdt_address = (EditText)findViewById(R.id.add_edt_address);
		mEdt_email = (EditText)findViewById(R.id.add_edt_email);
		mEdt_detail = (EditText)findViewById(R.id.add_edt_detail);
		
		mBt_add.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.add_btn_add)
		{
			getData();
			
		}
	}
	/**
	 * get data from view
	 * and save in array list
	 * @method public
	 * @return void
	 */
	public void getData()
	{
		String name = mEdt_name.getText().toString();
		String address = mEdt_address.getText().toString();
		String email = mEdt_email.getText().toString();
		String detail = mEdt_detail.getText().toString();
		try {
			CustomerInfo customerInfo = new CustomerInfo();
			customerInfo.setAddress(address);
			customerInfo.setName(name);
			customerInfo.setEmail(email);
			customerInfo.setDetail(detail);
			UserController.add(customerInfo);
			finish();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
