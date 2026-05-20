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
    public String getIconName() { return iconName; }
    public InfoItem[] getItems() { return items; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setIconName(String iconName) { this.iconName = iconName; }
    public void setItems(InfoItem[] items) { this.items = items; }
}