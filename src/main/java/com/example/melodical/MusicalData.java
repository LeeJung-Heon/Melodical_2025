package com.example.melodical;

import java.util.List;

public class MusicalData {
    private final String title;
    private final List<String> genres;

    public MusicalData(String title, List<String> genres) {
        this.title = title;
        this.genres = genres;
    }
    public String getTitle() {
        return title;
    }
    public List<String> getGenres() {
        return genres;
    }
}
