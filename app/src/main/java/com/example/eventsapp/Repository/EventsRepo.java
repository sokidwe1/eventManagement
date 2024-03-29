package com.example.eventsapp.Repository;

import com.example.eventsapp.Models.EventModel;
import com.example.eventsapp.R;

import java.util.ArrayList;

public class EventsRepo {
    private static EventsRepo eventsRepo;
    private ArrayList<EventModel> eventModelList = new ArrayList<>();

    public EventsRepo() {
        eventModelList.add(new EventModel("21","AUG","Fireworks","london","591", R.drawable.fireworks,"Description of Fireworks Event"));
        eventModelList.add(new EventModel("20","FEB","Dj Party","DAWRA","123",R.drawable.concert,"Description of concert Event"));
        eventModelList.add(new EventModel("12","OCT","Sunset","JOUNIEH","321",R.drawable.sunset,"Description of sunset Event"));
        eventModelList.add(new EventModel("10","JAN","beach Party","NahrElKalb","432",R.drawable.beachparty,"Description of beach party Event"));
    }

    public static  EventsRepo getEventsRepo(){
        if(eventsRepo ==null){
            eventsRepo = new EventsRepo();
        }
        return eventsRepo;
    }

    public ArrayList<EventModel> GetEventModelList(){
        return eventModelList;
    }
}
