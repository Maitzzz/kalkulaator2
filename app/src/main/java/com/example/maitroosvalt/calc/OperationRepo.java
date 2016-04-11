package com.example.maitroosvalt.calc;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Mait Roosvalt on 11.04.2016.
 */
public class OperationRepo extends Repo<Operations> {

    public OperationRepo(SQLiteDatabase database , String tablename, String[] allColumns) {
        super(database, tablename, allColumns);
    }
    @Override
    public ContentValues entityToContentValues(Operations entity) {
        ContentValues values = new ContentValues();

        values.put(getAllColumns()[1], entity.getOperand());
        values.put(getAllColumns()[2], entity.getLifetimeCounter());

        return  values;
    }

    @Override
    public Operations cursorToEntity(Cursor cursor) {
        Operations operation = new Operations();
        operation.setId(cursor.getLong(0));
        operation.setOperand(cursor.getString(1));
        operation.setLifetimeCounter(cursor.getInt(2));

        return operation;
    }
}
