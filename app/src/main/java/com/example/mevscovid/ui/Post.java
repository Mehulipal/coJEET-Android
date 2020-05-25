package com.example.mevscovid.ui;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int userId;
    private int id;
    @SerializedName("body")
    private String title;
    private String text;

    public int getUserId() { return userId; }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
