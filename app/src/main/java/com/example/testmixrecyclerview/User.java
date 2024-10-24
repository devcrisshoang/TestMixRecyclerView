package com.example.testmixrecyclerview;

public class User {
    private int resourceId;
    private String name;
    private boolean isFeatured;

    public User(int resourceId, String name, boolean isFeatured) {
        this.resourceId = resourceId;
        this.name = name;
        this.isFeatured = isFeatured;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }
}
