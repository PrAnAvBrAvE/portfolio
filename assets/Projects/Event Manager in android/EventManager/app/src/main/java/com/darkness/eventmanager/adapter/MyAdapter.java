package com.darkness.eventmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.darkness.eventmanager.OnEventClickListener;
import com.darkness.eventmanager.R;
import com.darkness.eventmanager.model.Event;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<Event>events;
    private OnEventClickListener eventClickListener;

    public MyAdapter(Context context,ArrayList<Event>events,OnEventClickListener clickListener){
        layoutInflater = LayoutInflater.from(context);
        this.events = events;
        this.eventClickListener = clickListener;
    }




    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(layoutInflater.inflate(R.layout.event_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.textView.setText(events.get(position).getTitle());
        holder.dateTimeItem.setText(events.get(position).getReadable_date());
    }


    @Override
    public int getItemCount() {
        if (events.isEmpty()) {
            return 0;
        } else{
            return events.size();
    }
    }

     class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView,dateTimeItem;
        ImageButton delete;
        MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.titleItem);
            dateTimeItem = itemView.findViewById(R.id.dateTimeItem);
            delete = itemView.findViewById(R.id.delete);
            delete.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(eventClickListener != null){
                eventClickListener.onClickListener(getAdapterPosition());
            }
        }
    }

}
