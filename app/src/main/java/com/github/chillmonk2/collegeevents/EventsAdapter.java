package com.github.chillmonk2.collegeevents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.like.LikeButton;

import java.util.ArrayList;

public class EventsAdapter extends ArrayAdapter<EventsObject> {

    private int mOrganiserResourceId;
    public EventsAdapter(Context context, ArrayList<EventsObject> words) {
        super(context, 0, words);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_event_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        EventsObject currentEvent = getItem(position);

        TextView organiserTextView = (TextView) listItemView.findViewById(R.id.organiser);

        organiserTextView.setText(currentEvent.geteOrganiser());


        TextView dateTextView = (TextView) listItemView.findViewById(R.id.dateOfEvent);

        dateTextView.setText(currentEvent.geteDate());


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.organiserImage);
        if (currentEvent.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentEvent.geteImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        TextView descEventTextView = (TextView) listItemView.findViewById(R.id.eventDesc);
        descEventTextView.setText(currentEvent.geteDesc());

        LikeButton heartButton = (LikeButton) listItemView.findViewById(R.id.heart_button);
        if(currentEvent.hasLiked()) {
            heartButton.setEnabled(true);
        }
        else {
            heartButton.setEnabled(false);
        }

        //TextView likesCountTextView = (TextView) listItemView.findViewById(R.id.likesCount);
        //likesCountTextView.setVisibility(View.INVISIBLE);




        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}

