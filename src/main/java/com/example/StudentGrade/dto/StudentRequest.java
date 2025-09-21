package com.example.studentgrade.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public class StudentRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotEmpty(message = "Scores cannot be empty")
    private List<
        @Min(value = 0, message = "Score must be >= 0")
        @Max(value = 100, message = "Score must be <= 100")
    Integer> scores;

    // Getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Integer> getScores() { return scores; }
    public void setScores(List<Integer> scores) { this.scores = scores; }
}
