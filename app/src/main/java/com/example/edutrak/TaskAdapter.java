package com.example.edutrak;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    Context context;
    ArrayList<EventHelperClass> myDoes;

    public TaskAdapter(Context c, ArrayList<EventHelperClass> p) {
        context = c;
        myDoes = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_task,viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.task_title.setText(myDoes.get(i).getTitle());
        myViewHolder.task_desc.setText(myDoes.get(i).getCourse());
        myViewHolder.task_date.setText(myDoes.get(i).getDate());
       // myViewHolder.key.setText(myDoes.get(i).getTime());

        final String getTitle = myDoes.get(i).getTitle();
        final String getDesc = myDoes.get(i).getDescription();
        final String getDate = myDoes.get(i).getDate();
        final String getCourse = myDoes.get(i).getCourse();
        final String getEvent_Key = myDoes.get(i).getKey_event();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aa = new Intent(context,EditTaskDesk.class);
                aa.putExtra("title", getTitle);
                aa.putExtra("description", getDesc);
                aa.putExtra("date", getDate);
                aa.putExtra("course", getCourse);
                aa.putExtra("key_event", getEvent_Key);
                context.startActivity(aa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDoes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public BreakIterator title;
        TextView task_title, task_desc, task_date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            task_title = (TextView) itemView.findViewById(R.id.task_title);
            task_desc = (TextView) itemView.findViewById(R.id.task_desc);
            task_date = (TextView) itemView.findViewById(R.id.task_date);
        }
    }

}
