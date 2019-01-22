package com.example.alireza.myapplicationfirst;

public class Task implements Comparable<Task> {

    static int numberOfTasks = 0;
    private String massage;
    private String Y;
    private String M;
    private String D;
    private String h;
    private String m;
    private String s;
    private String date;
    private long totalD = 0;
    private long totalS = 0;
    private boolean isDated;
    private int priority; //5 types , 1.not desc , 2.sub , 3.high , 4.med , 5.low

    public Task(String massage, String Y, String M, String D, String h, String m, String s, int priority) {
        isDated = true;
        this.massage = massage;
        this.Y = Y;
        this.M = M;
        this.D = D;
        this.h = h;
        this.m = m;
        this.s = s;
        this.priority = priority;

        calcTotalD();
        calcTotalS();
        conCatDate();
    }

    Task(String massage, String date, String year, String month, String day){  // using calander.

        isDated = true;
        this.massage = massage;
        this.date = date;
        this.Y = year;
        this.M = month;
        this.D = day;
        calcTotalD();
    }

    Task(String massage, int priority) {
        this.massage = massage;
        this.priority = priority;
        isDated = false;
        date = "";
        numberOfTasks++;
    }

    @Override
    public boolean equals( Object obj) {
        return (this.date.equals(((Task)obj).date) && (this.massage.equals(((Task)obj).massage)));
    }

    public void conCatDate() {
        date = Y + "/" + M + "/" + D + "  " + h + ":" + m + ":" + s;
    }

    public String getDate() {
        return date;
    }

    public boolean isDated() {
        return isDated;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    @Override
    public String toString() {

        return massage + "\n" + Y + "." + M + "." + D + ".";
    }

    public void calcTotalD() {

        totalD += Integer.parseInt(Y) * 365;
        totalD += Integer.parseInt(M) * 30;
        totalD += Integer.parseInt(D);
    }

    public void calcTotalS() {

        totalS += Integer.parseInt(h) * 3600;
        totalS += Integer.parseInt(m) * 60;
        totalS += Integer.parseInt(s);
    }

    @Override
    public int compareTo(Task o) {
        //return (isDated) ? -1 : 1;

        if (isDated) {

            if (this.priority == o.priority) {
                if (this.totalD > o.totalD) {
                    return -1; // or -1,
                } else if (this.totalD < o.totalD) {
                    return 1; // or
                } else {

                    if (this.totalS > o.totalS) {
                        return -1;
                    } else if (this.totalS < o.totalS)
                        return 1;

                    else return 0;
                }
            } else if (this.priority > o.priority)
                return 1;

            else return -1;
        } else {

            if (this.priority == o.priority)
                return 0;

            else if (this.priority > o.priority)

                return 1;
            else return -1;

        }
    }
}