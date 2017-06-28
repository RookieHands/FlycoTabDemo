package com.example.mac.flycotabdemo.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mac.flycotabdemo.R;
import com.example.mac.flycotabdemo.adapter.MultiRecyclerAdapter;
import com.example.mac.flycotabdemo.view.LoadingView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * Created by mac on 2017/6/22.
 */

public abstract class BaseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    private static final String TAG = "BaseFragment";
    @BindView(R.id.rv_sort_content)
    public RecyclerView rvContent;

    @BindView(R.id.swipeLayout)
    public SwipeRefreshLayout mSwipeRefreshLayout;

    Unbinder unbinder;
    private View view;
    LinearLayoutManager llm;
    public MultiRecyclerAdapter mMultiRecyclerAdapter;
    public String arg;

    public LoadingView loadView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {

            view = inflater.inflate(R.layout.fragment_sort_base, container, false);
            unbinder = ButterKnife.bind(this, view);
            Bundle arguments = getArguments();
            if (arguments != null) {
                arg = arguments.getString("ARG");
            }
            loadView = new LoadingView(getContext());
            loadView.setCancelable(false);
            initRvContent();
            initBGAData();
            initRvItemListener();
        }

        return view;
    }

    protected abstract void initRvItemListener();

    protected abstract void initBGAData();

    private void initRvContent() {
        llm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mMultiRecyclerAdapter = new MultiRecyclerAdapter(getActivity(), null);
        rvContent.setLayoutManager(llm);
        rvContent.setAdapter(mMultiRecyclerAdapter);
        View emptyView = getActivity().getLayoutInflater().inflate(R.layout.rv_item_empty, (ViewGroup) rvContent.getParent(), false);
        mMultiRecyclerAdapter.setEmptyView(emptyView);
        mMultiRecyclerAdapter.openLoadAnimation();
        // mMultiRecyclerAdapter.isFirstOnly(false);//重复执行动画
        mMultiRecyclerAdapter.setOnLoadMoreListener(this, rvContent);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189), Color.BLUE);
    }


    //停止刷新
    public void endLoading() {
        if (mSwipeRefreshLayout != null)
            mSwipeRefreshLayout.setRefreshing(false);
        if (loadView != null)
            loadView.dismiss();
    }

    //下拉刷新
    @Override
    public void onRefresh() {

    }

    //上拉加载
    @Override
    public void onLoadMoreRequested() {

    }


}
