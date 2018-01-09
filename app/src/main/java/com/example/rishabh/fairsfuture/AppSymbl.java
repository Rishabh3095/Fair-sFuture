package com.example.rishabh.fairsfuture;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

// This is the portrait fragment of the AppSymbol.java Activity.

public class AppSymbl extends Fragment {

    Button ResumeLinks;
    Button CreateEvent;
    ImageView symbol;
    View v;
    ImageButton pf;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_app_symbl, container, false);

        ResumeLinks = (Button) v.findViewById(R.id.b1);
        CreateEvent = (Button) v.findViewById(R.id.b2);
        pf = (ImageButton) v.findViewById(R.id.imageButton3);

        //This button open ResumeLinks Activity.
        ResumeLinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ResumeLinks.class));
            }
        });

        //This button open ResumeLinks Activity.
        CreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CreateEvent.class));
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    public interface OnFragmentInteractionListener {
    }
}