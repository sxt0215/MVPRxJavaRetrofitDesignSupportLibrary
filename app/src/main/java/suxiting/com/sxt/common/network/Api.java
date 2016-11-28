package suxiting.com.sxt.common.network;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import suxiting.com.sxt.common.bean.ImageCodeBean;
import suxiting.com.sxt.common.bean.LoginBean;

/**
 * Created by sxt on 16/11/23.
 */
public interface Api {
    /**
     * 获取登录图形验证码 get
     * */
    @GET(ApiConstants.API_LOGIN_IMGCODE)
    Observable<ImageCodeBean> getLoginImgCode(@Query("timestamp") String timestamp);

    /**
     * 登录 api/web/login
     * */
    @FormUrlEncoded
    @POST(ApiConstants.API_LOGIN_WEB)
    Observable<LoginBean> gotoLoginWeb(
            @Field("loginName") String username,
            @Field("password") String password,
            @Field("captcha_answer") String captcha_answer,
            @Field("captcha_token") String captcha_token,
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret,
            @Field("grant_type") String grant_type);


}
