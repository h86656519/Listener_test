package com.example.recyclerlistiner;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public interface MyListener {
    void itemListener(int i);

    void viewListener(MyAdapter.ViewHolder holder);

    void viewListener(View view);
}
