package com.androiddev.travelblogapp;

public class Post {
    private int imageResource;
    private String MainTitle;
    private String MainTheme;
    private String Date;
    private String author;

    public Post(int imageResource, String mainTitle, String mainTheme, String date, String author) {
        this.imageResource = imageResource;
        MainTitle = mainTitle;
        MainTheme = mainTheme;
        Date = date;
        this.author = author;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getMainTitle() {
        return MainTitle;
    }

    public String getMainTheme() {
        return MainTheme;
    }

    public String getDate() {
        return Date;
    }

    public String getAuthor() {
        return author;
    }
}
