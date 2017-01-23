package pt.rm.sample_mvp.main;

import pt.rm.sample_mvp.base.BasePresenter;

/**
 * @author ricardomoutinho
 */

public class MainPresenter extends BasePresenter<MainView> {

    private int mCount;

    public MainPresenter(int count) {
        mCount = count;
    }

    @Override
    public void attachView(MainView view) {
        super.attachView(view);
        updateView();
    }

    public void incrementCount() {
        mCount++;
        updateView();
    }

    private void updateView() {
        getView().updateCount(mCount);
    }
}
