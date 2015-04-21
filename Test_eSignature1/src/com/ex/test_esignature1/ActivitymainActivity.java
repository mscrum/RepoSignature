package com.ex.test_esignature1;



import java.io.FileOutputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ActivitymainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activitymain, menu);
		
		
		
		return true;
	}
	
	
	public void saveBitmap(Bitmap bmp) {
	    try {
	        String root = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
	        String filepath = root + "signature.jpg";

	        FileOutputStream fos = new FileOutputStream(filepath);
	        bmp.compress(CompressFormat.JPEG, 100, fos);
	        fos.flush();
	        fos.close();
	    }
	    catch(Exception e) {
	        Log.e("Could not save", e.getMessage());
	        e.printStackTrace();
	    }
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	// --  GESTION DES EVENNEMENTS
	
	public void clickDone(View  view)
	{
		Toast.makeText(ActivitymainActivity.this, "Button DONE", Toast.LENGTH_SHORT).show();
		
		Bitmap bmp = ((SignatureView)findViewById(R.id.signatureview)).getImage();
		
		saveBitmap(bmp);
		
	}
	
	public void clickClear(View  view)
	{
		Toast.makeText(ActivitymainActivity.this, "Button CLEAR", Toast.LENGTH_SHORT).show();
		
		SignatureView signature = (SignatureView)findViewById(R.id.signatureview);
		
		signature.clearSignature();
		
	}
	
	
}
