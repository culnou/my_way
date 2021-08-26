package com.culnou.mumu.myway.infrastructure.query;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.myway.domain.model.person.vision.VisionId;

public interface ExperimentMongoDataQuery extends MongoRepository<ExperimentQueryDocument, String> {
	
	@Query("{ 'visionId' : ?0}")
	List<ExperimentQueryDocument> findExperimentsByVisionId(VisionId visionId);

}
