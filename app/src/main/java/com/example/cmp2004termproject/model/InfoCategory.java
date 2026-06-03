package com.example.cmp2004termproject.model;

public class InfoCategory {
    private String id;
    private String name;
    private String description;
    private String iconName;
    private InfoItem[] items;

    public InfoCategory(String id, String name, String description, String iconName, InfoItem[] items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.iconName = iconName;
        this.items = items;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public InfoItem[] getItems() { return items; }

}