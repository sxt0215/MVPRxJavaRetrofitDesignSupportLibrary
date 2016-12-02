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
import suxiting.com.sxt.mvp.presenter.MvpPresenter;
import suxiting.com.sxt.mvp.view.MvpBaseActivity;

/**
 * Created by sxt on 16/8/4.
 */
public abstract class BaseActivity <P extends MvpPresenter>extends MvpBaseActivity<P> {
    @Override
    public P bindPresenter() {
        return null;
    }
}
