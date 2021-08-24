package com.culnou.mumu.myway.infrastructure.query;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.vision.VisionId;

public interface VisionMongoDataQuery extends MongoRepository<VisionQueryDocument, String> {

	@Query("{ 'visionType' : ?0 }")
	List<VisionQueryDocument> findVisionsByVisionType(String type);
	
	
	@Query("{ 'personId' : ?0}")
	List<VisionQueryDocument> findVisionsByPersonId(PersonId personId);
	
	@Query("{ 'cause' : ?0}")
	List<VisionQueryDocument> findVisionsByCause(VisionId cause);
	
}
