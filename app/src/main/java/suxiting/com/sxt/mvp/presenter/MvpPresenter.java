package suxiting.com.sxt.mvp.presenter;

import suxiting.com.sxt.mvp.mode.MvpModel;
import suxiting.com.sxt.mvp.view.MvpView;

/**
 * Created by sxt on 16/11/29.
 */
public interface MvpPresenter<V extends MvpView,M extends MvpModel> {
    void attach(V view);
    void destroy();
    M bindModel();

}
