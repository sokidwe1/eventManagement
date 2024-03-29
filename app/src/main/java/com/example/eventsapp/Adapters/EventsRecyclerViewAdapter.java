package com.example.eventsapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.eventsapp.Models.EventModel;
import com.example.eventsapp.R;

import java.util.ArrayList;

public class EventsRecyclerViewAdapter extends  RecyclerView.Adapter<EventsRecyclerViewAdapter.ViewHolder>{

    ArrayList<EventModel> eventModelArrayList = new ArrayList<>();
    private OnItemClickListener listener;

    public EventsRecyclerViewAdapter(ArrayList<EventModel> eventModelArrayList,OnItemClickListener listener ){
        this.eventModelArrayList = eventModelArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(eventModelArrayList.get(position).getDay());
        holder.month.setText(eventModelArrayList.get(position).getMonth());
        holder.title.setText(eventModelArrayList.get(position).getTitle());
        holder.place.setText(eventModelArrayList.get(position).getPlace());
        holder.count.setText(eventModelArrayList.get(position).getCount());
        Glide.with(holder.imageview.getContext()).load(eventModelArrayList.get(position).getUrl()).into(holder.imageview);
        EventModel event = eventModelArrayList.get(position);
        // Set data to views
        holder.itemView.setOnClickListener(v -> {
            if(listener != null) {
                listener.onItemClick(event);
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventModelArrayList.size();
    }

    public interface OnItemClickListener  {
        void onItemClick(EventModel event);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView date,month,title,place,count;
        ImageView imageview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.day);
            month = itemView.findViewById(R.id.month);
            title = itemView.findViewById(R.id.eventTitle);
            place = itemView.findViewById(R.id.location);
            count = itemView.findViewById(R.id.count);
            imageview = itemView.findViewById((R.id.card_image));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(eventModelArrayList.get(position));
                    }
                }
            });
        }
    }

    public void filterList(ArrayList<EventModel> filteredList) {
        eventModelArrayList = filteredList;
        notifyDataSetChanged();
    }

}
