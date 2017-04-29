package com.example.trinhcanhphuc.viewxskt;

import java.util.ArrayList;

/**
 * Created by trinhcanhphuc on 4/29/17.
 */

public class TongDai {

    private String name;
    private ArrayList<KQSXDate> kqsxDays;

    public TongDai(){
        kqsxDays = null;
        name = "";
    }

    public TongDai(ArrayList<KQSXDate> kqsxDays, String name) {
        this.kqsxDays = kqsxDays;
        this.name = name;
    }

    public ArrayList<KQSXDate> getKqsxDays() {
        return kqsxDays;
    }

    public void setKqsxDays(ArrayList<KQSXDate> kqsxDays) {
        this.kqsxDays = kqsxDays;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
