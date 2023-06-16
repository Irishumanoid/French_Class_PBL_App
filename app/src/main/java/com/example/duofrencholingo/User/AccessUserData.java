package com.example.duofrencholingo.User;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class AccessUserData {
    private final FirebaseDatabase userData;
    private DatabaseReference dataRef;

    public AccessUserData() {
        this.userData = FirebaseDatabase.getInstance();
        dataRef = userData.getReference("french-app-registration/users").push();
    }

    public void trackUserChanges() {
        dataRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                User newUser = snapshot.getValue(User.class);
                System.out.println("new user registered: " + newUser);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                System.out.printf("Information changed for %s", snapshot.getValue(User.class).getUsername());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                System.out.println("The user " + snapshot.getValue(User.class) + " has unregistered");
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public DatabaseReference getUserRef(String key) {
        Query query = dataRef.orderByKey().equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User curUser = snapshot.getValue(User.class);
                System.out.printf("current user %s has %s points", curUser.getUsername(), String.valueOf(curUser.getXP()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Data could not be returned due to: " + error.getMessage());
            }
        });

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("users/"+key).child(uid);
        return userRef;
    }

}
