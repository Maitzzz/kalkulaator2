package com.example.maitroosvalt.calc;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mait Roosvalt on 11.04.2016.
 */
public abstract class Repo<T> {

    private SQLiteDatabase database;
    private String tablename;
    private String[] allColumns;

    public Repo(SQLiteDatabase database, String tablename, String[] allColumns) {
        this.database = this.database;
        this.tablename = this.tablename;
        this.allColumns = this.allColumns;
    }

    public String[] getAllColumns() {
        return allColumns;
    }

    public T add(T entity) {
        ContentValues values = entityToContentValues(entity);
        long insertId = database.insert(tablename, null,
                values);

        return getById(insertId);
    }

    public List<T> all() {
        ArrayList<T> list = new ArrayList<T>();

        Cursor cursor = database.query(tablename,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            T entity = cursorToEntity(cursor);
            list.add(entity);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return list;
    }

    public T getById(long id) {
        Cursor cursor = database.query(tablename,
                allColumns, allColumns[0] + " = " + id, null,
                null, null, null);
        cursor.moveToFirst();

        T entity = cursorToEntity(cursor);
        cursor.close();
        return entity;
    }

    public void update(T entity) {

    }

    public void delete(long id) {

    }

    public void delete(T entity) {

    }

    public abstract ContentValues entityToContentValues(T entity);

    public abstract T cursorToEntity(Cursor cursor);
}
