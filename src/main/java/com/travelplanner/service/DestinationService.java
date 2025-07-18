package com.travelplanner.service;

import com.travelplanner.entity.Destination;
import com.travelplanner.exception.ResourceNotFoundException;
import com.travelplanner.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public List<Destination> getAllDestinations(){
        return destinationRepository.findAll();
    }

    /**
     * Retrieves all destinations with pagination.
     * @param pageRequest the pagination information.
     * @return a paginated list of destinations.
     */
    public Page<Destination> getAllDestinations(PageRequest pageRequest){
        return destinationRepository.findAll(pageRequest);
    }

    /**
     * Retrieves destinations by name with pagination.
     * @param name the name to search for.
     * @param pageRequest the pagination information.
     * @return a paginated list of destinations matching the search criteria.
     */
    public Page<Destination> getDestinationsByName(String name, PageRequest pageRequest){
        return destinationRepository.findByNameContaining(name, pageRequest);
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
