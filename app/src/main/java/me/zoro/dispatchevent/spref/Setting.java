package me.zoro.dispatchevent.spref;

import android.content.Context;
import android.content.SharedPreferences;

import me.zoro.dispatchevent.App;

/**
 * Created by luguanquan on 2016/10/17.
 */

public class Setting {

    private SharedPreferences preferences;

    public static final String KEY_FIRST_LAYOUT_DISPATCH = "key_first_layout_dispatch";
    public static final String KEY_FIRST_LAYOUT_INTERCEPT = "key_first_layout_intercept";
    public static final String KEY_FIRST_LAYOUT_TOUCH = "key_first_layout_touch";

    public static final String KEY_SECOND_LAYOUT_DISPATCH = "key_second_layout_dispatch";
    public static final String KEY_SECOND_LAYOUT_INTERCEPT = "key_second_layout_intercept";
    public static final String KEY_SECOND_LAYOUT_TOUCH = "key_second_layout_touch";

    public static final String KEY_THIRD_LAYOUT_DISPATCH = "key_third_layout_dispatch";
    public static final String KEY_THIRD_LAYOUT_INTERCEPT = "key_third_layout_intercept";
    public static final String KEY_THIRD_LAYOUT_TOUCH = "key_third_layout_touch";

    public static final String KEY_LAST_VIEW_DISPATCH = "key_last_view_dispatch";
    public static final String KEY_LAST_VIEW_INTERCEPT = "key_last_view_intercept";
    public static final String KEY_LAST_VIEW_TOUCH = "key_last_view_touch";

    private Setting() {
        preferences = App.getInstance().getSharedPreferences("setting", Context.MODE_PRIVATE);
    }

    public static Setting getInstance() {
        return SettingHolder.setting;
    }

    public static class SettingHolder {
        public static Setting setting = new Setting();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    public void putBoolean(String key, boolean defValue) {
        preferences.edit().putBoolean(key, defValue).commit();
    }
}
