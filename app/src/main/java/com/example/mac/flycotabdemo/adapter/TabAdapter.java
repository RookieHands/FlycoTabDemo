/*
 * Copyright (C) 2015 Paul Burke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.mac.flycotabdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mac.flycotabdemo.Utils.Constant;
import com.example.mac.flycotabdemo.fragment.fragment.SortItemFragment;


/**
 * 文 件 名: TabAdapter
 * 描   述：分类数据显示界面SlidingTablayout PagerAdapter
 */
public class TabAdapter extends FragmentPagerAdapter {

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {


        return SortItemFragment.newInstance(Constant.sCategoryList.get(position));

    }

    @Override
    public int getCount() {
        return Constant.sCategoryList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Constant.sCategoryList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        //return super.getItemPosition(object);
        return POSITION_NONE;
    }
}
