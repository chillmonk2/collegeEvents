package com.github.chillmonk2.collegeevents;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;


import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    AlertDialog.Builder builder;
    public static final int RC_SIGN_IN = 1;
    public ListView EventsListView;
    public EventsAdapter mEventsAdapter;
    private static final int RC_IMAGE_PICKER = 2;
    public String s1 =" is Going to Conduct the event on Saturday.Please Click on the Text to register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(MainActivity.this);
        getSupportActionBar().setTitle("Events");

        ArrayList<EventsObject> eList = new ArrayList<EventsObject>();
        eList.add(new EventsObject("CSE","12/15/16","CSE"+s1,"http://rvrjc.ac.in/",R.drawable.cse_icon,0));
        eList.add(new EventsObject("ECE","12/15/17","ECE"+s1,"http://rvrjc.ac.in/",R.drawable.satellite_variant,0));
        eList.add(new EventsObject("ChE","12/15/11","ChE"+s1,"http://rvrjc.ac.in/",R.drawable.chemical_icon,0));
        eList.add(new EventsObject("CIV","12/15/13","CIV"+s1,"http://rvrjc.ac.in/",R.drawable.civil_icon,0));
        eList.add(new EventsObject("MEC","12/15/14","MEC"+s1,"http://rvrjc.ac.in/",R.drawable.mech_icon,0));
        eList.add(new EventsObject("IT","12/14/16","IT"+s1,"http://rvrjc.ac.in/",R.drawable.it_icon,0));
        eList.add(new EventsObject("MCA","12/11/16","MCA"+s1,"http://rvrjc.ac.in/",R.drawable.mca_icon,0));
        eList.add(new EventsObject("EEE","12/16/16","EEE"+s1,"http://rvrjc.ac.in/",R.drawable.eee_icon,0));
        eList.add(new EventsObject("MBA","12/11/16","MBA"+s1,"http://rvrjc.ac.in/",R.drawable.mba_icon,0));
        eList.add(new EventsObject("Coding Club","12/15/16","Coding Club"+s1,"http://rvrjc.ac.in/",R.drawable.clubs,0));

        EventsListView = findViewById(R.id.eventsListView);
        mEventsAdapter = new EventsAdapter(this, eList);
        EventsListView.setAdapter(mEventsAdapter);

        EventsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final EventsObject mEventsObject = mEventsAdapter.getItem(position);
                final String mEventUrl = mEventsObject.geteLink();
                LikeButton likeButton =  view.findViewById(R.id.heart_button);
                TextView description =view.findViewById(R.id.eventDesc);
                //final TextView likesCountTextView = view.findViewById(R.id.likesCount);
                Toast.makeText(MainActivity.this, "Liked", Toast.LENGTH_SHORT).show();

                description.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!TextUtils.isEmpty(mEventUrl)) {
                            Intent openLinkInBrowser = new Intent(Intent.ACTION_VIEW);
                            openLinkInBrowser.setData(Uri.parse(mEventUrl));
                            startActivity(openLinkInBrowser);
                        } else {
                            Toast.makeText(MainActivity.this, "Links are not provided", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

                //Setting message manually and performing action on button click
                builder.setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String EventFormat = "COPY FROM HERE:<--'y17cs151@rvrjc.ac.in'-->\nEvent Organiser : \nEvent Date: \n" +
                                        "Event Description : Short and Simple ! \nEvent Links or Images ";
                                String ResponseTime = "\nOur Team will contact you within 6 hours";
                                String email = "y17cs151@rvrjc.ac.in";
                                Intent intent = new Intent (Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("mailto:"));
                                intent.putExtra(Intent.EXTRA_EMAIL,email);
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Add an Event");
                                intent.putExtra(Intent.EXTRA_TEXT,EventFormat+ResponseTime);
                                if (intent.resolveActivity(getPackageManager()) != null) {
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(MainActivity.this, "We will be waiting for your Event !", Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Add Your Event");
                alert.show();
            }
        });



    }
}

