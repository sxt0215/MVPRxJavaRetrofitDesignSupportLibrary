package suxiting.com.sxt.common.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by sxt on 16/11/2.
 */
public class MySharePreference {

    public static boolean getBoolean(Context context, final String key,
                                     final boolean defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getBoolean(key, defaultValue);
    }

    public static void setBoolean(Context context, final String key,
                                  final boolean value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putBoolean(key, value).apply();
    }

    public static SharedPreferences getDefaultSP(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferences.Editor getEditor(Context context) {
        return getDefaultSP(context).edit();
    }

    public static boolean putBoolean(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * 不存在返回false
     */
    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, false);
    }

    public static void setFirstIn(Context context) {
        putBoolean(context, "isFirstIn", true);
    }

    public static boolean isFirstIn(Context context) {
        return getBoolean(context, "isFirstIn");
    }



}
