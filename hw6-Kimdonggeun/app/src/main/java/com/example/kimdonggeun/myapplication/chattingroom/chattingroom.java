package com.example.kimdonggeun.myapplication.chattingroom;

public class chattingroom {

    int img_src;
    String name;
    String text;
    String date;
    int balance;

    public chattingroom(int img_src, String name, String text, String date, int balance) {
        this.img_src = img_src;
        this.name = name;
        this.text = text;
        this.date = date;
        this.balance = balance;
    }

    public int getImg_src() {
        return img_src;
    }

    public void setImg_src(int img_src) {
        this.img_src = img_src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

