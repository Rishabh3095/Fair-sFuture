package com.example.rishabh.fairsfuture;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ProfileInfo extends Fragment{

    TextView t;
    EditText t1;
    EditText t2;
    EditText t3;
    EditText t4;
    View v;
    Button b1;
    Button b2;
    private MyOpenHelper mMyOpenHelper;
    private SQLiteDatabase mSqlDb;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_profile_info, container, false);

        t = (TextView) v.findViewById(R.id.t);
        t1 = (EditText) v.findViewById(R.id.t1);
        t2 = (EditText) v.findViewById(R.id.editText5);
        t3 = (EditText) v.findViewById(R.id.t4);
        t4 = (EditText) v.findViewById(R.id.t3);

        b1 = (Button) v.findViewById(R.id.button2);
        b2 = (Button) v.findViewById(R.id.button3);

        mMyOpenHelper = new MyOpenHelper(getActivity(), "EMPDB", null, 1);
        mSqlDb = mMyOpenHelper.getWritableDatabase();


        return v;
        }

    public interface OnFragmentInteractionListener {
    }

}