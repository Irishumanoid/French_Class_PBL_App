package com.example.duofrencholingo.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.stream.StreamSource;


public class AccessUserData {
    private final FirebaseDatabase userData;
    private DatabaseReference dataRef;
    private Map<String, User> users;

    public AccessUserData() {
        this.userData = FirebaseDatabase.getInstance();
        dataRef = userData.getReference("french-app-registration/users");
        users = new HashMap<>();
    }

    public void setUserInfo(String email, String username, int age) {
        users.put(username, new User(email, username, age));
        dataRef.setValue(users);

        dataRef.setValue("writing data", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                if (error != null) {
                    System.out.println("Data could not be saved; error: " + error.getMessage());
                } else {
                    System.out.println("Data successfully saved");
                }
            }
        });
    }


    private static class User {
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

}
