package com.gamedayapp;

import java.io.ObjectInputStream.GetField;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.facebook.Session;
import com.gamedayapp.util.LOG;

public class LoginActivity extends Activity {
	private final static String TAG = GetField.class.getName();
	ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);
		progressBar = (ProgressBar) findViewById(R.id.progessBar);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode,
				resultCode, data);
	}

	public void onClickFacebookLogin(View view) {
		LOG.v(TAG, "Facebook Login");
		progressBar.setVisibility(View.VISIBLE);
		FacebookService fbActivity = FacebookService.getInstance();
		fbActivity.doFacebookLogin(this);
	}

	public void onClickTwitterLogin(View view) {
		LOG.v(TAG, "Twitter Login");
		progressBar.setVisibility(View.VISIBLE);
	}

	public void onClickGooglePlusLogin(View view) {
		LOG.v(TAG, "Google Plus Login");

	}

	@Override
	protected void onResume() {
		super.onResume();
		progressBar.setVisibility(View.GONE);
	}
}
