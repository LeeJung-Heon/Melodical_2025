package com.example.melodical.Recommendation;

import java.util.List;

public class RecommendationResult {
    private String title;
    private List<String> genres;
    private double similarity;

    public RecommendationResult(String title, List<String> genres, double similarity) {
        this.title = title;
        this.genres = genres;
        this.similarity = similarity;
    }
    public String getTitle() {
        return title;
    }
    public List<String> getGenres() {
        return genres;
    }
    public double getSimilarity() {
        return similarity;
    }
}
