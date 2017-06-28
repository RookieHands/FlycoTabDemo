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
package com.example.mac.flycotabdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mac.flycotabdemo.R;
import com.example.mac.flycotabdemo.Utils.StatusBarUtil;
import com.example.mac.flycotabdemo.adapter.DailyRvAdapter;
import com.example.mac.flycotabdemo.bean.DailyBean;
import com.example.mac.flycotabdemo.bean.DataBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;




/**
 * 描   述：每日干货数据
 */
public class DailyFragment extends Fragment {

    private View view;

    List<DailyBean> data  = new ArrayList<>();
public static final String TAG = "onCreateView";

    @BindView(R.id.rv_daily)
    public RecyclerView rv_daily;

    public static DailyFragment newInstance() {

        Bundle args = new Bundle();
        DailyFragment fragment = new DailyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_daily, container, false);

        ButterKnife.bind(this, view);
        RelativeLayout rl_container = (RelativeLayout) view.findViewById(R.id.rl_container);
        StatusBarUtil.setTranslucentForImageViewInFragment(getActivity(), 0, rl_container);


        LinearLayoutManager linearLayoutManager  =new LinearLayoutManager(getContext());
     //   GridLayoutManager linearLayoutManager  =new GridLayoutManager(getContext(),3);


        rv_daily.setLayoutManager(linearLayoutManager);

        for (int i = 0; i <50 ; i++) {

            DailyBean bean  = new DailyBean(i%2,"wei");

            data.add(bean);
        }

        DailyRvAdapter dailyRvAdapter = new DailyRvAdapter(data);
        dailyRvAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        dailyRvAdapter.isFirstOnly(false);//重复执行动画

        rv_daily.setAdapter(dailyRvAdapter);

        return view;
    }
}




