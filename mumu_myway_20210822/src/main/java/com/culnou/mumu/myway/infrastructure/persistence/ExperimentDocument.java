package com.culnou.mumu.myway.infrastructure.persistence;

import org.springframework.data.mongodb.core.mapping.Document;

import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.vision.VisionId;
import com.culnou.mumu.myway.domain.model.person.vision.project.ExperimentId;
import com.culnou.mumu.myway.domain.model.person.vision.project.Measurement;

import lombok.Data;

@Document(collection = "experiments")
@Data
public class ExperimentDocument {
	private String id;
	private PersonId personId;
	private VisionId visionId;
	private ExperimentId experimentId;
	private String name;
	private String description;
	private Measurement mesurement;

}
