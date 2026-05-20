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

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getSummary() { return summary; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setSummary(String summary) { this.summary = summary; }
}