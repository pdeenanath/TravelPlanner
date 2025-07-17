package com.travelplanner.controller;

import com.travelplanner.entity.Destination;
import com.travelplanner.exception.ResourceNotFoundException;
import com.travelplanner.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public List<Destination> getAllDestinations(){
         return destinationService.getAllDestinations();
    }

    @PostMapping
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination){
        Destination createDestination = destinationService.saveDestination(destination);
        return new ResponseEntity<>(createDestination, HttpStatus.CREATED);
    }

   @PutMapping("/{id}")
    public ResponseEntity<Destination> updateDestination(@PathVariable Long id, @RequestBody Destination destinationDetails){
        try{
            Destination updateDestination = destinationService.updateDestination(id, destinationDetails);
            return ResponseEntity.ok(updateDestination);
        }
        catch(ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDsstination(@PathVariable Long id){
        try{
            destinationService.deleteDestination(id);
            return ResponseEntity.noContent().build();
        }
        catch(ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
   }

}
