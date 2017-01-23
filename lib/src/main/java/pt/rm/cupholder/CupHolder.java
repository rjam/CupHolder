package pt.rm.cupholder;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author ricardomoutinho
 */
public class CupHolder<InstanceType> {

    private HoldingCup<InstanceType> mHolder;

    /**
     * @param holder Holder class
     */
    public CupHolder(@NonNull HoldingCup<InstanceType> holder) {
        mHolder = holder;
    }

    /**
     * Triggers the attempted recovery of previously saved data
     * and subsequent passage to the holder through
     * {@link HoldingCup#onInitInstance(Object)}.
     * <p>
     * This is usually called during {@link AppCompatActivity#onCreate(Bundle)}.
     */
    @SuppressWarnings("unchecked")
    public void recoverInstanceData(AppCompatActivity activity) {
        mHolder.onInitInstance((InstanceType) activity.getLastCustomNonConfigurationInstance());
    }

    /**
     * Triggers the attempted recovery of previously saved data
     * and subsequent passage to the holder through
     * {@link HoldingCup#onInitInstance(Object)}.
     * <p>
     * This is usually called during {@link Activity#onCreate(Bundle)}.
     */
    @SuppressWarnings("unchecked")
    public void recoverInstanceData(Activity activity) {
        mHolder.onInitInstance((InstanceType) activity.getLastNonConfigurationInstance());
    }

    /**
     * @return The instance data the holder wishes to
     * persist across orientation changes.
     * <p>
     * This is usually called during {@link Activity#onRetainNonConfigurationInstance()}}
     * or {@link AppCompatActivity#onRetainCustomNonConfigurationInstance()}.
     */
    @Nullable
    public InstanceType storeInstanceData() {
        return mHolder.onHoldInstance();
    }
}
