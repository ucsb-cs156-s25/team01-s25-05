package edu.ucsb.cs156.example.repositories;

import edu.ucsb.cs156.example.entities.RecommendationRequest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The  is a RecommandationRequestRepository repository for RecommationRequest entities.
 */

@Repository
public interface RecommandationRequestRepository extends CrudRepository<RecommendationRequest, Long> {
 
}