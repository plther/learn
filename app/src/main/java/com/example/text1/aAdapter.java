package com.example.text1;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class aAdapter extends RecyclerView.Adapter<aAdapter.VH>{
   List<String> mDatas;
   int heightOfParent;
    public static class VH extends RecyclerView.ViewHolder{
        public final TextView title;
        public VH(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.number1);
        }
    }

    public aAdapter(List<String> data) {
        this.mDatas = data;
    }
    public void onBindViewHolder(VH holder, int position) {
        holder.title.setText(position < mDatas.size() ? mDatas.get(position): "item");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //item 点击事件
            }
        });

    }
        public int getItemCount() {
       return 12 * 7;
    }
//viewtype视图类型 LayoutInflater布局填充器
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        int parentHeight = parent.getHeight();
        int parentWidth = parent.getWidth();
        VH vh = new VH(view);
        ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
        layoutParams.height = parentHeight / 12;
        return vh;
    }
}
