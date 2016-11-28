package suxiting.com.sxt.mvp.presenter;

import suxiting.com.sxt.common.bean.ImageCodeBean;
import suxiting.com.sxt.common.bean.LoginBean;
import suxiting.com.sxt.common.utils.LogMe;
import suxiting.com.sxt.mvp.mode.BaseModel;
import suxiting.com.sxt.mvp.mode.LoginModelImpl;
import suxiting.com.sxt.mvp.presenter.BasePresenter.LoginPresenter;

/**
 * Created by sxt on 16/11/25.
 */
public class LoginPresenterImpl implements LoginPresenter.LoginPresenter
        ,LoginModelImpl.onGetImgCodeListener
        ,LoginModelImpl.onGoLoginListener {
    private final String TAG = getClass().getSimpleName();
    private BaseModel.LoginModel loginModel;




    @Override
    public void getImgCode(String timestamp) {

    }

    @Override
    public void login(String loginName, String password, String captcha_answer, String captcha_token, String client_id, String client_secret, String grant_type) {

    }

    @Override
    public void start() {
        LogMe.w(TAG, "start");
    }

    @Override
    public void onSuccess(ImageCodeBean imageCodeBean) {

    }

    @Override
    public void onSuccess(LoginBean loginBean) {

    }

    @Override
    public void onFailure(String string, Exception e) {

    }
}
