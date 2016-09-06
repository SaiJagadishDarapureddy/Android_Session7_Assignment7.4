package com.example.admin.sqldisplaydata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    //define all the constants
    static String DATABASE_NAME="fstmdirektori";
    public static final String TABLE_NAME="staflist";
    //these are the lit of fields in the table
    public static final String STAFID="stafid";
    public static final String NAMA="namapenuh";
    public static final String JBT="jabatan";


    public DatabaseHandler(Context context) {
        //create the database
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create the table
        String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+STAFID+" INTEGER PRIMARY KEY, "+NAMA+" TEXT, "+JBT+" TEXT)";
        db.execSQL(CREATE_TABLE);
        //populate dummy data
        db.execSQL("INSERT INTO staflist (stafid, namapenuh, jabatan) VALUES('1', 'VIJAY', 'KAKANI');");
        db.execSQL("INSERT INTO staflist (stafid, namapenuh, jabatan) VALUES('2', 'MAHESH', 'ANKOLU');");
        db.execSQL("INSERT INTO staflist (stafid, namapenuh, jabatan) VALUES('3', 'KANNA KUMAR', 'DASETTI');");
        db.execSQL("INSERT INTO staflist (stafid, namapenuh, jabatan) VALUES('4', 'SAI NARAYANA', 'BUJJA');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onUpgrade remove the existing table, and recreate and populate new data
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}

