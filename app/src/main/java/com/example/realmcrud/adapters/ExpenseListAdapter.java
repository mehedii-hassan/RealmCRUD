package com.example.realmcrud.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realmcrud.R;
import com.example.realmcrud.fragments.AddNewExpenseDialogFragment;
import com.example.realmcrud.model.AddExpenseModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ExpenseListAdapter extends RecyclerView.Adapter<ExpenseListAdapter.ExpenseViewHolder> {


    Context context;
    List<AddExpenseModel> expenseList;

    public ExpenseListAdapter(Context context, List<AddExpenseModel> expenseList) {
        this.context = context;
        this.expenseList = expenseList;
    }


    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_expense_list_item_design, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {

        AddExpenseModel model = expenseList.get(position);
        int uid = holder.getAdapterPosition();


        holder.tvExpenseAmount.setText(String.valueOf(model.getAmount()));
        holder.tvExpenseComment.setText(model.getComment());


        Date date = new Date(model.getDate());
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy hh.mm aa");
        holder.tvCurrentDateAndTime.setText(df2.format(date));

        holder.imgBtnMenu.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(context, view);
            popupMenu.inflate(R.menu.rv_row_item_menu);
            popupMenu.setForceShowIcon(true);
            popupMenu.show();

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.delete:

                            Toast.makeText(context, "Successful", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.update:
                            AddNewExpenseDialogFragment fragment = new AddNewExpenseDialogFragment();
                            fragment.show(((FragmentActivity) context).getSupportFragmentManager(), "ExpenseDialog");
                            if(model != null){
                                // fragment.setText(model);
                                fragment.setAddExpenseModel(model,position, true);
                            }
                            break;
                    }
                    return false;
                }
            });
        });

    }


    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public class ExpenseViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvExpenseAmount)
        TextView tvExpenseAmount;

        @BindView(R.id.tvExpenseComment)
        TextView tvExpenseComment;

        @BindView(R.id.imgBtnMenu)
        AppCompatImageButton imgBtnMenu;

        @BindView(R.id.tvCurrentDateAndTime)
        TextView tvCurrentDateAndTime;


        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
