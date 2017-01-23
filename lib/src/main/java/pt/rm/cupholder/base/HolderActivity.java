package pt.rm.cupholder.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import pt.rm.cupholder.CupHolder;
import pt.rm.cupholder.HoldingCup;

/**
 * Default holder activity implementation.
 * @author ricardomoutinho
 */

public abstract class HolderActivity<InstanceType> extends AppCompatActivity implements HoldingCup<InstanceType> {

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
    public final Object onRetainCustomNonConfigurationInstance() {
        return mHolder.storeInstanceData();
    }

}
