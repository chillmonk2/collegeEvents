package com.github.chillmonk2.collegeevents;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;


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


    public static final int RC_SIGN_IN = 1;
    public ListView EventsListView;
    public EventsAdapter mEventsAdapter;
    private static final int RC_IMAGE_PICKER = 2;
    public String s1 =" is Going to Conduct the event on Saturday.Please Click on the Text to register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


    }
}

