package com.example.realmcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.realmcrud.fragments.AddNewExpenseDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnInsert)
    Button btnInsert;

    @BindView(R.id.btnUpdate)
    Button btnUpdate;

    @BindView(R.id.btnDelete)
    Button btnDelete;

    @BindView(R.id.btnRetrieve)
    Button btnRetrieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        btnInsert.setOnClickListener(view -> {

            AddNewExpenseDialogFragment fragment = new AddNewExpenseDialogFragment();
            fragment.show(getSupportFragmentManager(), "ExpenseDialog");
            Toast.makeText(MainActivity.this, "add button clicked", Toast.LENGTH_SHORT).show();
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExpenseListActivity.class));
                Toast.makeText(MainActivity.this, "View all expense clicked", Toast.LENGTH_SHORT).show();

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExpenseListActivity.class));
                Toast.makeText(MainActivity.this, "View all expense clicked", Toast.LENGTH_SHORT).show();

            }
        });


    }
}