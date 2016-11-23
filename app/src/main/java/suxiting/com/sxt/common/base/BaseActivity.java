package suxiting.com.sxt.common.base;

import android.app.ActionBar;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


import com.umeng.analytics.MobclickAgent;

import java.util.List;

import suxiting.com.sxt.common.utils.ActivityCollector;
import suxiting.com.sxt.common.utils.LogMe;
import suxiting.com.sxt.common.utils.OnClickUtil;

/**
 * Created by sxt on 16/8/4.
 */
public abstract class BaseActivity <T extends ViewDataBinding>extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName() + "My";

    public boolean isActive = true;
    /**
     * ViewDataBinding实体
     * 用于子类调用设置数据或者获得控件
     */
    protected T binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**activity从res/layout中加载XML文件
         * setContentView(R.layout.activity_xml);*/

        LogMe.i(TAG, "------------OnCreate------------");

        //步骤2：还原当前activity的状态
        if (savedInstanceState != null) {
            String tempData = savedInstanceState.getString("data_key");
            LogMe.i(TAG, "------------restore:" + tempData);
        }

        ActionBar actionBar = null;
        try {
            actionBar = getActionBar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (actionBar != null) {
            actionBar.hide();
        }


        ActivityCollector.addActivity(this);

    }

    public T getBinding(){
        return binding;
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        binding = DataBindingUtil.bind(view);
    }

    /**
     * Activity的现场保存：
     * <p>
     * 程序在运行时，一些设备的配置可能会改变，如：横竖屏的切换、键盘的可用性等。这种事情一旦发生，Activity会重新创建。
     * <p>
     * 重新创建的过程如下：
     * <p>
     * 1.在销毁之前，会调用onSaveInstanceState()去保存应用中的一些数据，保存在系统当中；
     * 2.然后调用onDestroy()销毁之前的Activity；
     * 3.最后调用 onCreate()或onRestoreInstanceState()方法去重新创建一个Activity。
     *
     * @param outState
     */
    // 步骤1：活动被销毁之前（如在横竖屏切换时），会触发该方法来保存activity数据
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "open";
        outState.putString("data_key", tempData);
        LogMe.i(TAG, "------------onSaveInstanceState-");
    }

    /**
     * 当活动即将可见时调用
     */
    @Override
    protected void onStart() {
        super.onStart();
        LogMe.i(TAG, "------------OnStart------------");
    }

    /**
     * 返回改页面
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        LogMe.i(TAG, "------------OnRestart------------");
    }

    /**
     * 当活动可见时调用
     */
    @Override
    protected void onResume() {
        super.onResume();
        LogMe.i(TAG, "------------OnResume------------");

        MobclickAgent.onResume(this);

        if (!isActive) {
            isActive = true;
//            if (!ActivityCollector.isExistGestureActivity()
//                    && !ActivityCollector.isExistLoginActivity()
//                    && getSharedPref().isLogin()) {
//                LogMe.e("BaseActivity手势密码的开关==isGestureOff", getSharedPref().isGestureOpen() + "");
//                if (!getSharedPref().isGestureOpen()) {//关闭手势密码
//                    if (ActivityCollector.isExistMainActivity()) {
//                        Intent intent = new Intent();
//                        //intent.setAction(SettingFragment.REFRESH_BALANCE);
//                        sendBroadcast(intent);
//                    } else {
//                        startActivity(new Intent(BaseActivity.this, MainActivity.class));
//                    }
//                } else {
//                    Intent intent = new Intent(this, GestureBackActivity.class);
//                    startActivity(intent);
//                }
//            }
        }
    }

    /**
     * 当其他活动获得焦点时调用
     */
    @Override
    protected void onPause() {
        super.onPause();
        LogMe.i(TAG, "------------OnPause------------");
        // If the screen is off then the device has been locked
        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        boolean isScreenOn = powerManager.isScreenOn();

        LogMe.e(TAG, "screen status:" + isScreenOn);

        if (!isScreenOn)
            isActive = false;

        MobclickAgent.onPause(this);
    }

    /**
     * 当活动不再可见时调用
     */
    @Override
    protected void onStop() {
        super.onStop();
        LogMe.i(TAG, "------------OnStop------------");
        if (!isAppOnForeground()) {
            isActive = false;
        }
        LogMe.e("isActive", "onStop:" + isActive);
    }

    /**
     * 当活动将被销毁时调用
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogMe.i(TAG, "------------OnDestroy---------");
        ActivityCollector.removeActivity(this);
    }

    public void back(View view) {
        finish();
    }


    /**
     * 程序是否在前台运行
     */

    public boolean isAppOnForeground() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }


