package suxiting.com.sxt.common.base;

import android.content.Context;

import suxiting.com.sxt.mvp.mode.MvpModelImpl;

/**
 * Created by sxt on 16/11/29.
 */
public abstract class BaseModel extends MvpModelImpl {

    //请求失败
    public static final int REQUEST_ERR = -1;
    //没有网络连接
    public static final int NOT_NET_ERR = -2;


    private String serverUrl = "http://api.budejie.com";

    private Context mContext;

    public BaseModel(Context context) {
        this.mContext = context;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public Context getContext() {
        return mContext;
    }

}
