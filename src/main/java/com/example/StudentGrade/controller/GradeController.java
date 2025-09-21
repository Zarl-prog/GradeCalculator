package com.example.studentgrade.controller;

import com.example.studentgrade.dto.StudentRequest;
import com.example.studentgrade.dto.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin(origins = "*") // allow frontend calls
public class GradeController {

    @PostMapping
    public ResponseEntity<StudentResponse> calculateGrade(@Valid @RequestBody StudentRequest request) {
        int total = request.getScores().stream().mapToInt(Integer::intValue).sum();
        double average = (double) total / request.getScores().size();

        String grade;
        if (average >= 90) grade = "A";
        else if (average >= 80) grade = "B";
        else if (average >= 70) grade = "C";
        else if (average >= 60) grade = "D";
        else grade = "F";

        return ResponseEntity.ok(new StudentResponse(request.getName(), total, average, grade));
    }
}
