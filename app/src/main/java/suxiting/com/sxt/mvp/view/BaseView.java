package suxiting.com.sxt.mvp.view;

/**
 * Created by sxt on 16/11/9.
 */
public interface BaseView {
    void showToast(String str);

    void finishSelf();

    interface LoginView extends BaseView {

    }

}
