package com.example.admin.sqldisplaydata;

import java.util.ArrayList;


import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private DatabaseHandler mHelper;
    private SQLiteDatabase dataBase;

    //variables to hold staff records
    private ArrayList<String> stafid = new ArrayList<String>();
    private ArrayList<String> nama = new ArrayList<String>();
    private ArrayList<String> jbt = new ArrayList<String>();

    private ListView userList;
    private AlertDialog.Builder build;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = (ListView) findViewById(R.id.listview1);

        mHelper = new DatabaseHandler(this);


    }

    @Override
    protected void onResume() {
        //refresh data for screen is invoked/displayed
        displayData();
        super.onResume();
    }

    /**
     * displays data from SQLite
     */
    private void displayData() {
        dataBase = mHelper.getWritableDatabase();
        //the SQL command to fetched all records from the table
        Cursor mCursor = dataBase.rawQuery("SELECT * FROM "
                + DatabaseHandler.TABLE_NAME, null);

        //reset variables
        stafid.clear();
        nama.clear();
        jbt.clear();

        //fetch each record
        if (mCursor.moveToFirst()) {
            do {
                //get data from field
                stafid.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHandler.STAFID)));
                nama.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHandler.NAMA)));
                jbt.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHandler.JBT)));

            } while (mCursor.moveToNext());
            //do above till data exhausted
        }

        //display to screen
        DisplayAdapter disadpt = new DisplayAdapter(MainActivity.this, stafid,nama,jbt);
        userList.setAdapter(disadpt);
        mCursor.close();
    }//end displayData


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
