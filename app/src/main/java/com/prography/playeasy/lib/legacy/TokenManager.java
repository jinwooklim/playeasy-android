package com.prography.playeasy.lib;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenManager {

    private static final String PREFERENCES_NAME = "token_preferences";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String DEFAULT_TOKEN = "";

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 토큰 저장하기
     *
     * @param context Context
     * @param token   String
     */
    public static void set(Context context, String token) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(ACCESS_TOKEN, token);
        editor.apply();
    }

    /**
     * 토큰 가져오기
     *
     * @param context Context
     * @return String
     */
    public static String get(Context context) {
        SharedPreferences prefs = getPreferences(context);
        return prefs.getString(ACCESS_TOKEN, DEFAULT_TOKEN);
    }

    /**
     * 토큰 삭제
     *
     * @param context Context
     */
    public static void remove(Context context) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(ACCESS_TOKEN);
        editor.apply();
    }
}
