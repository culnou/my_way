package com.culnou.mumu.myway.domain.model.person;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//NULLを防いで正しく初期化できる（セッターのテストも兼ねる）
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeByName() {
		String name = "111";
		Person person = new Person(null, name);
		//実行されない。
		person.name();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeByUserId() {
		PersonId personId = new PersonId("111");
		Person person = new Person(personId, null);
		//実行されない。
		person.name();
	}
	
	//識別子オブジェクトが正しく設定される
	@Test
	public void testPersonId() {
		String name = "111";
		PersonId personId1 = new PersonId("111");
		Person person = new Person(personId1, name);
		PersonId personId2 = person.personId();
		assertEquals(personId1, personId2);
	}

}
