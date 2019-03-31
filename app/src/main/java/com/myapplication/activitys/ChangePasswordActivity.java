package com.myapplication.activitys;


import android.os.Bundle;
import com.myapplication.R;

public class ChangePasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        //设置手机应用内部状态栏字体图标为黑色
        changeStatusBarTextImgColor(true);

        initView();
    }

    private void initView(){
        initNavBar(true,"修改密码",false);
    }
}
