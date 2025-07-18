package com.travelplanner.controller;

import com.travelplanner.entity.Interest;
import com.travelplanner.exception.ResourceNotFoundException;
import com.travelplanner.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/interests")
public class InterestController {

    @Autowired
    private InterestService interestService;

    @GetMapping
    public ResponseEntity<List<Interest>> getAllInterests() {
        List<Interest> interests = interestService.getAllInterests();
        return ResponseEntity.ok(interests);
    }

    @PostMapping
    public ResponseEntity<Interest> createInterest(@RequestBody Interest interest) {
        Interest createdInterest = interestService.saveInterest(interest);
        return new ResponseEntity<>(createdInterest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interest> updateInterest(@PathVariable long id, @RequestBody Interest interestDetails) {
        try {
            Interest updatedInterest = interestService.updateInterest(id, interestDetails);
            return ResponseEntity.ok(updatedInterest);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInterest(@PathVariable Long id) {
        try {
            interestService.deleteInterest(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
