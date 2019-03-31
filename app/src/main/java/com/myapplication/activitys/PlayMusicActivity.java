package com.myapplication.activitys;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.myapplication.R;
import com.myapplication.views.PlayMusicView;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {

    private ImageView mIvBg;
    private PlayMusicView mPlayMusicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

//        隐藏statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();
    }

    private void initView(){
        mIvBg=findViewById(R.id.iv_bg);
        //glide-transformations

        Glide.with(this)
                .load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=984591001,2337294149&fm=26&gp=0.jpg")
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25,10)))
                .into(mIvBg);
        mPlayMusicView=findViewById(R.id.play_music_view);
        mPlayMusicView.setMusicIcon("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=984591001,2337294149&fm=26&gp=0.jpg");
        mPlayMusicView.playMusic("http://win.web.rb01.sycdn.kuwo.cn/5015ded180b62df94f62ae3099b3016a/5c9f8d8a/resource/n3/20/9/3120834944.mp3");
    }
    /**
     * 后退按钮点击事件
     */
    public void onBackClick(View v){
        onBackPressed();
    }

}
