package suxiting.com.sxt.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import suxiting.com.sxt.common.utils.LogMe;
import suxiting.com.sxt.mvp.presenter.MvpPresenter;
import suxiting.com.sxt.mvp.view.MvpBaseFragment;

/**
 * Created by sxt on 16/11/29.
 */
public abstract class BaseFragment<P extends MvpPresenter> extends MvpBaseFragment<P> {

    private View view;
    public String TAG = getClass().getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = getRootView(inflater,container);
            initView(view);
            LogMe.e(TAG,"onCreateView __ initView");
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if(parent != null){
            parent.removeView(view);
            LogMe.e(TAG, "onCreateView __ removeView");
        }
        LogMe.e(TAG, "onCreateView end");
        return view;
    }

    protected abstract void initView(View view);

    public abstract View getRootView(LayoutInflater inflater,@Nullable ViewGroup container);
}
