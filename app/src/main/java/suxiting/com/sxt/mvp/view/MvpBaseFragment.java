package suxiting.com.sxt.mvp.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import suxiting.com.sxt.mvp.presenter.MvpPresenter;

/**
 * Created by sxt on 16/11/29.
 */
public abstract class MvpBaseFragment<P extends MvpPresenter> extends Fragment implements MvpView<P> {

    private P presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        presenter = bindPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected P getPresenter() {
        if (presenter == null) {
            throw new NullPointerException("请先绑定presenter在使用");
        }
        return presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.destroy();
        }
    }
}
