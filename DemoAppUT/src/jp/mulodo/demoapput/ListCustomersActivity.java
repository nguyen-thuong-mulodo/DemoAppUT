package jp.mulodo.demoapput;

import java.util.List;

import jp.mulodo.demoapput.adapter.Adapter_ListCustom;
import jp.mulodo.demoapput.adapter.Adapter_ListCustom.OnClickListListener;
import jp.mulodo.demoapput.database.DataBase;
import jp.mulodo.demoapput.object.CustomerInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ListView;
/**
 * 
 * @author nguyenvantu
 *
 */
public class ListCustomersActivity extends FragmentActivity {
	private ListView mLv_user;
	private Adapter_ListCustom mAdapter;
	private List<CustomerInfo> mCustom;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_listcustomer);
		mLv_user = (ListView) findViewById(R.id.listcustom_lv_user);
	}
	/**
	 * set data for list and set event for two button delete and edit
	 * @method public
	 * @return void
	 */
	public void adapter() {
		mCustom = DataBase.lCutomers;
		mAdapter = new Adapter_ListCustom(this,
				R.layout.activity_listcustommer_listitem, mCustom,
				new OnClickListListener() {
					@Override
					public void onClick_delete(CustomerInfo data) {
						// TODO Auto-generated method stub
						Log.e("POSTION", "" + mAdapter.getPosition());
						Intent i = new Intent(getApplicationContext(),
								DeleteActivity.class);
						i.putExtra("position", mAdapter.getPosition());
						startActivity(i);
					}

					@Override
					public void onClick_edit(CustomerInfo data) {
						// TODO Auto-generated method stub
						Log.e("POSTION", "" + mAdapter.getPosition());
						Intent i = new Intent(getApplicationContext(),
								ModifyActivity.class);
						i.putExtra("position", mAdapter.getPosition());
						startActivity(i);
					}
				});
		mLv_user.setAdapter(mAdapter);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		adapter();
	}
}
