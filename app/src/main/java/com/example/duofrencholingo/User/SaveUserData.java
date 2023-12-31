package com.example.duofrencholingo.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SaveUserData {
    private final FirebaseDatabase userData;
    private DatabaseReference dataRef;
    private Map<String, User> users;

    public SaveUserData() {
        this.userData = FirebaseDatabase.getInstance();
        dataRef = userData.getReference("french-app-registration/users/").push();
        users = new HashMap<>();
    }

    public void setUserInfo(String email, String username, int age) {
        users.put(username, new User(email, username, age));
        dataRef.setValue(users, new DatabaseReference.CompletionListener() {
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

    public void updateXP(User user, double increment) {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        user.addXP(increment);
        dataRef.child(uid +"/XP").setValue(user.getXP(), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                if (error != null) {
                    System.out.println("XP not saved due to error: " + error.getMessage());
                } else {
                    System.out.println("XP updated successfully.");
                }
            }
        });
    }

    public void updateLessons(User user, String lesson) {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        user.getCompletedLessons().add(lesson);
        dataRef.child(uid+"/lessons").setValue(user.getCompletedLessons(), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                if (error != null) {
                    System.out.println("Lesson progress not saved due to error: " + error.getMessage());
                } else {
                    System.out.println("Lesson status updated successfully.");
                }
            }
        });
    }
}
