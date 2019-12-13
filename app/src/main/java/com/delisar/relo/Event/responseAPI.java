package com.delisar.relo.Event;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class responseAPI {
    @SerializedName ( "results" )
    private ArrayList<dataAPI> results;

    public ArrayList<dataAPI> getResults(){
        return results;
    }
}
