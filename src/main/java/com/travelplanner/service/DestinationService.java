package com.travelplanner.service;

import com.travelplanner.entity.Destination;
import com.travelplanner.exception.ResourceNotFoundException;
import com.travelplanner.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public List<Destination> getAllDestinations(){
        return destinationRepository.findAll();
    }

    public Destination saveDestination(Destination destination){
        return destinationRepository.save(destination);
    }

    public Destination updateDestination(Long id, Destination destinationDetails){
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found"));
        destination.setName(destinationDetails.getName());
        destination.setDescription(destinationDetails.getDescription());
        return destinationRepository.save(destination);
    }

    public void deleteDestination(Long id){
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("destination not found"));
        destinationRepository.delete(destination);
    }
}
