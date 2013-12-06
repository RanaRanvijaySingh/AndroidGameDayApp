package com.gamedayapp;

import java.io.ObjectInputStream.GetField;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.gamedayapp.util.LOG;

public class LoginActivity extends Activity {
	private final static String TAG = GetField.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);
	}

	public void onClickFacebookLogin(View view) {
		LOG.v(TAG, "Facebook Login");
		FacebookService fbActivity = FacebookService.getInstance();
		fbActivity.doFacebookLogin(this);

	}

	public void onClickTwitterLogin(View view) {
		LOG.v(TAG, "Twitter Login");
	}
}
