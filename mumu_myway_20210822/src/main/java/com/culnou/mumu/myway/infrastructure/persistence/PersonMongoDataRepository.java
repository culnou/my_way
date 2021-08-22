package com.culnou.mumu.myway.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.myway.domain.model.person.Person;

public interface PersonMongoDataRepository extends MongoRepository<PersonDocument, String> {

}
