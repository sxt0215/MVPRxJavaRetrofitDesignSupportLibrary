package suxiting.com.sxt.mvp.presenter;

/**
 * Created by sxt on 16/11/9.
 */
public interface BasePresenter {

    void start();

    interface LoginPresenter extends BasePresenter{
        void getImgCode(String timestamp);
        void login(String loginName, String password, String captcha_answer, String captcha_token, String client_id, String client_secret, String grant_type);

    }
}
