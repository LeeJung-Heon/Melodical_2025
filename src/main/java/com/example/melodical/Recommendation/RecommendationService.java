package com.example.melodical.Recommendation;

import com.example.melodical.MusicalData;
import com.example.melodical.SongDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RecommendationService {
    private final List<MusicalData> musicalDatabase = List.of(
            new MusicalData("Wicked", List.of("Pop", "Classical")),
            new MusicalData("Hamilton", List.of("Hip-Hop", "R&B", "Spoken")),
            new MusicalData("Hadestown", List.of("Jazz", "Folk"))
    );
    private final List<String> genreTags = List.of("Pop", "Rock", "Jazz", "Ballad", "Electronic", "Classical", "Hip-Hop", "R&B", "Folk");

    public List<RecommendationResult> recommendMusicals(List<SongDto> songs) {
        int[] userVector = new int[genreTags.size()];

        for(SongDto song : songs){
            for(String genre : song.getGenres()){
                int idx = genreTags.indexOf(genre);
                if(idx >= 0) userVector[idx]++;
            }
        }
        List<RecommendationResult> results = new ArrayList<>();
        for(MusicalData musical : musicalDatabase){
            int[] musicalVector = new int[genreTags.size()];
            for(String genre : musical.getGenres()){
                int idx = genreTags.indexOf(genre);
                if(idx >= 0) musicalVector[idx] = 1;
            }
            double similarity = cosineSimilarity(userVector, musicalVector);
            results.add(new RecommendationResult(musical.getTitle(), musical.getGenres(), similarity));
        }
        return results.stream().sorted(Comparator.comparingDouble(RecommendationResult::getSimilarity).reversed()).collect(Collectors.toList());
    }
    private double cosineSimilarity(int[] vecA, int[] vecB) {
        double dot = 0.0, normA = 0.0, normB = 0.0;
        for(int i = 0; i < vecA.length; i++){
            dot += vecA[i] * vecB[i];
            normA += vecA[i] * vecA[i];
            normB += vecB[i] * vecB[i];
        }
        return normA ==0 || normB == 0 ? 0.0 : dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}
