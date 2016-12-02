package suxiting.com.sxt.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;

import suxiting.com.sxt.R;
import suxiting.com.sxt.common.application.MyApplication;

/**
 * Created by sxt on 16/11/28.
 */
public class ViewModelMain extends BaseObservable {

    private Drawable shouye;
    private Drawable licai;
    private Drawable zhanghu;

    private int tabMain;
    private int tabProduct;
    private int tabSetting;

    @Bindable
    public int getTabSetting() {
        return tabSetting;
    }

    @Bindable
    public int getTabProduct() {
        return tabProduct;
    }

    @Bindable
    public int getTabMain() {
        return tabMain;
    }

    @Bindable
    public Drawable getLicai() {
        return licai;
    }

    @Bindable
    public Drawable getShouye() {
        return shouye;
    }

    @Bindable
    public Drawable getZhanghu() {
        return zhanghu;
    }

    public ViewModelMain() {
        selectShouYe();
    }

    public void selectShouYe() {
        selectTab(R.drawable.home_ok);
    }

    public void selectLiCai() {
        selectTab(R.drawable.product_ok);
    }

    public void selectZhanghu() {
        selectTab(R.drawable.account_ok);
    }

    private void selectTab(int res) {
        reset();
        switch (res) {
            case R.drawable.home_ok:
                shouye = getDrawable(R.drawable.home_ok);
                tabMain = getColor(R.color.red_e83204);
                break;
            case R.drawable.product_ok:
                licai = getDrawable(R.drawable.product_ok);
                tabProduct = getColor(R.color.red_e83204);
                break;
            case R.drawable.account_ok:
                zhanghu = getDrawable(R.drawable.account_ok);
                tabSetting = getColor(R.color.red_e83204);
                break;
        }
        notifyChange();
    }

    private void reset() {
        shouye = getDrawable(R.drawable.home);
        licai = getDrawable(R.drawable.product);
        zhanghu = getDrawable(R.drawable.account);

        tabMain = getColor(R.color.gray_cccccc);
        tabProduct = getColor(R.color.gray_cccccc);
        tabSetting = getColor(R.color.gray_cccccc);
    }

    private Drawable getDrawable(int res) {
        return MyApplication.myApplication.getResources().getDrawable(res);
    }

    private int getColor(int res) {
        return MyApplication.myApplication.getResources().getColor(res);
    }


}
