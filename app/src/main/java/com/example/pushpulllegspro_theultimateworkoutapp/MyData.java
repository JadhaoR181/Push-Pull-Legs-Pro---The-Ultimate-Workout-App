package com.example.pushpulllegspro_theultimateworkoutapp;

public class MyData {

    private String name;
    private String surname;

    public MyData() {}

    public MyData(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
