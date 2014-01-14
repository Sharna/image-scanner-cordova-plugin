package edu.sfsu.cs.orange.ocr;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

public class OcrPlugin extends CordovaPlugin  {

	public static final int REQUEST_CODE = 0x0ba7c0de;

	private static final String SCAN_INTENT = "edu.sfsu.cs.orange.ocr.SCAN";

	private CallbackContext callbackContext;

	public OcrPlugin() {}
	

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		Intent intentScan = new Intent(SCAN_INTENT);
		intentScan.addCategory(Intent.CATEGORY_DEFAULT);
		this.cordova.startActivityForResult(this, intentScan, 0);
		this.callbackContext = callbackContext;
		return true;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		JSONObject r = new JSONObject();
		System.out.println(intent.getStringExtra("result"));
		try {
			r.put("result", intent.getStringExtra("result"));
			this.callbackContext.success(r);
		} catch (JSONException e) {
			 e.printStackTrace();
		}
	}
}

