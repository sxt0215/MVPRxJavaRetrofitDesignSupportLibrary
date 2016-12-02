package suxiting.com.sxt.mvp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import suxiting.com.sxt.R;
import suxiting.com.sxt.common.base.BaseActivity;
import suxiting.com.sxt.databinding.ActivityMainBinding;
import suxiting.com.sxt.mvp.presenter.MainPresenter;
import suxiting.com.sxt.viewmodel.ViewModelMain;


public class MainActivity extends BaseActivity<MainPresenter> {
    private ActivityMainBinding activityMainBinding;
    private ViewModelMain viewModelMain;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModelMain = new ViewModelMain();
        activityMainBinding.setModel(viewModelMain);


    }

    @Override
    public MainPresenter bindPresenter() {
        return new MainPresenter(this);
    }

    public void btn_home(View view){
        viewModelMain.selectShouYe();
    }

    public void btn_product(View view){
        viewModelMain.selectLiCai();
    }

    public void btn_setting(View view){
        viewModelMain.selectZhanghu();
    }

}

