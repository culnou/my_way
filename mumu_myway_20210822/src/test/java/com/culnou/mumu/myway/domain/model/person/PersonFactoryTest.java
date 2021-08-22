package com.culnou.mumu.myway.domain.model.person;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createPersonTest() {
		UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        User user = new User(str, "user1");
        Person person = PersonFactory.creatPerson(user);
        assertNotNull(person);
        assertEquals(person.personId().id(), user.id());
        assertEquals(person.name(), user.name());
	}

}
