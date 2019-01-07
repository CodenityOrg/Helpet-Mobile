package com.kincodi.helpet.helpetmobile.domain.model;

public class Photo {
    private String name;
    private String path;
    private String thumbnailPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
