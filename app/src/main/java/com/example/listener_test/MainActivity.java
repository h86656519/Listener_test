package com.example.listener_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Person john =  new Person(new Phone(){ //給john phone
             @Override
             public void callPhone() {
                 //當john 回家後，我要做的事情
             }
         });


         john.goHome(); // 請求john 回家
    }


}
