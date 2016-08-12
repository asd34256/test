package com.example.myfirstapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2016-08-11.
 */
public class TaskList implements Serializable {

    private List<Task> tasks = new ArrayList<>();
    public TaskList(Task task) {

        tasks.add(task);
    }
}
