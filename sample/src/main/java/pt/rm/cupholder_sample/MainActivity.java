package pt.rm.cupholder_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import pt.rm.cupholder.base.HolderActivity;

public class MainActivity extends HolderActivity<FakeModel> {

    private FakeModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onInitInstance(@Nullable FakeModel instance) {
        if (instance != null) {
            // restore previous instance
            mModel = instance;
        } else {
            // nothing stored, create it now
            mModel = new FakeModel(0);
        }
    }

    @Nullable
    @Override
    public FakeModel onHoldInstance() {
        return mModel;
    }

    private void initView() {
        updateNumber(mModel.getNumber());
    }

    public void onIncrement(View view) {
        updateNumber(mModel.increment());
    }

    private void updateNumber(int number) {
        ((TextView) findViewById(R.id.number)).setText(String.valueOf(number));
    }

    public void onGoToFragmentActivity(View view) {
        startActivity(new Intent(this, FragmentTestActivity.class));
    }
}
