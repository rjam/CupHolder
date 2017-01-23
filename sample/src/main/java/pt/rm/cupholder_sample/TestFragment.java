package pt.rm.cupholder_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TestFragment extends Fragment {

    private FakeModel mModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // if this would be false, the model would not be
        // retained across configuration changes
        setRetainInstance(true);
        mModel = new FakeModel(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onIncrement(v);
            }
        });
        updateNumber(mModel.getNumber());
    }

    public void onIncrement(View view) {
        updateNumber(mModel.increment());
    }

    private void updateNumber(int number) {
        ((TextView) getView().findViewById(R.id.number)).setText(String.valueOf(number));
    }
}
