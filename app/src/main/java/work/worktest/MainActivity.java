package work.worktest;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import work.worktest.bean.BaseBean;
import work.worktest.bean.ItemType;
import work.worktest.bean.MyBean_1;
import work.worktest.bean.MyBean_2;
import work.worktest.fragment.BaseFragement;
import work.worktest.loader.GlideImageLoader;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.view_pager)
//    ViewPager mViewPager;
//    @BindView(R.id.indicator)
//    CircleIndicator mIndicator;


    @BindView(R.id.abl_main)
    AppBarLayout mAppBar;
    @BindView(R.id.banner)
    Banner banner;



    @BindView(R.id.rv_list)
    RecyclerView mRvList;


//    @BindView(R.id.rv_recyclerView)
//    RecyclerView mRvRecyclerView;


    private ArrayList<BaseFragement> mBaseFragements;
    private Thread mThread;
    private List<URL> mList;
    private ArrayList<BaseBean> mBaseBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        initView();

    }

    private void initView() {
//        TestFragment_1 testFragment_1 = new TestFragment_1();
//        TestFragment_2 testFragment_2 = new TestFragment_2();
//        TestFragment_3 testFragment_3 = new TestFragment_3();
//
//        mBaseFragements = new ArrayList<>();
//        mBaseFragements.add(testFragment_1);
//        mBaseFragements.add(testFragment_2);
//        mBaseFragements.add(testFragment_3);

        mList = new ArrayList<URL>();

        try {
            mList.add(new URL("http://pic14.nipic.com/20110605/1369025_165540642000_2.jpg"));
            mList.add(new URL("http://img.zcool.cn/community/0125fd5770dfa50000018c1b486f15.jpg@1280w_1l_2o_100sh.jpg"));
            mList.add(new URL("http://pic29.nipic.com/20130511/9252150_174018365301_2.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
//        //设置图片集合

        banner.setImages(mList);
//        //设置banner动画效果
//        banner.setBannerAnimation(Transformer.DepthPage);
//        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(titles);


        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
//        //设置指示器位置（当banner模式中有指示器时）
//        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        mBaseBeans = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            mBaseBeans.add(new MyBean_1(ItemType.typeOne, i + ""));
            mBaseBeans.add(new MyBean_2(ItemType.typeTwo, i + "", (i++) + ""));
        }


    }


    //如果你需要考虑更好的体验，可以这么操作
    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }
}
