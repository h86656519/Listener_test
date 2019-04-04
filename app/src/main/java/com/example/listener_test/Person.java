package com.example.listener_test;

import android.util.Log;

public class Person {
    Phone card;

    public Person(Phone card) {
        this.card = card;
    }

    public void goHome() {
        Log.i("a", "walking...");
        Log.i("a", "open door");
        Log.i("a", "take phone");
        card.callPhone();
    }

    public void goToSchool() {
        Log.i("a", "walking...");
    }

    public void goCompany() {
        Log.i("a", "walking...");
        card.callPhone();
    }

}
