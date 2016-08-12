package com.example.myfirstapp;

/**
 * Created by david on 2016-08-05.
 */
import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    private String content;
    private String date;


    //기한이 없을 때
    public Task(String title, String content) {
        this.title = title;
        this.content = content;
    }

    //기한이 있을 때
    public Task(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getTitle() { return title; }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }


}

