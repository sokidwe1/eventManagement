package com.example.eventsapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EventsMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_main_page);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.eventMainPage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        getWindow().setStatusBarColor(Color.GRAY);

        // Retrieve the event title from the intent
        Intent intent = getIntent();
        String eventTitle = intent.getStringExtra("eventTitle"); // Ensure "eventTitle" matches the key used when passing the intent
        String eventDescription = intent.getStringExtra("eventDescription");
        String eventMonth = intent.getStringExtra("eventMonth");
        String eventDay = intent.getStringExtra("eventDay");
        String eventPlace = intent.getStringExtra("eventPlace");
        String eventCount = intent.getStringExtra("eventCount");
        int eventImage = intent.getIntExtra("eventImage",0);


        // Set the event title to the TextView
        TextView titleTextView = findViewById(R.id.eventTitle); // Ensure this ID matches your TextView ID in XML
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        TextView dateTextView = findViewById(R.id.dateTextView);
        ImageView imageImageView = findViewById(R.id.imageImageView);
        TextView placeTextView = findViewById(R.id.placeTextView);
        TextView countTextView = findViewById(R.id.countTextView);
        if (eventTitle != null) {
            titleTextView.setText(eventTitle);
            descriptionTextView.setText(eventDescription);
            dateTextView.setText(eventDay +" "+ eventMonth);
            imageImageView.setImageResource(eventImage);
            placeTextView.setText(eventPlace);
            countTextView.setText(eventCount);
        } else {
            titleTextView.setText("Event  Unavailable"); // Fallback text if title is null
        }
    }
}
