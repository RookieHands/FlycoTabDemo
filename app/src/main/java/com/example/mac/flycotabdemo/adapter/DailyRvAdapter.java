package com.example.mac.flycotabdemo.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mac.flycotabdemo.R;
import com.example.mac.flycotabdemo.bean.DailyBean;

import java.util.List;

/**
 * Created by mac on 2017/6/27.
 */

public class DailyRvAdapter extends BaseMultiItemQuickAdapter<DailyBean, BaseViewHolder> {


    public DailyRvAdapter(List<DailyBean> data) {
        super(data);

        addItemType(DailyBean.TEXT, R.layout.item_daily_text);
        addItemType(DailyBean.IMG_TEXT, R.layout.item_img_text_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, DailyBean item) {

        switch (helper.getItemViewType()) {
            case DailyBean.TEXT:

                helper.setText(R.id.tv, item.getContent());

                break;

            case DailyBean.IMG_TEXT:

                helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
                helper.setText(R.id.tv, item.getContent());

                break;
        }
    }
}
