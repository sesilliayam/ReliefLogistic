package com.delisar.relo.Event;

import com.google.gson.annotations.SerializedName;

public class dataAPI {
    @SerializedName ( "title" )
    private String title;

    public dataAPI(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
