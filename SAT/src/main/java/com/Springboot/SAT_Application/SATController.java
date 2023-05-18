package com.Springboot.SAT_Application;

import java.util.*;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	private List<SATResult> satResults = new ArrayList<>();

    @PostMapping("/User")
    public SATResult addSATResult(@RequestBody SATResult satResult) {
        // Generate a unique identifier for the name field
        String id = UUID.randomUUID().toString();
        satResult.setId(id);

        // Calculate the "passed" field based on the SAT score
        satResult.setPassed(satResult.getSatScore());

        // Store the SAT result in memory
        satResults.add(satResult);

        return satResult;
    }

    @GetMapping("/All-candidate")
    public List<SATResult> getAllSATResults() {
        return satResults;
    }

    @GetMapping("/get-rank/{name}")
    public int getrankbyname(@PathVariable String name) {
        for (int i = 0; i < satResults.size(); i++) {
            if (satResults.get(i).getName().equalsIgnoreCase(name)) {
                return i + 1; // Return the rank (position + 1)
            }
        }
        return -1; // Return -1 if name not found
    }

    @PutMapping("/update-score/{name}")
    public SATResult updatescorebyname(@PathVariable String name, @RequestParam int satScore) {
        for (SATResult satResult : satResults) {
            if (satResult.getName().equalsIgnoreCase(name)) {
                satResult.setSatScore(satScore);
                satResult.setPassed(satScore);
                return satResult;
            }
        }
        return null; // Return null if name not found
    }
    @DeleteMapping("/delete-candidate/{name}")
    public ResponseEntity<String> deletecandidatebyname(@PathVariable String name) {
        SATResult foundResult = null;
        for (SATResult satResult : satResults) {
            if (satResult.getName().equalsIgnoreCase(name)) {
                foundResult = satResult;
                break;
            }
        }
        
        if (foundResult != null) {
            satResults.remove(foundResult);
            return ResponseEntity.ok("Record deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    }
