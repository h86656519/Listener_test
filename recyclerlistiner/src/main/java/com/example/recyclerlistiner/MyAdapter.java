package com.example.recyclerlistiner;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    ArrayList<Integer> arrayList = new ArrayList<>();
    MyListener listener;
    View view;

    public MyAdapter(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    //抓到view 丟給MyAdapter.ViewHolder ，並建立item 起來
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
        return new MyAdapter.ViewHolder(view);
    }


    //將容器ViewHolder 擦掉重復利用
    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.ViewHolder holder, final int position) {
        String num = arrayList.get(position) +"";
//        holder.textView.setText(num); 一班是寫在這，但也可以用listiner 回傳給acativity 讓 activity 來做控制
        holder.textView.setBackgroundColor(Color.WHITE);

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemListener(position); //用Listener 將 position 傳出去
                holder.textView.setBackgroundColor(Color.BLUE);
                listener.viewListener(holder); //把holder 回傳給activity 做操作
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i("suvini","arrayList.size()" + arrayList.size() );
        return arrayList.size();
    }

    //每個item
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        ViewHolder(final View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }



    public void setOnItemClick(MyListener myListener) {
        this.listener = myListener;
    }


}
