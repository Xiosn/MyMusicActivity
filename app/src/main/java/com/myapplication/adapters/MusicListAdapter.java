package com.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.myapplication.R;
import com.myapplication.activitys.PlayMusicActivity;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalcaulationRvHeight;

    public MusicListAdapter(Context context,RecyclerView recyclerView){
        mContext=context;
        mRv=recyclerView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_music,viewGroup,false);

        return new ViewHolder(mItemView);
}

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        setRecyclerViewHeight();

        Glide.with(mContext)
                .load("https://img.mukewang.com/5c8f609008b3945b06000338-240-135.jpg")
                .into(viewHolder.iv_List_Icon);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(mContext, PlayMusicActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    /**
     * 1、获取ItemView的高度
     * 2、itemView的数量
     * 3、使用itemViewHeight * itemViewNum = RecyclerView的高度
     */
    private void setRecyclerViewHeight(){

        if (isCalcaulationRvHeight || mRv==null) return;
        isCalcaulationRvHeight = true;
        //获取ItemView的高度
        RecyclerView.LayoutParams itemViewlp=(RecyclerView.LayoutParams)mItemView.getLayoutParams();
        //itemView的数量
        int itemCount=getItemCount();
        //使用itemViewHeight * itemViewNum = RecyclerView的高度
        int recyclerViewHeight=itemViewlp.height * itemCount;
        //设置RecyclerView的高度
        LinearLayout.LayoutParams rvlp=(LinearLayout.LayoutParams)mRv.getLayoutParams();
        rvlp.height=recyclerViewHeight;
        mRv.setLayoutParams(rvlp);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        View itemView;
        ImageView iv_List_Icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView=itemView;
            iv_List_Icon=itemView.findViewById(R.id.iv_List_Icon);
        }
    }
}
