package work.worktest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.io.PipedReader;
import java.util.List;

import work.worktest.R;
import work.worktest.bean.BaseBean;
import work.worktest.bean.ItemType;
import work.worktest.bean.MyBean_1;
import work.worktest.bean.MyBean_2;

/**
 * Created by lyh on 2018/10/20.
 */

public class ListAdapter extends BaseQuickAdapter<BaseBean,BaseViewHolder> {

    private List mList;



    public ListAdapter(Context context, List<BaseBean> list){
        super(list);
        this.mList=list;

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }


    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {
        switch (helper.getItemViewType()) {
            case 1:
                // do something
                helper.setText(R.id.tv_text,((MyBean_1)item).text);
                break;
            case 2:
                // do something
                helper.setText(R.id.bt_1,((MyBean_2)item).text_1);
                break;
        }


    }
}
