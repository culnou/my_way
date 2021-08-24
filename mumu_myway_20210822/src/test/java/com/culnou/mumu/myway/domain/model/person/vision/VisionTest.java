package com.culnou.mumu.myway.domain.model.person.vision;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.culnou.mumu.myway.domain.model.person.PersonId;

public class VisionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//NULLを防いで正しく初期化できる（セッターのテストも兼ねる）
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeByPersonId() {
		VisionId visionId = new VisionId("111");
		VisionType visionType = VisionType.BUSINESS;
		String content = "111";
		Vision vision = new Vision(null, visionId, visionType, content);
		//実行されない。
		vision.content();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeByVisionId() {
		PersonId personId = new PersonId("111");
		VisionType visionType = VisionType.BUSINESS;
		String content = "111";
		Vision vision = new Vision(personId, null, visionType, content);
		//実行されない。
		vision.content();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeByVisionType() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		String content = "111";
		Vision vision = new Vision(personId, visionId, null, content);
		//実行されない。
		vision.content();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeByContent() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		VisionType visionType = VisionType.BUSINESS;
		Vision vision = new Vision(personId, visionId, visionType, null);
		//実行されない。
		vision.content();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNullCause() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		VisionType visionType = VisionType.BUSINESS;
		String content = "111";
		Vision vision = new Vision(personId, visionId, visionType, content);
		vision.setCause(null);
		//実行されない。
		vision.content();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNullStrategy() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		VisionType visionType = VisionType.BUSINESS;
		String content = "111";
		Vision vision = new Vision(personId, visionId, visionType, content);
		vision.setStrategy(null);
		//実行されない。
		vision.content();
	}
	
	//識別子オブジェクトが正しく設定される
	@Test
	public void testPersonId() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		VisionType visionType = VisionType.BUSINESS;
		String content = "111";
		Vision vision = new Vision(personId, visionId, visionType, content);
		assertEquals(vision.personId(), personId);
	}
	
	@Test
	public void testVisionId() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		VisionType visionType = VisionType.BUSINESS;
		String content = "111";
		Vision vision = new Vision(personId, visionId, visionType, content);
		assertEquals(vision.visionId(), visionId);
	}
	
	@Test
	public void testCause() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		VisionType visionType = VisionType.BUSINESS;
		String content = "111";
		Vision vision = new Vision(personId, visionId, visionType, content);
		VisionId cause = new VisionId("111");
		vision.setCause(cause);
		assertEquals(vision.cause(), cause);
	}
	
	@Test
	public void testStrategy() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		VisionType visionType = VisionType.BUSINESS;
		String content = "111";
		Vision vision = new Vision(personId, visionId, visionType, content);
		Strategy strategy = new Strategy("111", "111");
		vision.setStrategy(strategy);
		assertEquals(vision.strategy(), strategy);
	}
	
	//列挙型が正しく設定される
	@Test
	public void testVisionType() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		VisionType visionType = VisionType.BUSINESS;
		String content = "111";
		Vision vision = new Vision(personId, visionId, visionType, content);
		assertEquals(vision.visionType(), VisionType.BUSINESS);
	}

}
