package work.worktest.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;




public abstract  class BaseFragement extends Fragment {





    //private  Dialog sLoadingDialog;
    private View mView;

    public View getView(){
        return this.mView;
    }

    @Nullable
    @Override
    public   View  onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView(inflater,container);
        mView=view;
        return view;
    }
    protected  abstract  void doSomeThing(View view);

    protected   abstract View initView(LayoutInflater inflater,ViewGroup container);

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doSomeThing(view);
    }







    /**
     * 显示加载对话框
     *
     */
//    public  void showDialog() {
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.loading_dialog, null);
//        TextView loadingText = (TextView) view.findViewById(R.id.id_tv_loading_dialog_text);
//        AVLoadingIndicatorView avLoadingIndicatorView = (AVLoadingIndicatorView) view.findViewById(R.id.AVLoadingIndicatorView);
//        loadingText.setText(R.string.是打发斯蒂芬);
//        sLoadingDialog = new Dialog(getContext(), R.style.loading_dialog_style);
//        sLoadingDialog.setCancelable(false);
//        sLoadingDialog.setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT));
//
//        sLoadingDialog.show();
//        avLoadingIndicatorView.smoothToShow();


        //返回键 取消的 代码
//        mLoadingDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
//            @Override
//            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_BACK) {
//                    mLoadingDialog.hide();
//                    return true;
//                }
//                return false;
//            }
//        });

//    }


//    /**
//     * 隐藏
//     */
//    public void dismiss(){
//        if(sLoadingDialog==null){
//            return;
//        }else {
//            sLoadingDialog.dismiss();
//        }
//
//    }
}
