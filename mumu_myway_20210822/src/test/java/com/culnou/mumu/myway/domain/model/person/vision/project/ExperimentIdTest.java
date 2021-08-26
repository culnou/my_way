package com.culnou.mumu.myway.domain.model.person.vision.project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class ExperimentIdTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//自己カプセル化のセッターの例外テスト：NULLを防いで正しく初期化できる
	@Test(expected = IllegalArgumentException.class)
	public void testSetId() {
		String id = null;
		ExperimentId experimentId = new ExperimentId(id);
		//実行されない。
		experimentId.id();
	}
	
	//値オブジェクトの不変性のテスト。
	@Test
	public void testInvariant() {
		//自身とクローンの等価性検証。
		ExperimentId experimentId = new ExperimentId("111");
		ExperimentId clone = experimentId.clone();
		assertEquals(experimentId, clone);
		//副作用のないメソッドの実行
		System.out.println(experimentId.id());
		//メソッドを実行することによって自身の状態が変化していないか検証。
		assertEquals(experimentId, clone);
	}
	@Test
	public void testEquality() {
		ExperimentId id1 = new ExperimentId("111");
		ExperimentId id2 = new ExperimentId("111");
		assertEquals(id1, id2);
	}
	@Test
	public void testExchangeability() {
		ExperimentId id1 = new ExperimentId("111");
		ExperimentId id2 = new ExperimentId("222");
		ExperimentId id3 = new ExperimentId("222");
		assertNotEquals(id1, id3);
		//id1をid2に置き換える。
		id1 = id2;
		assertEquals(id1, id3);
	}

}
