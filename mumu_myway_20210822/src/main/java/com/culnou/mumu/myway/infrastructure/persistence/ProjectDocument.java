package com.culnou.mumu.myway.infrastructure.persistence;

import org.springframework.data.mongodb.core.mapping.Document;

import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.vision.VisionId;
import com.culnou.mumu.myway.domain.model.person.vision.project.ProjectId;
import com.culnou.mumu.myway.domain.model.person.vision.project.ProjectType;
import com.culnou.mumu.myway.domain.model.person.vision.project.Goal;

import lombok.Data;

@Document(collection = "projects")
@Data
public class ProjectDocument {
	private String id;
	private PersonId personId;
	private VisionId visionId;
	private ProjectId projectId;
	private String name;
	private String description;
	private ProjectType projectType;
	private Goal goal;

}
