package com.culnou.mumu.myway.domain.model.person.vision;

import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.vision.project.Project;
import com.culnou.mumu.myway.domain.model.person.vision.project.ProjectId;
import com.culnou.mumu.myway.domain.model.person.vision.project.ProjectType;

public class Vision {
	
	private PersonId personId;
	private VisionId visionId;
	private VisionType visionType;
	private String content;
	
	public Vision(PersonId personId, VisionId visionId, VisionType visionType, String content) {
		this.setPersonId(personId);
		this.setVisionId(visionId);
		this.setVisionType(visionType);
		this.setContent(content);
	}
	
	protected void setPersonId(PersonId personId) {
		if(personId == null) {
			throw new IllegalArgumentException("The personId may not be set to null.");
		}
		this.personId = personId;
	}
	
	public PersonId personId() {
		return this.personId;
	}
	
	protected void setVisionId(VisionId visionId) {
		if(visionId == null) {
			throw new IllegalArgumentException("The visionId may not be set to null.");
		}
		this.visionId = visionId;
	}
	
	public VisionId visionId() {
		return this.visionId;
	}
	
	protected void setVisionType(VisionType visionType) {
		if(visionType == null) {
			throw new IllegalArgumentException("The visionType may not be set to null.");
		}
		this.visionType = visionType;
	}
	
	public VisionType visionType() {
		return this.visionType;
	}
	
	protected void setContent(String content) {
		if(content == null) {
			throw new IllegalArgumentException("The content may not be set to null.");
		}
		this.content = content;
	}
	
	public String content() {
		return this.content;
	}
	
	//ファクトリーメソッド
	public Project launchProject(ProjectId experimentId, String name, String description, ProjectType projectType) {
		if(experimentId == null) {
			throw new IllegalArgumentException("The experimentId may not be set to null.");
		}
		if(name == null) {
			throw new IllegalArgumentException("The name may not be set to null.");
		}
		if(description == null) {
			throw new IllegalArgumentException("The description may not be set to null.");
		}
		if(projectType == null) {
			throw new IllegalArgumentException("The projectType may not be set to null.");
		}
		return new Project(this.personId(), this.visionId(), experimentId, name, description, projectType);
	}
	
}
