package com.example.realmcrud.database;

import android.util.Log;
import android.widget.Toast;

import com.example.realmcrud.model.AddExpenseModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmDatabaseManager {
    private static final String TAG = "RealmDatabaseManager";
    private static Realm realm;

    public RealmDatabaseManager() {
        realm = Realm.getDefaultInstance();
    }

    public void insertExpance(AddExpenseModel expense) {
        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    realm.copyToRealmOrUpdate(expense);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateExpense(AddExpenseModel expenseModel) {
        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }

        AddExpenseModel addExpenseModel = realm.where(AddExpenseModel.class)
                .equalTo("id",expenseModel.getId()).findFirst();

        if(addExpenseModel != null){
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    try {
                        realm.copyToRealmOrUpdate(addExpenseModel);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    public List<AddExpenseModel> getExpanceList() {
        realm = Realm.getDefaultInstance();
        try {
            RealmResults<AddExpenseModel> movieRealmResults = realm.where(AddExpenseModel.class).findAll();
            return movieRealmResults;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
