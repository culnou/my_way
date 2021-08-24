package com.culnou.mumu.myway.domain.model.person;


import com.culnou.mumu.myway.domain.model.person.vision.Vision;
import com.culnou.mumu.myway.domain.model.person.vision.VisionId;
import com.culnou.mumu.myway.domain.model.person.vision.VisionType;

public class Person {
	
	private PersonId personId;
	private String name;
	
	
	public Person(PersonId personId, String name) {
		//自己カプセル化
		this.setPersonId(personId);
		this.setName(name);
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
	
	protected void setName(String name) {
		if(name == null) {
			throw new IllegalArgumentException("The name may not be set to null.");
		}
		this.name = name;
	}
	
	public String name() {
		return this.name;
	}
	
	//ファクトリーメソッド
	public Vision createVision(VisionId visionId, VisionType visionType, String content) throws Exception{
		if(visionId == null) {
			throw new IllegalArgumentException("The visionId may not be set to null.");
		}
		if(visionType == null) {
			throw new IllegalArgumentException("The visionType may not be set to null.");
		}
		if(content == null) {
			throw new IllegalArgumentException("The content may not be set to null.");
		}
		return new Vision(this.personId, visionId, visionType, content);
	}

}
