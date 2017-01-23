# CupHolder
CupHolder lets you easily retain Activity state on configuration changes, similarly to what you get when using retained Fragments.

###Sure, show me the code###

From the sample app:

```java
public class MainActivity extends HolderActivity<FakeModel> {

    private FakeModel mModel;

    @Override
    public void onInitInstance(@Nullable FakeModel instance) {
        if (instance != null) {
            // restore the model's previous instance
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
}
```

With the previous code, despite the activity being recreated when there's a configuration change, `mModel` is retained and passed to the new activity on `onInitInstance`. Unlike `onSaveInstanceState`/`onRestoreInstanceState`, this allows you to save actual objects without requiring you to move them onto a `Bundle` but **beware that, like retained fragments, CupHolder will not retain your data across Activity restarts, only configuration changes!** So, don't forget to properly implement `onSaveInstanceState`/`onRestoreInstanceState` as well :)

###Ok, but how does it work?###

At its core the library acts simply as a wrapper for the lesser known [onRetainNonConfigurationInstance](https://developer.android.com/reference/android/app/Activity.html#onRetainNonConfigurationInstance()) / [onRetainCustomNonConfigurationInstance](https://developer.android.com/reference/android/support/v4/app/FragmentActivity.html#onRetainCustomNonConfigurationInstance()) which have always been part of the Activity lifecycle, while providing nice default implementations for both `Activity` and `AppCompatActivity`.
