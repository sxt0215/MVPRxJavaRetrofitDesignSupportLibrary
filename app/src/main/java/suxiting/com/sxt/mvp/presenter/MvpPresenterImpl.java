package suxiting.com.sxt.mvp.presenter;

import suxiting.com.sxt.mvp.mode.MvpModel;
import suxiting.com.sxt.mvp.view.MvpView;

/**
 * Created by sxt on 16/11/29.
 */
public abstract class MvpPresenterImpl<V extends MvpView, M extends MvpModel> implements MvpPresenter<V, M> {
    private V view;
    private M model;

    public abstract M bindModel();

    public MvpPresenterImpl() {
        this.model = bindModel();
    }

    protected M getModel() {
        if (model == null) {
            throw new NullPointerException("model未绑定，不能使用");
        }
        return model;
    }

    protected V getView() {
        return view;
    }

    protected boolean isDestroy() {
        return view == null;
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
    }


}
