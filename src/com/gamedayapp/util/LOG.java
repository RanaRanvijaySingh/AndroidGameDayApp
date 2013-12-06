package com.gamedayapp.util;

import android.util.Log;

public class LOG {
	public static boolean DEBUG_MODE = true;

	public static void d(final String tag, String message) {
		if (DEBUG_MODE)
			Log.d(tag, message);
	}

	public static void w(final String tag, String message) {
		if (DEBUG_MODE)
			Log.w(tag, message);
	}

	public static void e(final String tag, String message) {
		if (DEBUG_MODE)
			Log.e(tag, message);
	}

	public static void v(final String tag, String message) {
		if (DEBUG_MODE)
			Log.v(tag, message);
	}

	public static void i(final String tag, String message) {
		if (DEBUG_MODE)
			Log.i(tag, message);
	}

}
