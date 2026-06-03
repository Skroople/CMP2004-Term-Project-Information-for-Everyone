package com.example.cmp2004termproject.model;

public class TipItem {
    private int id;
    private String title;
    private String message;
    private String category;

    public TipItem(int id, String title, String message, String category) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.category = category;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public String getCategory() { return category; }

}