package com.example.rishabh.fairsfuture;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AppSymbol extends AppCompatActivity implements ProfileInfo.OnFragmentInteractionListener, AppSymbl.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_symbol);

        FragmentManager manager = getSupportFragmentManager();
        Configuration config = getResources().getConfiguration();

        if(config.orientation == config.ORIENTATION_LANDSCAPE)
        {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment_workout))
                    .hide(manager.findFragmentById(R.id.fragment_record))
                    .commit();
        }
        else
        {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment_record))
                    .hide(manager.findFragmentById(R.id.fragment_workout))
                    .commit();
        }

//        startService(new Intent(MainActivity.this, SensorService.class));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        FragmentManager manager = getSupportFragmentManager();
        Configuration config = getResources().getConfiguration();

        if(config.orientation == config.ORIENTATION_LANDSCAPE)
        {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment_workout))
                    .hide(manager.findFragmentById(R.id.fragment_record))
                    .commit();
        }
        else
        {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment_record))
                    .hide(manager.findFragmentById(R.id.fragment_workout))
                    .commit();
        }
    }

    public void onFragmentInteraction(Uri uri) {

    }
}
