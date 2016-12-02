package suxiting.com.sxt.common.utils.rxjava;

import io.reactivex.disposables.Disposable;

/**
 * Created by sxt on 16/11/29.
 */
public interface RxJavaLifeManager {
    void addObserver(Disposable disposable);
}
