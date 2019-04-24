package com.delisar.relo.Category;

public class Category {

    private String categoryTitle;
    private String categoryInfo;
//    private final int imageResource;


    public Category(String title, String info) {
        this.categoryTitle = title;
        this.categoryInfo = info;
//        this.imageResource = imageResource;
    }


    String getTitle() {
        return categoryTitle;
    }


    String getInfo() {
        return categoryInfo;
    }

//    public int getImageResource() {
//        return imageResource;
//    }

}
