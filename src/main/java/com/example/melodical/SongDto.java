package com.example.melodical;

import java.util.List;

public class SongDto {
    private String id;
    private List<String> genres;

    public SongDto(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
