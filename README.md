# CupHolder
CupHolder lets you easily retain Activity state on configuration changes, similarly to what you get when using retained Fragments. On MVP projects, this can be particularly useful to persist Presenters across orientation changes and other configuration changes. 

### Sure, show me the code

From the sample app:

```java
public class MainActivity extends HolderActivity<MainPresenter> {

    MainPresenter mPresenter;

    @Override
    public void onInitInstance(@Nullable MainPresenter instance) {
        if (instance != null) {
            // restore the retained presenter instance
            mPresenter = instance;
        } else {
            // nothing stored yet, create new presenter 
            mPresenter = new MainPresenter(0);
        }
    }

    @Nullable
    @Override
    public MainPresenter onHoldInstance() {
        return mPresenter;
    }
}
```

With the previous code, despite the activity being recreated when there's a configuration change, `mPresenter` is retained and passed to the new activity on `onInitInstance`. Unlike `onSaveInstanceState`/`onRestoreInstanceState`, this allows you to save actual objects without requiring you to move them onto a `Bundle` but **beware that, like retained fragments, CupHolder will not retain your data across Activity restarts, only configuration changes!** So, don't forget to properly implement `onSaveInstanceState`/`onRestoreInstanceState` as well :)

### Ok, but how does it work?

At its core the library acts simply as a wrapper for the lesser known [onRetainNonConfigurationInstance](https://developer.android.com/reference/android/app/Activity.html#onRetainNonConfigurationInstance()) / [onRetainCustomNonConfigurationInstance](https://developer.android.com/reference/android/support/v4/app/FragmentActivity.html#onRetainCustomNonConfigurationInstance()) which have always been part of the Activity lifecycle, while providing friendly default implementations for both `Activity` and `AppCompatActivity`.

### Sample Projects

**Sample**

In the sample app you can quickly verify that the model's state (the displayed number) is being kept across screen rotations. A second activity shows the same behavior but using a regular retained fragment for comparison.

**Sample-MVP**

A similar project showcasing how the library can be used to easily retain Presenters during configuration changes.

### Dependency

Available through jitpack: https://jitpack.io/#rjam/CupHolder

**Step 1.** Add the JitPack repository to your build file:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
**Step 2.** Add the dependency

```
dependencies {
    compile 'com.github.rjam:CupHolder:<latest-release>'
}
```
