package suxiting.com.sxt.mvp.view;

import suxiting.com.sxt.mvp.presenter.MvpPresenter;

/**
 * Created by sxt on 16/11/29.
 */
public interface MvpView<P extends MvpPresenter> {
    P bindPresenter();
}
