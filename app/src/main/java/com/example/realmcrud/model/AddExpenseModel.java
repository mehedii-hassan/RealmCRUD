package com.example.realmcrud.model;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AddExpenseModel extends RealmObject implements Parcelable{

    @PrimaryKey
    private int id;
    private int amount;
    private String comment;
    private long date;

    public AddExpenseModel(int amount, String comment, long date) {
        this.amount = amount;
        this.comment = comment;
        this.date = date;
    }

    public AddExpenseModel() {
        this.amount = amount;
        this.comment = comment;
    }

    protected AddExpenseModel(Parcel in) {
        id = in.readInt();
        amount = in.readInt();
        comment = in.readString();
        date = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(amount);
        dest.writeString(comment);
        dest.writeLong(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AddExpenseModel> CREATOR = new Creator<AddExpenseModel>() {
        @Override
        public AddExpenseModel createFromParcel(Parcel in) {
            return new AddExpenseModel(in);
        }

        @Override
        public AddExpenseModel[] newArray(int size) {
            return new AddExpenseModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "AddExpenseModel{" +
                "id=" + id +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
