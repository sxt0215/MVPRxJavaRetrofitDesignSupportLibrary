package suxiting.com.sxt.common.application;

import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;

import suxiting.com.sxt.common.sharepreference.MySharePreference;
import suxiting.com.sxt.common.utils.AppConstants;

/**
 * Created by sxt on 16/11/1.
 *
 * MultiDexApplication  里面处理了64K限制问题，如果继承Application  重写attachBaseContext 方法也可并添加  MultiDex.install(this);
 */
public class MyApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        boolean isNight = MySharePreference.getBoolean(this, AppConstants.ISNIGHT,false);
        if(isNight){
            //使用夜间模式
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            //不使用夜间模式
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
