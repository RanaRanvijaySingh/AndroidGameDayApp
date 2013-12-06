package com.gamedayapp;

import java.io.ObjectInputStream.GetField;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.gamedayapp.util.LOG;

public class FacebookService {
	private LoginActivity mContext;
	private static final String TAG = GetField.class.getName();

	public FacebookService(LoginActivity context) {
		this.mContext = context;
	}

	public void doFacebookLogin() {
		Session.openActiveSession(mContext, true, new Session.StatusCallback() {
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
