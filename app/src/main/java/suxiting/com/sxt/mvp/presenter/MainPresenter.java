package suxiting.com.sxt.mvp.presenter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;

import suxiting.com.sxt.common.base.BaseModel;
import suxiting.com.sxt.mvp.view.MainActivity;
import suxiting.com.sxt.mvp.view.fragment.HomeFragment;
import suxiting.com.sxt.mvp.view.fragment.ProductFragment;
import suxiting.com.sxt.mvp.view.fragment.SettingFragment;
import suxiting.com.sxt.common.base.BasePresenter;
/**
 * Created by sxt on 16/11/29.
 */
public class MainPresenter extends BasePresenter<MainActivity,BaseModel>{
    private HomeFragment homeFragment;
    private ProductFragment productFragment;
    private SettingFragment settingFragment;

    private FragmentManager fragmentManagers;

    public MainPresenter(Context context) {
        super(context);
    }

    public void setFragmentManager(FragmentManager fragmentManager){
        this.fragmentManagers = fragmentManager;
    }

    private void hideFragment(FragmentTransaction fragmentTransaction){
//        if(homeFragment != null){
//            fragmentTransaction.hide(homeFragment);
//        }
//        if(productFragment != null){
//            fragmentTransaction.hide(productFragment);
//        }
    }


    @Override
    public BaseModel bindModel() {
        return null;
    }
}
