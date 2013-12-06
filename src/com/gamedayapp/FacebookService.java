package com.gamedayapp;

import java.io.ObjectInputStream.GetField;

import android.app.Activity;
import android.content.Context;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.gamedayapp.util.LOG;

public class FacebookService {
	private static final String TAG = GetField.class.getName();
	private static FacebookService fbService= new FacebookService();

	private FacebookService() {
	}

	public static FacebookService getInstance() {
		return fbService;
	}

	public void doFacebookLogin(Context mContext) {
		Session.openActiveSession((LoginActivity) mContext, true, new Session.StatusCallback() {
			@Override
			public void call(Session session, SessionState state,
					Exception exception) {
				if (session.isOpened()) {
					Request.executeMeRequestAsync(session,
							new Request.GraphUserCallback() {
								@Override
								public void onCompleted(GraphUser user,
										Response response) {
									if (user != null) {
										LOG.v(TAG, "login success");
									}
								}
							});
				}
			}
		});
	}
}
