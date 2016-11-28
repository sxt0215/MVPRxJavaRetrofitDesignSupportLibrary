package suxiting.com.sxt.common.network;

/**
 * Created by sxt on 16/8/4.
 */
public class ApiConstants {
    public final static int PAYMENT_VENDOR_UMP = 1;
    public final static int PAYMENT_VENDOR_CHINAPNR = 2;

    //测试环境
    public final static String IP_UAT = "https://htkg.uats.cc/";
    public final static String CLIENT_ID_UAT = "client-id-for-mobile-dev";
    public final static String CLIENT_SECRET_UAT = "client-secret-for-mobile-dev";

    //H5 测试地址
    public final static String IP_H5_UAT = "http://htkg.uats.cc/";
    public final static String IP_H5_DOMAIN_UAT = "htkg.uats.cc";

    //生产环境
    public final static String IP_RELEASE = "https://htkg.uats.cc/";
    public final static String CLIENT_ID_RELEASE = "45eb2636-0056-4224-89a0-62782b0459bf";
    public final static String CLIENT_SECRET_RELEASE = "27c72ddcb04493e26a1a40adb908919f64ac1e35a874a9b3a76991a7bad7daac";

    //H5 生产地址
    public final static String IP_H5_RELEASE = "http://htkg.uats.cc/";
    public final static String IP_H5_DOMAIN_RELEASE = "htkg.uats.cc";

    /**
     * 登录
     */
    public final static String API_LOGIN = "token";

    /**
     * 登录  api/web/login
     * */

    public final static String API_LOGIN_WEB = "api/web/login";

    /**
     * 登录图形验证码
     */
    public final static String API_LOGIN_IMGCODE = "captcha";

    /**
     * 判断手机号是否注册
     */
    public final static String API_CHECKPHONE = "users/check/mobile";

    /**
     * 图片格式验证码
     */
    public final static String API_IMAGECODE = "register/captcha";

    /**
     * 判断图形码是否正确
     */
    public final static String API_GETMESSAGE = "captcha?token={token}";

    /**
     * 发送手机验证码
     */
    public final static String API_REGISTERCODE = "api/web/register/smsCaptcha";

    /**
     * 注册
     */
    public final static String API_REGISTER = "api/web/register/submit";

    /**
     * 首页轮播图
     */
    public final static String API_BANNERS = "cms/mobileBanners";

    /**
     * 首页标的
     */
    public final static String API_LOANS_SUMMARY = "loans/summary";

    /**
     * 产品列表
     */
    public final static String API_LOANS_LIST = "loans/getLoanWithPage";

    /**
     * 单个借款列表
     */
    public final static String API_SINGLE_LOAN = "loan";


    /**
     * 修改密码的验证码
     */
    public final static String API_UPDATEPWD_CODE = "users/smsCaptcha/changePwd";

    /**
     * check 验证码是否合法
     */
    public final static String API_CHECKCODE = "auth/verify/captcha";

    /**
     * 修改密码（并非发送短信）
     *
     * auth/reset_password/passwordNoAuth
     * 移动端最后使用auth层接口
     * 故使用下面接口替换
     * auth/reset_password/password
     */
    public final static String API_CHANGEPWD = "auth/reset_password/password";

    /**
     * 我的投资记录
     */
    public final static String API_MYINVESTRECORD = "user/MYSELF/invest/list";
    /**
     * 资金记录
     */
    public final static String API_FUNDRECORD = "user/MYSELF/funds/query";


    /**
     * 消息列表  NEW
     * */
    public final static String API_NOTIFICATION = "message/user/MYSELF/listByStatus";

    /*
 * notification message read
 * GET_Aouth@
 */
    public final static String API_MESSAGEMARKASREAD = "message/markAsRead";


    /**
     * user/MYSELF/userinfo 获取用户信息
     * */
    public final static String API_USERINFO = "user/MYSELF/userinfo";

    /**
     * 修改手机号  获取验证码
     *
     * https://htkg.uats.cc/api/v2/captcha?token=ae3e6cdc-508d-4f88-ae10-392f8ce0ee3d  图形验证码获取
     * https://htkg.uats.cc/api/v2/users/changeMobile/smsCaptcha?mobile=15140105147   短信验证码
     * https://htkg.uats.cc/api/v2/users/check/mobile   新手机号的判断
     * https://htkg.uats.cc/api/v2/users/changeMobile
     *   oldMobile:15140105149
         newMobile:15140105147
         captcha:330783
         password:111111
     *
     * */

    public final static String API_CHANGEMOBILE_SMS = "users/changeMobile/smsCaptcha";

    /**
     * 修改手机号
     * users/changeMobile
     * */

    public final static String API_CHANGE_MOBILE = "users/changeMobile";

    /**
     * 修改登录密码
     * newAccount/change_password
     * /api/v2/user/MYSELF/change_password
     * */

    public final static String API_UPDATE_PWD = "newAccount/change_password";
//    public final static String API_UPDATE_PWD = "user/MYSELF/change_password";

    /**
     * statistics
     * 我的页面接口（资金总览、代收本金等信息）
     * */
    public final static String API_MY_FUND_INFO = "user/MYSELF/statistics";

    /**
     * 绑定邮箱接口
     * */
    public final static String API_BIND_EMAIL = "users/creditEmail/MYSELF";

    /**
     * 红包接口
     * */
    public final static String API_RED_PACKET = "coupon/MYSELF/coupons/byStatus";

    /**
     * 首页调  H5邀请好友接口  h5/dashboard/invite
     * */
    public final static String API_H5_INVEST = "h5/dashboard/invite";

    /**
     * 风险测评接口
     *api/v2/survey/user/MYSELF/frontend/survey
     * */
    public final static String API_RISK = "survey/user/MYSELF/frontend/survey";

    /**
     * 我的账户中的
     * 1. 右上角“我的消息”如有未读信息时，出现红色提示信息（是否有最新未读消息）
          接口：api/v2/message/user/MYSELF/listByStatus?status=NEW&page=1&pageSize=20；
       2. 待收本金、待收收益、累计收益
          接口：api/v2/user/MYSELF/statistics；
       3. 获取身份证号：
          接口api/v2/user/MYSELF/userinfo；
       4. 查询是否开户：
          接口api/v2/payment/acct/info；
       5. 查询渤海账户余额：
          接口 api/v2/payment/acct/amount/query；
           有2与5最后计算出 资产总额。
     *合并为一个接口  /api/v2/accountIndex   GET
     * */

    public final static String API_ACCOUNT = "accountIndex";

    /**
     * 渤海开户查询
     */
    public final static String API_CHECK_AUTH = "payment/acct/info";

    /**
     * 渤海银行
     * 开户页面跳转接口
     */
    public final static String API_BOHAI_KAIHU = "payment/acct/register/forward";

    /**
     * 渤海银行
     * 查询余额接口
     */
    public final static String API_ACCOUNT_BALANCE = "payment/acct/amount/query";

    /**
     * 渤海银行
     * 投资跳转接口
     */
    public final static String API_INVEST = "payment/tender/forward";

    /**
     * 渤海银行
     * 充值跳转接口
     */
    public final static String API_RECHARGE = "payment/acct/recharge/forward";

    /**
     * 渤海银行
     * 提现跳转接口
     */
    public final static String API_WITHDEAW = "payment/acct/withdraw/forward";


    /**
     * 修改交易密码页面跳转接口
     * */
    public final static String API_UPDATE_TRADE_PWD = "payment/password/set/forward";

   /**
    * 换银行卡页面跳转接口
    * */
    public final static String API_CHANGE_CARD = "payment/card/change/forward";

}
