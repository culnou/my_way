package com.culnou.mumu.myway.domain.model.person.vision.project.action;

import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.vision.project.ProjectId;

public class Action {
	
	private PersonId personId;
	private ProjectId projectId;
	private ActionId actionId;
	private String name;
	private String description;
	private int expendedTime;
	
	
	public Action(PersonId personId, ProjectId projectId, ActionId actionId, String name, String description) {
		this.setPersonId(personId);
		this.setProjectId(projectId);
		this.setActionId(actionId);
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
	
	protected void setProjectId(ProjectId projectId) {
		if(projectId == null) {
			throw new IllegalArgumentException("The projectId may not be set to null.");
		}
		this.projectId = projectId;
	}
	
	public ProjectId projectId() {
		return this.projectId;
	}
	
	protected void setActionId(ActionId actionId) {
		if(actionId == null) {
			throw new IllegalArgumentException("The actionId may not be set to null.");
		}
		this.actionId = actionId;
	}
	
	public ActionId actionId() {
		return this.actionId;
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
	
	public void setExpendedTime(int expendedTime) {
		if(expendedTime < 0) {
			throw new IllegalArgumentException("The expendedTime may be negative.");
		}
		this.expendedTime = expendedTime;
	}
	
	public int expendedTime() {
		return this.expendedTime;
	}

}
