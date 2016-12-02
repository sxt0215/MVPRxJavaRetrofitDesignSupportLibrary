package suxiting.com.sxt.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import suxiting.com.sxt.mvp.presenter.MvpPresenter;

/**
 * Created by sxt on 16/11/29.
 */
public abstract class MvpBaseActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView<P>{

    private P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = bindPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
    }

    protected P getPresenter() {
        if (presenter == null) {
            throw new NullPointerException("请先绑定presenter在使用");
        }
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destroy();
        }
    }
}
