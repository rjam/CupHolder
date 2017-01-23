package pt.rm.cupholder;

import android.support.annotation.Nullable;

/**
 * @author ricardomoutinho
 */

public interface HoldingCup<Type> {

    /**
     * @param instance The object previously returned by {@link #onHoldInstance()}, if any.
     */
    void onInitInstance(@Nullable Type instance);

    /**
     * Note that you should <em>not</em> hold any data that
     * may change based on the configuration, including any data loaded from
     * resources such as strings, layouts, or drawables.
     *
     * @return The object to hold across configuration changes.
     *
     * @see android.app.Activity#onRetainNonConfigurationInstance()
     */
    @Nullable
    Type onHoldInstance();
}
