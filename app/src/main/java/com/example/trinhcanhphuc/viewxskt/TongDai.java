package com.example.trinhcanhphuc.viewxskt;

import java.util.ArrayList;

/**
 * Created by trinhcanhphuc on 4/29/17.
 */

public class TongDai {

    private ArrayList<KQSXDay> kqsxDays;

    public TongDai(ArrayList<KQSXDay> kqsxDays) {
        this.kqsxDays = kqsxDays;
    }

    public ArrayList<KQSXDay> getKqsxDays() {
        return kqsxDays;
    }

    public void setKqsxDays(ArrayList<KQSXDay> kqsxDays) {
        this.kqsxDays = kqsxDays;
    }
}
