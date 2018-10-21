package work.worktest.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import work.worktest.R;

/**
 * Created by lyh on 2018/10/18.
 */

public class TestFragment_2 extends BaseFragement {





    @BindView(R.id.tv_text)
    TextView mTvText;
    Unbinder unbinder;


//    public TestFragment_1(int index){
//
//    }

    @Override
    protected void doSomeThing(View view) {
        mTvText.setText("2");
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.fragment_test, null);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
