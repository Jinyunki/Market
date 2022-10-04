package com.example.market.data;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    private static final String PREFERENCE_NAME = "memo_preference_name";

    /**
     * [ 공통 ] SharedPreferences 인스턴스를 만들어서 반환해줌
     */
    private static SharedPreferences getPreference(Context context) {
        return context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * [ String ] 전달 받은 Key로 Value를 저장
     */
    public static void set(Context context, String key, String value) {
        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * [ String ] 전달 받은 Key로 저장된 Value를 불러운당
     */
    public static String get(Context context, String key, String defaultValue) {
        SharedPreferences pref = getPreference(context);
        return pref.getString(key, defaultValue);
    }

    /**
     * [ 공통 ] 전달 받은 Key로 저장된 Value를 지운다
     */
    public static void remove(Context context, String key) {
        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * [ 공통 ] 저장된 Value 들을 모두 지운다
     */
    public static void removeAll(Context context) {
        SharedPreferences pref = getPreference(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }
}