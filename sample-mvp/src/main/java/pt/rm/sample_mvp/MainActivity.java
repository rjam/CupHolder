package pt.rm.sample_mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import pt.rm.cupholder.base.HolderActivity;
import pt.rm.sample_mvp.main.MainPresenter;
import pt.rm.sample_mvp.main.MainView;

public class MainActivity extends HolderActivity<MainPresenter> implements MainView {

    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onInitInstance(@Nullable MainPresenter instance) {
        if (instance != null) {
            mPresenter = instance;
        } else {
            mPresenter = new MainPresenter(0);
        }
    }

    @Nullable
    @Override
    public MainPresenter onHoldInstance() {
        return mPresenter;
    }

    @Override
    protected void onStart() {
        super.onStart();

        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.dettachView();
        super.onDestroy();
    }

    @Override
    public void updateCount(int count) {
        ((TextView) findViewById(R.id.number)).setText(String.valueOf(count));
    }

    public void onIncrement(View view) {
        mPresenter.incrementCount();
    }
}
