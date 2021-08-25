package com.culnou.mumu.myway.infrastructure.persistence;

import org.springframework.data.mongodb.core.mapping.Document;

import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.vision.Strategy;
import com.culnou.mumu.myway.domain.model.person.vision.VisionId;
import com.culnou.mumu.myway.domain.model.person.vision.VisionType;

import lombok.Data;

@Document(collection = "visions")
@Data
public class VisionDocument {
	
	private String id;
	private PersonId personId;
	private VisionId visionId;
	private VisionType visionType;
	private String content;
	private VisionId result;
	private Strategy strategy;

}
