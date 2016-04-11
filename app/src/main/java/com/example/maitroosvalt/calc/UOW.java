package com.example.maitroosvalt.calc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by Mait Roosvalt on 11.04.2016.
 */
public class UOW {
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;

    public OperationRepo operationRepo;

    public UOW(Context context) {
        dbHelper = new SQLiteHelper(context);
        database = dbHelper.getReadableDatabase();


    }

    public void open() throws SQLException {
        database = dbHelper.getReadableDatabase();
        operationRepo = new OperationRepo(database, dbHelper.TABLE_OPERATIONS, dbHelper.ALLCOLUMNS_OPERATIONS);



    }
}
