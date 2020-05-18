package com.example.recyclerlistiner;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    ArrayList<Integer> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(5);

        MyAdapter myAdapter = new MyAdapter(arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClick(new MyListener() {
            @Override
            public void itemListener(int i) {
                Toast.makeText(MainActivity.this, "item : " + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void viewListener(MyAdapter.ViewHolder holder) {
                //用回傳的 holder 做操作
                TextView textView;

                Log.i(TAG, "getAdapterPosition: " + holder.getAdapterPosition());
                Log.i(TAG, "getItemId: " + holder.getItemId());
                Log.i(TAG, "getLayoutPosition: " + holder.getLayoutPosition());
                Log.i(TAG, "itemView.getId(): " + holder.itemView.getId());

                if (holder.getAdapterPosition() == 0) {
                    textView = holder.itemView.findViewById(R.id.textView);
                    textView.setText("抓到這個view 了");
                } else {
                    textView = holder.itemView.findViewById(R.id.textView);
                    textView.setText("else");
                }
            }

            @Override
            public void viewListener(View view) {
                //這個method 是給MyAdapter1 用的，跟這邊無關。 這邊不用看
            }
        });


        MyAdapter1 myAdapter1 = new MyAdapter1(arrayList);
        recyclerView.setAdapter(myAdapter1);
        myAdapter1.setOnItemClick(new MyListener() {
            @Override
            public void itemListener(int i) {
                //這邊不用看
            }

            @Override
            public void viewListener(MyAdapter.ViewHolder holder) {
                //這邊不用看
            }

            @Override
            public void viewListener(View view) {
            //想在viewholdery做 onclick 但不行，不是這樣做
            }
        });

    }
}
