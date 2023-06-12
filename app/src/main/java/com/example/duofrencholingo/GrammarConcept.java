package com.example.duofrencholingo;

public class GrammarConcept {
    private String name;
    private String summary;
    private int relevantImage; //corresponds to drawable index


    public GrammarConcept(String name, String summary, int relevantImage) {
        this.name = name;
        this.summary = summary;
        this.relevantImage = relevantImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public int getRelevantImage() {
        return relevantImage;
    }

    public void setRelevantImage(int relevantImage) {
        this.relevantImage = relevantImage;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
