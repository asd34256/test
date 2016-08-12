package com.example.myfirstapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by david on 2016-08-08.
 */
public class TaskViewHolder extends RecyclerView.ViewHolder {

    private TextView txtTitle;
    private TextView txtContent;
    private TextView txtDate;

    private Task task;

    public TaskViewHolder(View itemView) {

        super(itemView);

        this.txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        this.txtContent = (TextView) itemView.findViewById(R.id.txtContent);
        this.txtDate = (TextView) itemView.findViewById(R.id.txtDate);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                Toast.makeText(context, task.getTitle(), Toast.LENGTH_SHORT ).show();
            }
        });
    }

    public void setTask(Task task) {

        this.task = task;

        this.txtTitle.setText(task.getTitle());
        this.txtContent.setText(task.getContent());
        this.txtDate.setText(task.getDate());
    }
}
