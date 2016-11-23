package suxiting.com.sxt.mvp.view;

import android.os.Bundle;

import com.google.common.net.MediaType;

import java.io.File;

import suxiting.com.sxt.R;
import suxiting.com.sxt.common.base.BaseActivity;
import suxiting.com.sxt.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initNavigationViewHeader(){

    }


}

