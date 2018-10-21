package work.worktest.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import work.worktest.fragment.BaseFragement;

/**
 * Created by lyh on 2018/10/18.
 */

public class MyPagerAdapter extends PagerAdapter {

     private   List<BaseFragement> mList;

    public MyPagerAdapter(List<BaseFragement> list){
        mList=list;
    }




    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }



    // 1. 返回要显示的条目内容, 创建条目
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // container: 容器: ViewPager
        // position: 当前要显示条目的位置 0 -> 4

//			newPosition = position % 5
        int newPosition = position % mList.size();

        View view = mList.get(newPosition).getView();
        // a. 把View对象添加到container中
        container.addView(view);
        // b. 把View对象返回给框架, 适配器
        return view; // 必须重写, 否则报异常
    }

    // 2. 销毁条目
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // object 要销毁的对象
        container.removeView((View)object);
    }



}
