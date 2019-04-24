package com.delisar.relo.Category;

public class Category {

    private String title;
    private String info;
//    private final int imageResource;


    public Category(String title, String info) {
        this.title = title;
        this.info = info;
//        this.imageResource = imageResource;
    }


    String getTitle() {
        return title;
    }


    String getInfo() {
        return info;
    }

//    public int getImageResource() {
//        return imageResource;
//    }

}
