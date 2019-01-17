package com.example.alireza.myapplicationfirst;

public class Task {

   private String massage;
   private String date;

    public Task(String massage, String date) {
        this.massage = massage;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getMassage() {
        return massage;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    @Override
    public String toString(){
        return massage + "\n" + date;
    }
}
