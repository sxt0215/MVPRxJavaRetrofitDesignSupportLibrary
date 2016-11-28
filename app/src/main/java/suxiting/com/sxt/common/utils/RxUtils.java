package suxiting.com.sxt.common.utils;

import rx.Subscription;

/**
 * Created by sxt on 16/8/4.
 */
public class RxUtils {
    public static Subscription subscription;

    public static void unsubscribe(){
        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

}
