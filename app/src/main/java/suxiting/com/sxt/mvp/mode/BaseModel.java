package suxiting.com.sxt.mvp.mode;

/**
 * Created by sxt on 16/11/9.
 */
public interface BaseModel<T> {
    void network(T model);

    interface LoginModel{
        void getLoginImgCode(String timestamp, LoginModelImpl.onGetImgCodeListener listener);

        void login(String loginName,String password,String captcha_answer,String captcha_token,String client_id,String client_secret,String grant_type,LoginModelImpl.onGoLoginListener listener);
    }
}
