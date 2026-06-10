package com.example.cmp2004termproject.model;

public class InfoItem {
    private String id;
    private String title;
    private String content;
    private String summary;

    public InfoItem(String id, String title, String content, String summary) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.summary = summary;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getSummary() { return summary; }

}