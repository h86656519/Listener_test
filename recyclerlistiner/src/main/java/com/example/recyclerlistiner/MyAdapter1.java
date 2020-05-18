package com.example.recyclerlistiner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder>{
    ArrayList<Integer> arrayList;
    MyListener listener;
    View view;

    public MyAdapter1(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
        return new MyAdapter1.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

//    想在viewholdery做 onclick 但不行，不是這樣做
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;

        ViewHolder(final View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
        }

        @Override
        public void onClick(View v) {
            listener.viewListener(textView);

        }
    }
    public void setOnItemClick(MyListener myListener) {
        this.listener = myListener;
    }
}
