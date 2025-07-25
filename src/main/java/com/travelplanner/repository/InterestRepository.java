package com.travelplanner.repository;

import com.travelplanner.entity.Interest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interest,Long>{

    Page<Interest> findAll(Pageable pageable);
}
