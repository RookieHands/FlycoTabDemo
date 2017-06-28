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
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mac.flycotabdemo.R;
import com.example.mac.flycotabdemo.Utils.StatusBarUtil;
import com.example.mac.flycotabdemo.adapter.TabAdapter;
import com.example.mac.flycotabdemo.base.LazyFragment;
import com.example.mac.flycotabdemo.view.NoPreloadViewPager;
import com.flyco.tablayout.SlidingTabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SortFragment extends Fragment {

    private View view;
    private View fake_status_bar;

    @BindView(R.id.indicator)
    SlidingTabLayout indicator;
    @BindView(R.id.vp_view)
    ViewPager vpView;
    private boolean isPrepared;

    public static SortFragment newInstance() {

        Bundle args = new Bundle();
        SortFragment fragment = new SortFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_sort, null, false);
            ButterKnife.bind(this, view);

            fake_status_bar = view.findViewById(R.id.fake_status_bar);
            fake_status_bar.setBackgroundColor(getResources().getColor(R.color.colorbg));
            isPrepared = true;
            TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager());
            vpView.setAdapter(tabAdapter);
            indicator.setViewPager(vpView);

          //lazyLoad();

        }
        return view;
    }


  /*  @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }

    }*/
}