//    public void logout(Context context) {
//        getSharedPref().setLogin(false, "", "", "", "", 0,"");
//        getSharedPref().setGesture("", "");
//        Intent intent = new Intent(context, LoginActivity.class);
//        startActivity(intent);
//        ActivityCollector.finishAllExceptMainAndLogin();
//    }
//
//    public MySharePreference getSharedPref() {
//        return MyApplication.getInstance().getSharePreference();
//    }


    public void showSystemToast(String msg) {
        //if (!OnClickUtil.isFastDoubleClick(2000)) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        //}
    }
//
//    private PrompfDialog logOutDialog;
//
//    public void showLogOutDialog(final Context context) {
//        if (logOutDialog == null) {
//            logOutDialog = new PrompfDialog(context,
//                    R.style.transparentFrameWindowStyle, "退  出", "取  消",
//                    "您确定要退出登录账户吗？", "航天智慧");
//            logOutDialog.setCanceledOnTouchOutside(false);
//            logOutDialog
//                    .setUpdateOnClickListener(new PrompfDialog.UpdateOnclickListener() {
//                        // 这里的逻辑和后面的逻辑正好相反 所以使用！
//                        @Override
//                        public void dismiss() {
//                            // TODO Auto-generated method stub
//                        }
//
//                        @Override
//                        public void BtnYesOnClickListener(View v) {
//                            //logOut_rz();   退出账号日志请求
//                            logout(context);
//                            logOutDialog.dismiss();
//                        }
//
//                        @Override
//                        public void BtnCancleOnClickListener(View v) {
//                            logOutDialog.dismiss();
//                        }
//
//                    });
//            Window window = logOutDialog.getWindow();
//            window.setGravity(Gravity.CENTER);
//            logOutDialog.show();
//
//        } else {
//            logOutDialog.show();
//        }
//    }
//
//    PrompfDialog updateDialog;
//
//    public void showUpdateDialog(final Context context,
//                                 final String versionPath, final String versionName,
//                                 final String versionCode) {
//        if (updateDialog == null) {
//            updateDialog = new PrompfDialog(context,
//                    R.style.transparentFrameWindowStyle, "更  新", "关  闭",
//                    "检测到最新版本，需要更新吗？", "航天智慧");
//            updateDialog.setCanceledOnTouchOutside(false);
//            updateDialog
//                    .setUpdateOnClickListener(new PrompfDialog.UpdateOnclickListener() {
//                        // 这里的逻辑和后面的逻辑正好相反 所以使用！
//                        @Override
//                        public void dismiss() {
//                            // TODO Auto-generated method stub
//                        }
//
//                        @Override
//                        public void BtnYesOnClickListener(View v) {
//                            Intent it = new Intent(context,
//                                    NotificationUpdateActivity.class);
//                            it.putExtra("versionPath", versionPath);
//                            it.putExtra("versionName", versionName);
//                            it.putExtra("versionCode", versionCode);
//                            startActivity(it);
//                            MyApplication.getInstance().setDownload(true);
//                            updateDialog.dismiss();
//                        }
//                        @Override
//                        public void BtnCancleOnClickListener(View v) {
//                            updateDialog.dismiss();
//                        }
//                    });
//            Window window = updateDialog.getWindow();
//            window.setGravity(Gravity.CENTER);
//            updateDialog.show();
//            // WindowManager m = this.getWindowManager();
//            //
//            // // 获取屏幕宽、高用
//            // Display d = m.getDefaultDisplay();
//            // delete_dialog.getWindow().setLayout((int) (d.getWidth() * 0.7),
//            // (int) (d.getHeight() * (0.3)));
//        } else {
//            updateDialog.show();
//        }
//    }

    public void showSystemShortToast(String msg) {
        if (!OnClickUtil.isFastDoubleClick(2000)) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

//    /**
//     * 获取版本号
//     *
//     * @param context
//     * @return
//     */
//    public int getAppVersion() {
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    getPackageName(), 0);
//            return info.versionCode;
//        } catch (NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return 1;
//    }
    public final int getVersionCode(Context context)// 获取版本号(内部识别号)
    {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            return pi.versionCode;
        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
    }

    public final String getVersionName(Context context)// 获取版本号(内部识别号)
    {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            return pi.versionName;
        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }



}
