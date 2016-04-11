package com.example.maitroosvalt.calc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Mait Roosvalt on 11.04.2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "calc.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TAG = SQLiteHelper.class.getName();
    private final Context context;

    public static final String TABLE_OPERATIONS = "operations";
    public static final String COLUMN_OPERATIONS_OPERAND_ID = "_id";
    public static final String COLUMN_OPERATIONS_OPERAND = "operand";
    public static final String COLUMN_OPERATIONS_LIFETIMECOUNTER = "lifetimeCounter";

    public static final String[] ALLCOLUMNS_OPERATIONS = {COLUMN_OPERATIONS_OPERAND_ID, COLUMN_OPERATIONS_OPERAND, COLUMN_OPERATIONS_LIFETIMECOUNTER};

    public static final String TABLE_DAYSTATISTICS = "daystatistics";
    public static final String COLUMN_DAYSTATISTIC_ID = "_id";
    public static final String COLUMN_DAYSTATISTIC_OPERANDID = "operandId";
    public static final String COLUMN_DAYSTATISTIC_DAYSTAMP = "dayStamp";
    public static final String COLUMN_DAYSTATISTIC_DAYCOUNTER = "dayCounter";

    public static final String[] ALLCOLUMNS_DAYSTATISTICS = {COLUMN_DAYSTATISTIC_ID, COLUMN_DAYSTATISTIC_OPERANDID, COLUMN_DAYSTATISTIC_DAYSTAMP, COLUMN_DAYSTATISTIC_DAYCOUNTER};

    public static final String TABLE_CALCULATIONS = "daystatistics";
    public static final String COLUMN_CALCULATIONS_ID = "_id";
    public static final String COLUMN_CALCULATIONS_OPERANDID = "operandId";
    public static final String COLUMN_CALCULATIONS_TIMESTAMP = "timestamp";
    public static final String COLUMN_CALCULATIONS_NUM1 = "num1";
    public static final String COLUMN_CALCULATIONS_NUM2 = "num2";
    public static final String COLUMN_CALCULATIONS_RES = "res";

    public static final String[] ALLCOLUMNS_CALCULATIONS = {COLUMN_CALCULATIONS_ID, COLUMN_CALCULATIONS_OPERANDID, COLUMN_CALCULATIONS_NUM1, COLUMN_CALCULATIONS_NUM2, COLUMN_CALCULATIONS_RES,  COLUMN_CALCULATIONS_TIMESTAMP};

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    // Database creation sql statement
    private static final String DATABASE_CREATE_DAYSTATISTICS = "create table "
            + TABLE_OPERATIONS + "("
            + COLUMN_OPERATIONS_OPERAND_ID
            + " integer primary key autoincrement, "
            + COLUMN_OPERATIONS_OPERAND + " text not null"
            + COLUMN_OPERATIONS_LIFETIMECOUNTER + " integer);";


    // Database creation sql statement
    private static final String DATABASE_CREATE_OPERATIONS = "create table "
            + TABLE_DAYSTATISTICS + "("
            + COLUMN_DAYSTATISTIC_ID
            + " integer primary key autoincrement, "
            + COLUMN_DAYSTATISTIC_OPERANDID + " integer not null"
            + COLUMN_DAYSTATISTIC_DAYSTAMP + " integer"
            + COLUMN_DAYSTATISTIC_DAYCOUNTER + " integer);";


    // Database creation sql statement
    private static final String DATABASE_CREATE_CALCULATIONS = "create table "
            + TABLE_CALCULATIONS + "("
            + COLUMN_CALCULATIONS_ID
            + " integer primary key autoincrement, "
            + COLUMN_CALCULATIONS_OPERANDID + " integer not null"
            + COLUMN_CALCULATIONS_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
            + COLUMN_CALCULATIONS_NUM1 + " float "
            + COLUMN_CALCULATIONS_NUM1 + " float"
            + COLUMN_CALCULATIONS_NUM2 + " float"
            + COLUMN_CALCULATIONS_RES + " float);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_OPERATIONS);
        db.execSQL(DATABASE_CREATE_DAYSTATISTICS);
        db.execSQL(DATABASE_CREATE_CALCULATIONS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(SQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_CREATE_OPERATIONS);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_CREATE_DAYSTATISTICS);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_CREATE_CALCULATIONS);
        onCreate(db);
    }
}
