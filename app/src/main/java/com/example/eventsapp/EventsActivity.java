package com.example.eventsapp;

import static java.util.Locale.filter;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventsapp.Adapters.EventsRecyclerViewAdapter;
import com.example.eventsapp.Models.EventModel;
import com.example.eventsapp.Repository.EventsRepo;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity implements EventsRecyclerViewAdapter.OnItemClickListener {
    RecyclerView recyclerView;
    EventsRecyclerViewAdapter eventsRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.events_page);
        recyclerView = findViewById(R.id.recyclerView);
        initRecyclerView();
        EditText searchEditText = findViewById(R.id.searchEditText);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }
    void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        eventsRecyclerViewAdapter = new EventsRecyclerViewAdapter(EventsRepo.getEventsRepo().GetEventModelList(), this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(eventsRecyclerViewAdapter);
    }

    @Override
    public void onItemClick(EventModel event) {
        Intent intent = new Intent(EventsActivity.this, EventsMainPage.class);
        intent.putExtra("eventTitle", event.getTitle());
        intent.putExtra("eventDescription", event.getDescription());
        intent.putExtra("eventCount", event.getCount());
        intent.putExtra("eventPlace", event.getPlace());
        intent.putExtra("eventMonth", event.getMonth());
        intent.putExtra("eventDay", event.getDay());
        intent.putExtra("eventImage", event.getUrl());
        // Pass other details as needed
        startActivity(intent);
    }
    private void filter(String text) {
        ArrayList<EventModel> filteredList = new ArrayList<>();

        for (EventModel item : EventsRepo.getEventsRepo().GetEventModelList()) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        eventsRecyclerViewAdapter.filterList(filteredList);
    }


}