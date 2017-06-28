/**
 * Copyright 2017 yidong
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.mac.flycotabdemo.fragment.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mac.flycotabdemo.Utils.ToastUtil;
import com.example.mac.flycotabdemo.activity.WebActivity;
import com.example.mac.flycotabdemo.base.BaseFragment;
import com.example.mac.flycotabdemo.bean.DataBean;
import com.example.mac.flycotabdemo.http.HttpMethods;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * 描   述：分类阅读item
 */
public class SortItemFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {

    String TAG = "SortItemFragment";
    private List<DataBean.ResultsBean> results = new ArrayList<>();
    int pagenum = 1;
    int refreshType = 0;
    int loadMoreType = 1;
    String pagesize = "15";


    public static SortItemFragment newInstance(String arg) {

        Bundle args = new Bundle();
        args.putString("ARG", arg);
        SortItemFragment fragment = new SortItemFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initRvItemListener() {
        if (mMultiRecyclerAdapter != null)
            mMultiRecyclerAdapter.setOnItemClickListener(this);
    }

    @Override
    protected void initBGAData() {
        getContent(arg, 1, refreshType);
    }


    public void getContent(String category, final int pagenum, final int type) {

        Observer<DataBean> observer = new Observer<DataBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (loadView != null)
                    loadView.show();
            }

            @Override
            public void onNext(DataBean httpBean) {
                Log.d(TAG, "onNext: ");
                if (type == refreshType) {//下拉刷新
                    results.clear();
                    mMultiRecyclerAdapter.setEnableLoadMore(true);
                    results.addAll(httpBean.getResults());
                    mMultiRecyclerAdapter.setNewData(results);
                } else if (type == loadMoreType) { //上拉加载

                    mSwipeRefreshLayout.setEnabled(true);
                    Log.d(TAG, "pagenum: " + pagenum);
                    if (pagenum >= 4) { //默认只加载三页

                        mMultiRecyclerAdapter.loadMoreEnd();

                    } else {
                        mMultiRecyclerAdapter.loadMoreComplete();
                        results.addAll(httpBean.getResults());
                        mMultiRecyclerAdapter.setNewData(results);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                endLoading();
                if (type == loadMoreType) {
                    mMultiRecyclerAdapter.loadMoreFail();
                }
                ToastUtil.showToast(getContext(), "网络异常");
            }
            @Override
            public void onComplete() {
                endLoading();
                Log.d(TAG, "onComplete: ");
            }
        };

        HttpMethods.getInstance().getSortItemData(observer, category, pagesize, pagenum);

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra("url", results.get(position).getUrl());
        getContext().startActivity(intent);
    }

    //下拉刷新
    @Override
    public void onRefresh() {
        super.onRefresh();

        mMultiRecyclerAdapter.setEnableLoadMore(false);
        pagenum = 1;
        getContent(arg, pagenum, refreshType);
    }

    //上拉加载
    @Override
    public void onLoadMoreRequested() {
        super.onLoadMoreRequested();
        mSwipeRefreshLayout.setEnabled(false);
        getContent(arg, ++pagenum, loadMoreType);
    }
}




