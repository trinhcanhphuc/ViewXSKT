package com.example.trinhcanhphuc.viewxskt;

import java.util.ArrayList;

/**
 * Created by trinhcanhphuc on 4/29/17.
 */

class KQSXDay {

    private Integer day;
    private Integer month;
    private ArrayList<Integer> first_prize;
    private ArrayList<Integer> second_prize;
    private ArrayList<Integer> third_prize;
    private ArrayList<Integer> fourth_prize;
    private ArrayList<Integer> fifth_prize;
    private ArrayList<Integer> sixth_prize;
    private ArrayList<Integer> seventh_prize;
    private ArrayList<Integer> eighth_prize;
    private ArrayList<Integer> special_prize;


    public KQSXDay(Integer day, Integer month, ArrayList<Integer> first_prize,
                   ArrayList<Integer> second_prize, ArrayList<Integer> third_prize,
                   ArrayList<Integer> fourth_prize, ArrayList<Integer> fifth_prize,
                   ArrayList<Integer> sixth_prize, ArrayList<Integer> seventh_prize,
                   ArrayList<Integer> eighth_prize, ArrayList<Integer> special_prize) {
        this.day = day;
        this.month = month;
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

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public ArrayList<Integer> getFirst_prize() {
        return first_prize;
    }

    public void setFirst_prize(ArrayList<Integer> first_prize) {
        this.first_prize = first_prize;
    }

    public ArrayList<Integer> getSecond_prize() {
        return second_prize;
    }

    public void setSecond_prize(ArrayList<Integer> second_prize) {
        this.second_prize = second_prize;
    }

    public ArrayList<Integer> getThird_prize() {
        return third_prize;
    }

    public void setThird_prize(ArrayList<Integer> third_prize) {
        this.third_prize = third_prize;
    }

    public ArrayList<Integer> getFourth_prize() {
        return fourth_prize;
    }

    public void setFourth_prize(ArrayList<Integer> fourth_prize) {
        this.fourth_prize = fourth_prize;
    }

    public ArrayList<Integer> getFifth_prize() {
        return fifth_prize;
    }

    public void setFifth_prize(ArrayList<Integer> fifth_prize) {
        this.fifth_prize = fifth_prize;
    }

    public ArrayList<Integer> getSixth_prize() {
        return sixth_prize;
    }

    public void setSixth_prize(ArrayList<Integer> sixth_prize) {
        this.sixth_prize = sixth_prize;
    }

    public ArrayList<Integer> getSeventh_prize() {
        return seventh_prize;
    }

    public void setSeventh_prize(ArrayList<Integer> seventh_prize) {
        this.seventh_prize = seventh_prize;
    }

    public ArrayList<Integer> getEighth_prize() {
        return eighth_prize;
    }

    public void setEighth_prize(ArrayList<Integer> eighth_prize) {
        this.eighth_prize = eighth_prize;
    }

    public ArrayList<Integer> getSpecial_prize() {
        return special_prize;
    }

    public void setSpecial_prize(ArrayList<Integer> special_prize) {
        this.special_prize = special_prize;
    }
}
