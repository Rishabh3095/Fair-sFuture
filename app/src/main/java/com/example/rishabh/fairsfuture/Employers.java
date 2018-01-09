package com.example.rishabh.fairsfuture;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Employers extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    Button read, submit, dash;
    private MyOpenHelper mMyOpenHelper;
    private SQLiteDatabase mSqlDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employers);

        e1 = (EditText) findViewById(R.id.editText9);
        e2 = (EditText) findViewById(R.id.editText10);
        e3 = (EditText) findViewById(R.id.editText11);
        e4 = (EditText) findViewById(R.id.editText12);
        e5 = (EditText) findViewById(R.id.editText13);
        e6 = (EditText) findViewById(R.id.editText14);
        e7 = (EditText) findViewById(R.id.editText18);
        e8 = (EditText) findViewById(R.id.editText19);
        e9 = (EditText) findViewById(R.id.editText20);
        e10 = (EditText) findViewById(R.id.editText21);
        e11 = (EditText) findViewById(R.id.editText22);
        e12 = (EditText) findViewById(R.id.editText23);

        t1 = (TextView) findViewById(R.id.textView11);
        t2 = (TextView) findViewById(R.id.textView14);
        t3 = (TextView) findViewById(R.id.textView15);
        t4 = (TextView) findViewById(R.id.textView16);
        t5 = (TextView) findViewById(R.id.textView17);
        t6 = (TextView) findViewById(R.id.textView18);
        t7 = (TextView) findViewById(R.id.textView6);
        t8 = (TextView) findViewById(R.id.textView20);
        t9 = (TextView) findViewById(R.id.textView21);

        read = (Button) findViewById(R.id.button4);
        submit = (Button) findViewById(R.id.button6);
        dash = (Button) findViewById(R.id.button7);

        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Employers.this, AppSymbol.class));
            }
        });

        mMyOpenHelper = new MyOpenHelper(Employers.this, "EMPDB", null, 1);
        mSqlDb = mMyOpenHelper.getWritableDatabase();


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = mSqlDb.query("Employers", null, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    String s1 = cursor.getString(1);
                    e1.setText(s1);
                    String s2 = cursor.getString(2);
                    e2.setText(s2);
                    String s3 = cursor.getString(3);
                    e3.setText(s3);
                    String s4 = cursor.getString(4);
                    e4.setText(s4);
                    String s5 = cursor.getString(5);
                    e5.setText(s5);
                    String s6 = cursor.getString(6);
                    e6.setText(s6);
                }

                Cursor cursor1 = mSqlDb.query("Booth", null, null, null, null, null, null);
                while (cursor1.moveToNext()) {
                    String s1 = cursor1.getString(1);
                    e12.setText(s1);
                    String s2 = cursor1.getString(2);
                    e7.setText(s2);
                    String s3 = cursor1.getString(3);
                    e8.setText(s3);
                    String s4 = cursor1.getString(4);
                    e9.setText(s4);
                    String s5 = cursor1.getString(5);
                    e10.setText(s5);
                    String s6 = cursor1.getString(6);
                    e11.setText(s6);
                }

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("E1", e1.getText().toString());
                cv.put("E2", e2.getText().toString());
                cv.put("E3", e3.getText().toString());
                cv.put("E4", e4.getText().toString());
                cv.put("E5", e5.getText().toString());
                cv.put("E6", e6.getText().toString());
                long id = mSqlDb.insert("Employers", null, cv);
                Toast.makeText(Employers.this, String.valueOf(id), Toast.LENGTH_LONG).show();

                ContentValues cv1 = new ContentValues();
                cv1.put("B1", e12.getText().toString());
                cv1.put("B2", e7.getText().toString());
                cv1.put("B3", e8.getText().toString());
                cv1.put("B4", e9.getText().toString());
                cv1.put("B5", e10.getText().toString());
                cv1.put("B6", e11.getText().toString());
                long id1 = mSqlDb.insert("Booth", null, cv1);
                Toast.makeText(Employers.this, String.valueOf(id1), Toast.LENGTH_LONG).show();

            }
        });


    }
}
