package com.example.realmcrud;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realmcrud.adapters.ExpenseListAdapter;
import com.example.realmcrud.database.RealmDatabaseManager;
import com.example.realmcrud.model.AddExpenseModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class ExpenseListActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<AddExpenseModel> expenseList;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_list);
        ButterKnife.bind(this);

        expenseList = new RealmDatabaseManager().getExpanceList();
        Toast.makeText(ExpenseListActivity.this, "" + expenseList.size(), Toast.LENGTH_SHORT).show();
        ExpenseListAdapter listAdapter = new ExpenseListAdapter(this, expenseList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

    }
}