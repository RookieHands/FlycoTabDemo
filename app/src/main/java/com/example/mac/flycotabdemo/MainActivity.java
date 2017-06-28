package com.example.mac.flycotabdemo;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mac.flycotabdemo.Utils.Constant;
import com.example.mac.flycotabdemo.adapter.GankAdapter;
import com.example.mac.flycotabdemo.base.BaseActivity;
import com.example.mac.flycotabdemo.entity.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity  {

    public static final String TAG = "MainActivity";



    @BindView(R.id.vp_main)
    ViewPager mVpMain;
    @BindView(R.id.t2_2)
    CommonTabLayout mT22;
    private int[] mIconUnselectIds = {
            R.mipmap.tab_daily_unselect, R.mipmap.tab_sort_unselect,
            R.mipmap.tab_bonus_unselect, R.mipmap.tab_about_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_daily_select, R.mipmap.tab_sort_select,
            R.mipmap.tab_bonus_select, R.mipmap.tab_about_select};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private long lastBack = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        for (int i = 0; i < Constant.sTabTitles.length; i++) {
            mTabEntities.add(new TabEntity(Constant.sTabTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        GankAdapter adapter = new GankAdapter(getSupportFragmentManager());

        mVpMain.setAdapter(adapter);
        mT22.setTabData(mTabEntities);
        mT22.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mVpMain.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });


        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mT22.setCurrentTab(position);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (lastBack == 0 || System.currentTimeMillis() - lastBack > 2000) {
            Toast.makeText(this, "再按一次返回退出程序", Toast.LENGTH_SHORT).show();
            lastBack = System.currentTimeMillis();
            return;
        }
        super.onBackPressed();
    }




    public void rvDemo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                for (int i = 0; i < 10; i++) {
                    e.onNext(i);
                }

            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer % 7 == 0;
                    }
                })

                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                        Log.d(TAG, "accept: " + integer);
                    }
                });
    }
}
