package com.culnou.mumu.myway.domain.model.person.vision.project;

import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.vision.VisionId;

public class Experiment {
	
	private PersonId personId;
	private VisionId visionId;
	private ExperimentId experimentId;
	private String name;
	private String description;
	private Measurement mesurement;
	
	public Experiment(PersonId personId, VisionId visionId, ExperimentId experimentId, String name, String description) {
		this.setPersonId(personId);
		this.setVisionId(visionId);
		this.setExperimentId(experimentId);
		this.setName(name);
		this.setDescription(description);
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
	
	protected void setExperimentId(ExperimentId experimentId) {
		if(experimentId == null) {
			throw new IllegalArgumentException("The experimentId may not be set to null.");
		}
		this.experimentId = experimentId;
	}
	
	public ExperimentId experimentId() {
		return this.experimentId;
	}
	
	public void setName(String name) {
		if(name == null) {
			throw new IllegalArgumentException("The name may not be set to null.");
		}
		this.name = name;
	}
	
	public String name() {
		return this.name;
	}
	
	public void setDescription(String description) {
		if(description == null) {
			throw new IllegalArgumentException("The description may not be set to null.");
		}
		this.description = description;
	}
	
	public String description() {
		return this.description;
	}
	
	public void defineMeasurement(Measurement measurement) {
		if(measurement == null) {
			throw new IllegalArgumentException("The measurement may not be set to null.");
		}
		this.mesurement = measurement;
	}
	
	public Measurement measurement() {
		return this.mesurement;
	}

}
