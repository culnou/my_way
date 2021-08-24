package com.culnou.mumu.myway.domain.model.person.vision;

import com.culnou.mumu.myway.domain.model.person.PersonId;

public class Vision {
	
	private PersonId personId;
	private VisionId visionId;
	private VisionType visionType;
	private String content;
	private VisionId cause;
	private Strategy strategy;
	
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
	
	public void setCause(VisionId visionId) {
		if(visionId == null) {
			throw new IllegalArgumentException("The visionId may not be set to null.");
		}
		this.cause = visionId;
	}
	
	public VisionId cause() {
		return this.cause;
	}
	
	public void setStrategy(Strategy strategy) {
		if(strategy == null) {
			throw new IllegalArgumentException("The strategy may not be set to null.");
		}
		this.strategy = strategy;
	}
	
	public Strategy strategy() {
		return this.strategy;
	}

}
