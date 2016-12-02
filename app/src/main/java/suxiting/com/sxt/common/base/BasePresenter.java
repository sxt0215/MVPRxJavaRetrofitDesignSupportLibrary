package suxiting.com.sxt.common.base;

import android.content.Context;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import suxiting.com.sxt.common.utils.rxjava.RxJavaLifeManager;
import suxiting.com.sxt.mvp.mode.MvpModel;
import suxiting.com.sxt.mvp.presenter.MvpPresenterImpl;
import suxiting.com.sxt.mvp.view.MvpView;

/**
 * Created by sxt on 16/11/29.
 */
public abstract class BasePresenter<V extends MvpView,M extends MvpModel> extends MvpPresenterImpl<V,M> implements RxJavaLifeManager{

    private Context mContext;
    private CompositeDisposable disposables;

    public BasePresenter(Context context){
        this.mContext = context.getApplicationContext();
        disposables = new CompositeDisposable();
    }

    public Context getContext(){
        return mContext;
    }

    public void addObserver(Disposable disposable){
        disposables.add(disposable);
    }

    @Override
    public void destroy() {
        super.destroy();
        disposables.dispose();
    }
}
