package com.example.mac.flycotabdemo.base;

import android.support.v7.app.AppCompatActivity;

import com.example.mac.flycotabdemo.R;
import com.example.mac.flycotabdemo.Utils.StatusBarUtil;


/**
 * Created by Jaeger on 16/2/14.

 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBar();
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }
}
