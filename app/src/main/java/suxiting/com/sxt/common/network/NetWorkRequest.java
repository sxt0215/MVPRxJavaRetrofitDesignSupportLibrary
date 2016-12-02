package suxiting.com.sxt.common.network;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import suxiting.com.sxt.common.bean.ImageCodeBean;
import suxiting.com.sxt.common.bean.LoginBean;
import suxiting.com.sxt.common.utils.RxUtils;

/**
 * Created by sxt on 16/11/25.
 */
public class NetWorkRequest {
    /**
     * 获取登录图形验证码
     * */
    public static void getLoginImgCode(String timestamp, Subscriber<ImageCodeBean> subscriber){
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getApiV2().getLoginImgCode(timestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    /**
     * 登录
     * */
    public static void login(String loginName, String password, String captcha_answer, String captcha_token, String client_id, String client_secret, String grant_type, Subscriber<LoginBean> subscriber){
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getApiV2().gotoLoginWeb(loginName,password,captcha_answer,captcha_token,client_id,client_secret,grant_type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
