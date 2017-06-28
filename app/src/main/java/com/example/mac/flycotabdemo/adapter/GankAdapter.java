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
package com.example.mac.flycotabdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mac.flycotabdemo.Utils.Constant;
import com.example.mac.flycotabdemo.fragment.AboutFragment;
import com.example.mac.flycotabdemo.fragment.DailyFragment;
import com.example.mac.flycotabdemo.fragment.MindFragment;
import com.example.mac.flycotabdemo.fragment.SortFragment;


/**
 * 文 件 名: GankAdapter

 * 描   述：主界面ViewPagerAdapter
 */
public class GankAdapter extends FragmentPagerAdapter {
    public GankAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return DailyFragment.newInstance();
            case 1:
                return SortFragment.newInstance();
            case 2:
                return MindFragment.newInstance();
            case 3:
                return AboutFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return Constant.sTabTitles.length;
    }
}
