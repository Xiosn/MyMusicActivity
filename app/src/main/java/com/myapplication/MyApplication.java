package com.myapplication;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

//存储系统的应用信息
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}
