package com.example.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Counter counter = new Counter();
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);

        counter.setOnFinishLitiner(new OnFinishLitiner() {
            @Override
            public void onFinish() {
                Log.d(TAG, "Counter Finish!!");
                textView.setText("Finish");
            }
        });
        counter.printCount();
    }


}
