package com.example.mac.flycotabdemo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mac.flycotabdemo.R;
import com.example.mac.flycotabdemo.bean.DataBean;

import java.util.List;

/**
 * Created by mac on 2017/6/22.
 */

//DataBean.ResultsBean
public class MultiRecyclerAdapter extends BaseQuickAdapter<DataBean.ResultsBean, BaseViewHolder> {


    public MultiRecyclerAdapter(Context context, @Nullable List<DataBean.ResultsBean> data) {
        super(R.layout.rv_item_mind, data);

    }

    @Override
    protected void convert(BaseViewHolder multViewHolder, DataBean.ResultsBean result) {

        if (result != null) {

            multViewHolder.setText(R.id.tv_author, result.getWho());
            multViewHolder.setText(R.id.tv_title, result.getDesc());
            multViewHolder.setText(R.id.tv_type, result.getType());
            multViewHolder.setText(R.id.tv_date, result.getCreatedAt());

        }
    }
}
