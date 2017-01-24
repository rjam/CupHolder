package pt.rm.cupholder.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import pt.rm.cupholder.CupHolder;
import pt.rm.cupholder.HoldingCup;

/**
 * Default holder (non-support) activity implementation.
 * @author ricardomoutinho
 */

public abstract class HolderNonCompatActivity<InstanceType> extends Activity implements HoldingCup<InstanceType> {

    CupHolder<InstanceType> mHolder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHolder = new CupHolder<>(this);

        // init or recover instance data during onCreate
        mHolder.recoverInstanceData(this);
    }

    /**
     * Invoked during {@link #onCreate(Bundle)}.
     *
     * @param instance The object previously returned by {@link #onHoldInstance()}, if any.
     */
    @Override
    public abstract void onInitInstance(@Nullable InstanceType instance);

    /**
     * Required by CupHolder. Override {@link #onHoldInstance()} instead.
     */
    @Override
    public final Object onRetainNonConfigurationInstance() {
        return mHolder.storeInstanceData();
    }

}
