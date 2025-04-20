package com.example.melodical.Recommendation;

import com.example.melodical.SongDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }
    @PostMapping
    public ResponseEntity<List<RecommendationResult>> recommend(@RequestBody List<SongDto> songs){
        return ResponseEntity.ok(recommendationService.recommendMusicals(songs));
    }
}
