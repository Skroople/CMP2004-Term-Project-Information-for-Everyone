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

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setMessage(String message) { this.message = message; }
    public void setCategory(String category) { this.category = category; }
}