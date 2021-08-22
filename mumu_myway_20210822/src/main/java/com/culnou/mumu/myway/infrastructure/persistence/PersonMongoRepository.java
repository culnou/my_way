package com.culnou.mumu.myway.infrastructure.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.culnou.mumu.myway.domain.model.person.Person;
import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.PersonRepository;
@Service("personMongoRepository")
@Transactional
public class PersonMongoRepository implements PersonRepository {

	@Autowired
	private PersonMongoDataRepository personRepository;
	
	@Override
	public PersonId nextIdentity() throws Exception {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        
		return new PersonId(str);
	}

	@Override
	public Person findById(PersonId personId) throws Exception {
		// TODO Auto-generated method stub
		Optional<PersonDocument> readDoc = personRepository.findById(personId.id());
		if (readDoc.isPresent()){
			PersonDocument doc = readDoc.get();
			return this.convertPersonDocumentToPerson(doc);
		}else {
			return null;
		}
	}

	@Override
	public void save(Person person) throws Exception {
		// TODO Auto-generated method stub
		PersonDocument doc = this.convertPersonToPersonDocument(person);
		personRepository.save(doc);
		

	}

	@Override
	public void remove(Person person) throws Exception {
		// TODO Auto-generated method stub
		PersonDocument doc = this.convertPersonToPersonDocument(person);
		personRepository.delete(doc);

	}
	
	@Override
	public void removeAll() throws Exception{
		personRepository.deleteAll();
	}
	
	private PersonDocument convertPersonToPersonDocument(Person person) {
		PersonDocument doc = new PersonDocument();
		doc.setId(person.personId().id());
		doc.setPersonId(person.personId());
		doc.setName(person.name());
		return doc;
	}
	
	private Person convertPersonDocumentToPerson(PersonDocument doc) {
		return new Person(doc.getPersonId(), doc.getName());
		
	}

}
