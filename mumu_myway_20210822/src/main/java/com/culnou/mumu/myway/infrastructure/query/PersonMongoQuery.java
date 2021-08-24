package com.culnou.mumu.myway.infrastructure.query;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.myway.domain.model.person.Person;
import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.query.model.person.PersonQuery;

@Service("personMongoQuery")
@Transactional
public class PersonMongoQuery implements PersonQuery{
	
	@Autowired
	private PersonMongoDataQuery personQuery;

	@Override
	public Person findById(PersonId personId) throws Exception {
		// TODO Auto-generated method stub
		Optional<PersonQueryDocument> readDoc = personQuery.findById(personId.id());
		if (readDoc.isPresent()){
			PersonQueryDocument doc = readDoc.get();
			return this.convertPersonQueryDocumentToPerson(doc);
		}else {
			return null;
		}
	}
		
	private Person convertPersonQueryDocumentToPerson(PersonQueryDocument doc) {
		Person person = new Person(doc.getPersonId(), doc.getName());
		return person;
			
	}

}
