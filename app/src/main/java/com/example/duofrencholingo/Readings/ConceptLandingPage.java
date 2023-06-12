package com.example.duofrencholingo.Readings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.duofrencholingo.ConceptViewAdapter;
import com.example.duofrencholingo.GrammarConcept;
import com.example.duofrencholingo.R;

import java.util.ArrayList;
import java.util.List;

public class ConceptLandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept_landing_page);

        List<GrammarConcept> concepts = new ArrayList<>();
        //add concepts here (also paste corresponding images in drawable folder)

        RecyclerView view = findViewById(R.id.concepts_recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new ConceptViewAdapter(getApplicationContext(), concepts));
    }
}