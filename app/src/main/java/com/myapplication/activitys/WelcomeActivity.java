package com.myapplication.activitys;

import android.content.Intent;
import android.os.Bundle;
import com.myapplication.R;
import java.util.Timer;
import java.util.TimerTask;

//1、延迟3秒
//2、跳转页面
public class WelcomeActivity extends BaseActivity {

    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
    }


    /**
     * 初始化
     */
    private void init(){
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                //toMain();
                toLogin();
            }
        },2*1000);
    }

    /**
     * 跳转到MainActivity
     */
    private void toMain(){
        Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 跳转到LoginActivity
     */
    private void toLogin(){
        Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
