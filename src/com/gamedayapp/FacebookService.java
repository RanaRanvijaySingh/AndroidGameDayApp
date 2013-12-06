package com.gamedayapp;

import java.io.ObjectInputStream.GetField;

import android.content.Intent;
import android.widget.ProgressBar;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.gamedayapp.util.LOG;

public class FacebookService {
	private static final String TAG = GetField.class.getName();
	private static FacebookService fbService = new FacebookService();

	private FacebookService() {
	}

	public static FacebookService getInstance() {
		return fbService;
	}

	public void doFacebookLogin(final LoginActivity mContext) {
		Session.openActiveSession(mContext, true, new Session.StatusCallback() {
			@SuppressWarnings("deprecation")
			@Override
			public void call(Session session, SessionState state,
					Exception exception) {
				if (session.isOpened()) {
					Request.executeMeRequestAsync(session,
							new Request.GraphUserCallback() {
								@Override
								public void onCompleted(GraphUser user,
										Response response) {
									LOG.v(TAG, "facebook call complete");
									Intent intent = new Intent(mContext
											.getApplicationContext(),
											HomePageActivity.class);
									mContext.startActivity(intent);

								}
							});
				}
			}
		});
	}
}