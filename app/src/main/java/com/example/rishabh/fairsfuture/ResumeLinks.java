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
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class ResumeLinks extends AppCompatActivity {

    private SensorManager sm;
    private float acelVal; // current acceleration including gravity
    private float acelLast; // last acceleration including gravity
    private float shake; // acceleration apart from gravity
    TextView t1, t2, t3, t4;
    EditText e1, e2, e3, e4;
    Button readBut, submitBut, dash;
    private MyOpenHelper mMyOpenHelper;
    private SQLiteDatabase mSqlDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_links);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        shake = 0.00f;
        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;


        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);

        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);

        readBut = (Button) findViewById(R.id.readBut);
        submitBut = (Button) findViewById(R.id.submitBut);
        dash = (Button) findViewById(R.id.button5);

        mMyOpenHelper = new MyOpenHelper(ResumeLinks.this, "EMPDB", null, 1);
        mSqlDb = mMyOpenHelper.getWritableDatabase();


        readBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = mSqlDb.query("ResumeLinks", null, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    String s1 = cursor.getString(1);
                    e1.setText(s1);
                    String s2 = cursor.getString(2);
                    e2.setText(s2);
                    String s3 = cursor.getString(3);
                    e3.setText(s3);
                    String s4 = cursor.getString(4);
                    e4.setText(s4);
                }
            }
        });

        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("link1", e1.getText().toString());
                cv.put("link2", e2.getText().toString());
                cv.put("link3", e3.getText().toString());
                cv.put("link4", e4.getText().toString());
                long id = mSqlDb.insert("ResumeLinks", null, cv);
                Toast.makeText(ResumeLinks.this, String.valueOf(id), Toast.LENGTH_LONG).show();
            }
        });

        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResumeLinks.this, AppSymbol.class));
            }
        });
    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        public void onSensorChanged(SensorEvent se) {
            float x = se.values[0];
            float y = se.values[1];
            float z = se.values[2];
            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = acelVal - acelLast;
            shake = shake * 0.6f + delta; // perform low-cut filter
            if (shake >12) {
                Intent intent = new Intent(getApplicationContext(), Employers.class);
                startActivity(intent);
                Toast toast =Toast.makeText(getApplicationContext(), "DO NOT SHAKE ME", Toast.LENGTH_LONG);
                //toast.show();
            }
        }
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    public void insertData(View view) {
        ContentValues cv = new ContentValues();
        cv.put("link1", e1.getText().toString());
        cv.put("link2", e2.getText().toString());
        cv.put("link3", e3.getText().toString());
        cv.put("link4", e4.getText().toString());
        long id = mSqlDb.insert("ResumeLinks", null, cv);
        Toast.makeText(ResumeLinks.this, String.valueOf(id), Toast.LENGTH_LONG).show();



    }

    public void readData(View view) {
        Cursor cursor = mSqlDb.query("ResumeLinks", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Toast.makeText(ResumeLinks.this, cursor.getString(1) + "" + cursor.getString(2), Toast.LENGTH_LONG).show();
        }
    }
}