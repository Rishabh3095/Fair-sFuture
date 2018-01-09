package com.example.rishabh.fairsfuture;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class CreateEvent extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;
    EditText e1, e2, e3;
    int i = 1;
    Button submitBut;
    Button readBut;
    ImageButton im;
    Button emp;

    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;


    private MyOpenHelper mMyOpenHelper;
    private SQLiteDatabase mSqlDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        t1 = (TextView) findViewById(R.id.ce);
        t2 = (TextView) findViewById(R.id.en);
        t3 = (TextView) findViewById(R.id.textView12);
        t5 = (TextView) findViewById(R.id.textView24);

        e1 = (EditText) findViewById(R.id.editText6);
        e2 = (EditText) findViewById(R.id.editText7);
        e3 = (EditText) findViewById(R.id.editText8);

        im = (ImageButton) findViewById(R.id.imageButton);

        emp = (Button) findViewById(R.id.empl);


        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isServicesOK()){
                 googleMaps(view);
                }
            }
        });

        submitBut = (Button) findViewById(R.id.submitBut1);
        readBut = (Button) findViewById(R.id.readBut1);

        mMyOpenHelper = new MyOpenHelper(CreateEvent.this, "EMPDB", null, 1);
        mSqlDb = mMyOpenHelper.getWritableDatabase();

        readBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = mSqlDb.query("Events", null, null, null, null, null, null);
                    while (cursor.moveToNext()) {
                        String s1 = cursor.getString(1);
                        e1.setText(s1);
                        String s2 = cursor.getString(2);
                        e2.setText(s2);
                        String s3 = cursor.getString(3);
                        e3.setText(s3);}
            }
        });

        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    ContentValues cv = new ContentValues();
                    cv.put("Event", e1.getText().toString());
                    cv.put("Date", e2.getText().toString());
                    cv.put("V", e3.getText().toString());
                    mSqlDb.insert("Events", null, cv);

            }
        });

        emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateEvent.this, Employers.class));
            }
        });

    }

    private void init(){
    }

    public void googleMaps(View view)
    {
        startActivity(new Intent(CreateEvent.this, mapsGoogle.class));
    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(CreateEvent.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(CreateEvent.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}



//create event and all events
//google maps
//sign i fix
//generate random keys
