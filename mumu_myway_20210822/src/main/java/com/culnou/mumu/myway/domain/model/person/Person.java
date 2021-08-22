package com.culnou.mumu.myway.domain.model.person;

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

}
