package suxiting.com.sxt.common.network;

/**
 * Created by sxt on 16/8/4.
 */
public class ApiSettings {
    //测试
    public static String BASEURL = ApiConstants.IP_UAT;
    public static String URL_BASE = BASEURL + "api/v2/";

    public static String CLIENT_ID = ApiConstants.CLIENT_ID_UAT;
    public static String CLIENT_SECRET = ApiConstants.CLIENT_SECRET_UAT;

    public static String BASEURL_H5 = ApiConstants.IP_H5_UAT;
    public static String BASE_H5_DOMAIN = ApiConstants.IP_H5_DOMAIN_UAT;

    //生产
//    public static String BASEURL = ApiConstants.IP_RELEASE;
//    public static String URL_BASE = BASEURL+"api/v2/";
//
//    public static String CLIENT_ID = ApiConstants.CLIENT_ID_RELEASE;
//    public static String CLIENT_SECRET = ApiConstants.CLIENT_SECRET_RELEASE;
//
//    public static String BASEURL_H5 = ApiConstants.IP_H5_RELEASE;
//    public static String BASE_H5_DOMAIN = ApiConstants.IP_H5_DOMAIN_RELEASE;

    //版本升级地址  gitlab 地址
//    public static String APP_VERSION_URL = "http://gitlab.creditcloud.com/";
    //运维（健哥） 地址
    public static String APP_VERSION_URL = "http://app.creditcloud.com/";

    public static String GRANT_TYPE = "password";
    //只登录需要
    public static String CLIENT_CODE = "手机用户";

    public static String URL_THIRD_PARTY_PAYMENT = "http://pay.soopay.net/spay/pay/payservice.do";

    public static String API_VERSION = "http://101.226.171.148/app.json";

    public static int PAYMENT_VENDOR = ApiConstants.PAYMENT_VENDOR_UMP;
}
