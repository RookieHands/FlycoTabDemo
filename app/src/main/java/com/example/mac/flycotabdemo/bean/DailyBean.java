
package com.example.mac.flycotabdemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class DailyBean implements MultiItemEntity {

    public static final int TEXT = 0;
    public static final int IMG_TEXT = 1;


    private final int itemType;
    private String content;

    public DailyBean(int itemType, String content) {
        this.content = content;
        this.itemType = itemType;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
