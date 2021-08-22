package com.culnou.mumu.myway.domain.model.person;

public class PersonFactory {
	
	public static Person creatPerson(User user) {
		return new Person(new PersonId(user.id()), user.name());
	}

}
