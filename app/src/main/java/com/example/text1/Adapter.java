package com.example.text1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.VH> {
    List<String> mDatas;
    // 行数
    int rows;
    // 列数
    int columns;
    int heightOfParent;
    public Adapter(List<String> data) {
        this.mDatas = data;
    }
    public Adapter(List<String> data, int rows, Boolean f) {
        this.mDatas = data;
        this.rows = rows;
        this.columns = 1;
    }
    public Adapter(List<String> data, int columns) {
        this.mDatas = data;
        this.columns = columns;
        this.rows = 1;
    }

    public Adapter(List<String> data, int rows, int columns) {
        this.mDatas = data;
        this.rows = rows;
        this.columns = columns;
    }

    public void onBindViewHolder(VH holder, int position) {
        holder.title.setText(position < mDatas.size() ? mDatas.get(position) : "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //item 点击事件
            }
        });

    }

    public int getItemCount() {
        return  rows* columns;
    }

    //viewtype视图类型 LayoutInflater布局填充器
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        int parentHeight = parent.getHeight();
        int parentWidth = parent.getWidth();
        VH vh = new VH(view);
        ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
        layoutParams.height = parentHeight / rows;
        layoutParams.width = parentWidth / columns;
        return vh;
    }
    public static class VH extends RecyclerView.ViewHolder {
        public final TextView title;

        public VH(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.number1);
        }
    }
}
