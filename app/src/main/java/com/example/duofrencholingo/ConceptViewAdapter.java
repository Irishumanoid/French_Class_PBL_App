package com.example.duofrencholingo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ConceptViewAdapter extends RecyclerView.Adapter<ConceptViewHolder> {

    Context context;
    List<GrammarConcept> concepts;

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
}
