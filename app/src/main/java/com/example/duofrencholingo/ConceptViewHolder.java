package com.example.duofrencholingo;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ConceptViewHolder extends RecyclerView.ViewHolder {
    ImageView contentDescription;
    TextView nameView, summaryView;
    Button contentButton;

    public ConceptViewHolder(@NonNull View itemView) {
        super(itemView);
        contentDescription = itemView.findViewById(R.id.concept_image);
        nameView = itemView.findViewById(R.id.name);
        summaryView = itemView.findViewById(R.id.summary);
        contentButton = itemView.findViewById(R.id.go_learn_content);
    }
}
