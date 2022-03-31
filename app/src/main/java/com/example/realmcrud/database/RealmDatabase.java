package com.example.realmcrud.database;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;

public class RealmDatabase extends AppCompatActivity {

    public static volatile Realm realm;
    public static Context mContext;

    public static void init(Context context) {
        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }
        mContext = context;
    }
}
