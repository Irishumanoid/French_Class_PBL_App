package com.example.duofrencholingo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ConceptViewAdapter extends RecyclerView.Adapter<ConceptViewHolder> {

    Context context;
    List<GrammarConcept> concepts;
    private static List<GrammarConcept> allConcepts = new ArrayList<>();

    public ConceptViewAdapter(Context context, List<GrammarConcept> concepts) {
        this.context = context;
        this.concepts = concepts;
    }

    @NonNull
    @Override
    public ConceptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConceptViewHolder(LayoutInflater.from(context).inflate(R.layout.grammar_concept_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ConceptViewHolder holder, int position) {
        holder.nameView.setText(concepts.get(position).getName());
        holder.summaryView.setText(concepts.get(position).getSummary());
        holder.contentDescription.setImageResource(concepts.get(position).getRelevantImage());
        holder.contentButton.setText(concepts.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return concepts.size();
    }


    public static List<GrammarConcept> getAllConcepts() {
        //add concepts here (also paste corresponding images in drawable folder)
        //arc de triomphe image not changing -- pick another
        allConcepts.add(new GrammarConcept("Present", "Current actions and conjugations", R.drawable.eiffel_tower));
        allConcepts.add(new GrammarConcept("Imparfait", "Habitual actions", R.drawable.macaron));
        allConcepts.add(new GrammarConcept("Passé Composé", "Past actions", R.drawable.frenchcafe));
        allConcepts.add(new GrammarConcept("Passé Recent", "Recently completed actions", R.drawable.brie));
        allConcepts.add(new GrammarConcept("Futur Simple", "Talk about the future and make predictions", R.drawable.beret));
        allConcepts.add(new GrammarConcept("Futur proche", "Future events occurring soon", R.drawable.flag));
        allConcepts.add(new GrammarConcept("Conditionnel", "Conditional statements in the present", R.drawable.snail));
        allConcepts.add(new GrammarConcept("Conditionnel Passé", "Conditional statements in the past", R.drawable.moulinrouge));
        allConcepts.add(new GrammarConcept("Plus Que Parfait", "Compound form of imparfait used to chain together multiple events", R.drawable.louvre));
        allConcepts.add(new GrammarConcept("Subjonctif", "Uncertainty or hypothetical states", R.drawable.lavender));
        allConcepts.add(new GrammarConcept("Indicatif", "Factual statements", R.drawable.eclaire));
        allConcepts.add(new GrammarConcept("Faire Causatif", "Causing performed action", R.drawable.chateaux));
        allConcepts.add(new GrammarConcept("L'Objets Directs et Indirects", "Identify and manipulate DOs and IDOs", R.drawable.locks));
        allConcepts.add(new GrammarConcept("Les Verbes Réfléchis", "Actions done to oneself", R.drawable.alps));

        return allConcepts;
    }


}
