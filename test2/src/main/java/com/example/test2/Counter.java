package com.example.test2;

import android.util.Log;

public class Counter {
    private final static String TAG = Counter.class.getSimpleName();
    private OnFinishLitiner onFinishLitiner = null;

    public interface OnFinishLitiner {
        void onFinish();
    }

    public Counter() {
    }

    public void printCount() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                Log.i(TAG, "printCount" + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnFinishLitiner(OnFinishLitiner litiner) {
        onFinishLitiner = litiner;
    }


}
