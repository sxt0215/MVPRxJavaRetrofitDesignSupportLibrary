package suxiting.com.sxt.common.network;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import suxiting.com.sxt.common.utils.LogMe;

/**
 * Created by sxt on 16/8/5.
 */
public class Network {

    private static Api apiV2;
    private static Api api;
    private static Api apiUpdate;
    private static final Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static final CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static Api getApiV2() {
        if (apiV2 == null) {
            apiV2 = getRetrofit(ApiSettings.URL_BASE).create(Api.class);
        }
        return apiV2;
    }

    public static Api getApi() {
        if (api == null) {
            api = getRetrofit(ApiSettings.BASEURL).create(Api.class);
        }
        return api;
    }

    // 版本升级使用
    public static Api versionUp() {
        if (apiUpdate == null) {
            apiUpdate = getRetrofit(ApiSettings.APP_VERSION_URL).create(Api.class);
        }
        return apiUpdate;
    }


    private static Retrofit getRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .connectTimeout(15,TimeUnit.SECONDS)
                        .readTimeout(20,TimeUnit.SECONDS)
                        .addInterceptor(new LogInterceptor()).build())
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

    private static class LogInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            LogMe.i("LogUtils--> ", "request:" + request.toString());
            Response response = chain.proceed(chain.request());
            List<String> headers = response.headers("Set-Cookie");
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            LogMe.i("LogUtils--> ", "response body:" + content);
            LogMe.i("LogUtils-----> ", "Set-Cookie:" + headers);
            if (response.body() != null) {
                ResponseBody body = ResponseBody.create(mediaType, content);
                return response.newBuilder().body(body).build();
            } else {
                return response;
            }
        }
    }

    /**
     * 想把请求头提出来，进行中，，，，
     */
    private static Retrofit getRetrofitHearder(String baseUrl) {
        return new Retrofit.Builder()
                .client(new OkHttpClient.Builder().addInterceptor(new LogInterceptorHeader()).build())
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

    //公共参数
    private static class LogInterceptorHeader implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request request;
            String method = originalRequest.method();
            Headers headers = originalRequest.headers();
            HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                    // Provide your custom parameter here
                    .addQueryParameter("platform", "android")
                    .addQueryParameter("version", "1.0.0")
                    .build();
            request = originalRequest.newBuilder().url(modifiedUrl).build();
            return chain.proceed(request);
        }
    }

}
