package com.example.duofrencholingo.Readings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.duofrencholingo.ConceptViewAdapter;
import com.example.duofrencholingo.GrammarConcept;
import com.example.duofrencholingo.MainActivity;
import com.example.duofrencholingo.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ConceptLandingPage extends AppCompatActivity {
    FloatingActionButton exitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept_landing_page);
        exitButton = findViewById(R.id.fab_back);

        List<GrammarConcept> concepts = ConceptViewAdapter.getAllConcepts();

        RecyclerView view = findViewById(R.id.concepts_recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new ConceptViewAdapter(getApplicationContext(), concepts));

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}