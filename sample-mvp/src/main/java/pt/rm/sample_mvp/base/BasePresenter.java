package pt.rm.sample_mvp.base;

import android.support.annotation.CallSuper;

/**
 * @author ricardomoutinho
 */

public abstract class BasePresenter<ViewType> {

    private ViewType mView;

    @CallSuper
    public void attachView(ViewType view) {
        mView = view;
    }

    @CallSuper
    public void dettachView() {
        mView = null;
    }

    public ViewType getView() {
        return mView;
    }


}
