package com.example.trinhcanhphuc.viewxskt;

import java.util.ArrayList;

/**
 * Created by trinhcanhphuc on 4/29/17.
 */

class KQSXDate {

    private String date;
    private ArrayList<String> first_prize;
    private ArrayList<String> second_prize;
    private ArrayList<String> third_prize;
    private ArrayList<String> fourth_prize;
    private ArrayList<String> fifth_prize;
    private ArrayList<String> sixth_prize;
    private ArrayList<String> seventh_prize;
    private ArrayList<String> eighth_prize;
    private ArrayList<String> special_prize;


    public KQSXDate(){
        this.date = null;
        this.first_prize = null;
        this.second_prize = null;
        this.third_prize = null;
        this.fourth_prize = null;
        this.fifth_prize = null;
        this.sixth_prize = null;
        this.seventh_prize = null;
        this.eighth_prize = null;
        this.special_prize = null;
    }

    public KQSXDate(String date, ArrayList<String> first_prize,
                   ArrayList<String> second_prize, ArrayList<String> third_prize,
                   ArrayList<String> fourth_prize, ArrayList<String> fifth_prize,
                   ArrayList<String> sixth_prize, ArrayList<String> seventh_prize,
                   ArrayList<String> eighth_prize, ArrayList<String> special_prize) {
        this.date = date;
        this.first_prize = first_prize;
        this.second_prize = second_prize;
        this.third_prize = third_prize;
        this.fourth_prize = fourth_prize;
        this.fifth_prize = fifth_prize;
        this.sixth_prize = sixth_prize;
        this.seventh_prize = seventh_prize;
        this.eighth_prize = eighth_prize;
        this.special_prize = special_prize;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<String> getFirst_prize() {
        return first_prize;
    }

    public void setFirst_prize(ArrayList<String> first_prize) {
        this.first_prize = first_prize;
    }

    public ArrayList<String> getSecond_prize() {
        return second_prize;
    }

    public void setSecond_prize(ArrayList<String> second_prize) {
        this.second_prize = second_prize;
    }

    public ArrayList<String> getThird_prize() {
        return third_prize;
    }

    public void setThird_prize(ArrayList<String> third_prize) {
        this.third_prize = third_prize;
    }

    public ArrayList<String> getFourth_prize() {
        return fourth_prize;
    }

    public void setFourth_prize(ArrayList<String> fourth_prize) {
        this.fourth_prize = fourth_prize;
    }

    public ArrayList<String> getFifth_prize() {
        return fifth_prize;
    }

    public void setFifth_prize(ArrayList<String> fifth_prize) {
        this.fifth_prize = fifth_prize;
    }

    public ArrayList<String> getSixth_prize() {
        return sixth_prize;
    }

    public void setSixth_prize(ArrayList<String> sixth_prize) {
        this.sixth_prize = sixth_prize;
    }

    public ArrayList<String> getSeventh_prize() {
        return seventh_prize;
    }

    public void setSeventh_prize(ArrayList<String> seventh_prize) {
        this.seventh_prize = seventh_prize;
    }

    public ArrayList<String> getEighth_prize() {
        return eighth_prize;
    }

    public void setEighth_prize(ArrayList<String> eighth_prize) {
        this.eighth_prize = eighth_prize;
    }

    public ArrayList<String> getSpecial_prize() {
        return special_prize;
    }

    public void setSpecial_prize(ArrayList<String> special_prize) {
        this.special_prize = special_prize;
    }
}
