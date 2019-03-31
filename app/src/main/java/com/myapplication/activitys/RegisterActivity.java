package com.myapplication.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.myapplication.R;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //设置手机应用内部状态栏字体图标为黑色
        changeStatusBarTextImgColor(true);

        initView();
    }


    /**
     * 初始化View
     */
    private void initView(){
        initNavBar(true,"注册",false);
    }
}
