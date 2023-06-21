package com.example.duofrencholingo.Readings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.duofrencholingo.ConceptViewAdapter;
import com.example.duofrencholingo.GrammarConcept;
import com.example.duofrencholingo.MainActivity;
import com.example.duofrencholingo.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


        int counter = 0;
        Button conceptButton;
        //create click listener for each button in recycler view
        for (GrammarConcept concept : ConceptViewAdapter.getAllConcepts()) {
            RecyclerView.ViewHolder holder = view.findViewHolderForAdapterPosition(counter);
            conceptButton = holder.itemView.findViewById(R.id.go_learn_content);
            counter++;

            conceptButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String[] name = concept.getName().split(" ");
                    Arrays.stream(name).forEach(ConceptLandingPage::removeDiacritics);
                    String removed = String.join("", name);

                    try {
                        startActivity(new Intent(getApplicationContext(), Class.forName(removed)));
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public static String removeDiacritics(String input) {
        String separated = Normalizer.normalize(input, Normalizer.Form.NFKD);
        return separated.replaceAll("\\p{M}", "");
    }
}