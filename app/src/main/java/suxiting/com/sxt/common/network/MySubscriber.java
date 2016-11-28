package suxiting.com.sxt.common.network;


import rx.Subscriber;
import suxiting.com.sxt.common.utils.LogMe;

/**
 * Created by sxt on 16/8/5.
 */
public class MySubscriber<T> extends Subscriber<T> {
    @Override
    public void onStart() {
        super.onStart();
        LogMe.i("MySubscriber", "onStart被调用了");
    }

    @Override
    public void onCompleted() {
        LogMe.i("MySubscriber", "onCompleted被调用了");
    }

    @Override
    public void onError(Throwable e) {
        LogMe.i("Throwable", e.getMessage());
        LogMe.i("MySubscriber", "onError被调用了");
    }

    @Override
    public void onNext(T t) {
        LogMe.i("MySubscriber", "onNext被调用了");
    }
}
