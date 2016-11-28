package suxiting.com.sxt.mvp.mode;

import suxiting.com.sxt.common.bean.ImageCodeBean;
import suxiting.com.sxt.common.bean.LoginBean;
import suxiting.com.sxt.common.network.MySubscriber;
import suxiting.com.sxt.common.network.NetWorkRequest;

/**
 * Created by sxt on 16/11/25.
 */
public class LoginModelImpl implements BaseModel.LoginModel{
    @Override
    public void getLoginImgCode(String timestamp, final LoginModelImpl.onGetImgCodeListener listener) {
        NetWorkRequest.getLoginImgCode(timestamp,new MySubscriber<ImageCodeBean>(){
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                e.printStackTrace();
                listener.onFailure("", (Exception) e);
            }

            @Override
            public void onNext(ImageCodeBean imageCodeBean) {
                super.onNext(imageCodeBean);
                listener.onSuccess(imageCodeBean);
            }
        });
    }


    @Override
    public void login(String loginName, String password, String captcha_answer, String captcha_token, String client_id, String client_secret, String grant_type, final LoginModelImpl.onGoLoginListener listener) {
        NetWorkRequest.login(loginName,password,captcha_answer,captcha_token,client_id,client_secret,grant_type,new MySubscriber<LoginBean>(){
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                listener.onFailure("", (Exception) e);

            }

            @Override
            public void onNext(LoginBean loginBean) {
                super.onNext(loginBean);
                listener.onSuccess(loginBean);
            }
        });
    }

    public interface onGetImgCodeListener{
        void onSuccess(ImageCodeBean imageCodeBean);
        void onFailure(String string,Exception e);
    }

    public interface onGoLoginListener{
        void onSuccess(LoginBean loginBean);
        void onFailure(String string,Exception e);
    }
}
