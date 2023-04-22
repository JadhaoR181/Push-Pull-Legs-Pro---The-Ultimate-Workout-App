package com.example.pushpulllegspro_theultimateworkoutapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase
        FirebaseApp.initializeApp(this);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Push Pull Legs Pro");

        // Get a reference to the database
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        // Create a Java object that represents the data
        MyData data = new MyData("John", "Doe");

        // Add the data to the database
        databaseReference.child("mydata").setValue(data);

        // Add a listener to the database reference
        databaseReference.child("mydata").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get the data from the snapshot
                MyData data = dataSnapshot.getValue(MyData.class);

                // Do something with the data
                assert data != null;
                Log.d(TAG, "Name: " + data.getName());
                Log.d(TAG, "Surname: " + data.getSurname());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors here
            }
        });
    }
}