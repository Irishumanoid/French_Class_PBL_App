package com.example.duofrencholingo.User;

import java.util.ArrayList;
import java.util.List;
public class User {
    private String email;
    private String username;
    private int age;
    private double XP;
    private List<String> completedLessons;

    public User(String email, String username, int age) {
        this.email = email;
        this.username = username;
        this.age = age;
        this.XP = 0;
        this.completedLessons = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getXP() {
        return XP;
    }

    public void addXP(double increment) {
        this.XP += increment;
    }

    public List<String> getCompletedLessons() {
        return completedLessons;
    }
}