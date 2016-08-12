package com.example.myfirstapp;


import android.content.Context;
import android.support.v4.view.ViewGroupCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2016-08-08.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private ArrayList<Task> tasks;

    public TaskAdapter(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);

        TaskViewHolder viewHolder = new TaskViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {

        Task task = tasks.get(position);
        holder.setTask(task);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
