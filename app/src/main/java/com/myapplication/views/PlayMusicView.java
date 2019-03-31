package com.myapplication.views;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.myapplication.R;
import com.myapplication.helps.MediaPlayerHelp;

public class PlayMusicView extends FrameLayout {

    private Context mContext;
    private MediaPlayerHelp mMediaPlaerHelp;
    private boolean isPlaying;
    private String mPath;
    private View mView;
    private FrameLayout mFlPlayMusic;
    private ImageView mIvIcon,mIvNeedle,mIvPlay;

    private Animation mPlayMusicAnim,mPlayNeedleAnim,mStopNeedleAnim;


    public PlayMusicView(Context context) {
        super(context);
        init(context);
    }

    public PlayMusicView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PlayMusicView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PlayMusicView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
//        MediaPlayer
        mContext=context;
        mView=LayoutInflater.from(mContext).inflate(R.layout.play_music,this,false);
        mFlPlayMusic=mView.findViewById(R.id.fl_play_music);
        mFlPlayMusic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                trigger();
            }
        });
        mIvNeedle=mView.findViewById(R.id.iv_needle);
        mIvIcon=mView.findViewById(R.id.iv_icon);
        mIvPlay=mView.findViewById(R.id.iv_play);

        /**
         * 1、定义所需要执行的动画
         *      1、光盘转动的动画
         *      2、指针指向光盘的动画
         *      3、指针离开光盘的动画
         * 2、startAnimation(让View执行定义的动画)
         */


        //初始化动画
        mPlayMusicAnim = AnimationUtils.loadAnimation(mContext,R.anim.play_music_anim);
        mPlayNeedleAnim = AnimationUtils.loadAnimation(mContext,R.anim.play_needle_anim);
        mStopNeedleAnim = AnimationUtils.loadAnimation(mContext,R.anim.stop_needle_anim);

        addView(mView);

        mMediaPlaerHelp=MediaPlayerHelp.getInstance(mContext);
    }


    /**
     * 切换播放状态
     */
    private void trigger(){

        if (isPlaying){
            stopMusic();
        }else{
            playMusic(mPath);
        }
    }

    /**
     * 播放音乐
     */
    public void playMusic(String path){
        mPath=path;
        isPlaying=true;
        mIvPlay.setVisibility(View.GONE);
        mFlPlayMusic.startAnimation(mPlayMusicAnim);//执行动画
        mIvNeedle.startAnimation(mPlayNeedleAnim);


        /**
         * 1、当前音乐是否已经在播放的音乐
         * 2、如果当前的音乐已经是在播放的音乐的话，那么就直接执行start方法
         * 3、如果当前播放的音乐不是需要播放的音乐，那么就调用setPath的方法
         */
        if (mMediaPlaerHelp.getPath()!=null
        && mMediaPlaerHelp.getPath().equals(path)){
            mMediaPlaerHelp.start();
        }else{
            mMediaPlaerHelp.setPath(path);
            mMediaPlaerHelp.setOnMediaPlayerHelperListener(new MediaPlayerHelp.OnMediaPlayerHelperListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlaerHelp.start();
                }
            });
        }
    }

    /**
     * 停止音乐
     */
    public void stopMusic(){
        isPlaying=false;
        mIvPlay.setVisibility(View.VISIBLE);
        mFlPlayMusic.clearAnimation();
        mIvNeedle.startAnimation(mStopNeedleAnim);

        mMediaPlaerHelp.pause();
    }


    /**
     * 设置光盘中显示的音乐封面图片
     */
    public void setMusicIcon(String icon){
        Glide.with(mContext)
                .load(icon)
                .into(mIvIcon);
    }
}
