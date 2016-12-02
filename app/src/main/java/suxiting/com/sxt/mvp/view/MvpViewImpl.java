package suxiting.com.sxt.mvp.view;

/**
 * Created by sxt on 16/11/29.
 */
public interface MvpViewImpl<M> extends MvpView{
    void showLoading(boolean isShow);
    void showData(M data);
    void showError(Exception e);
}
