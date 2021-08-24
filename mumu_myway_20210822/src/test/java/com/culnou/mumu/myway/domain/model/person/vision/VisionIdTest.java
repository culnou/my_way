package com.culnou.mumu.myway.domain.model.person.vision;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VisionIdTest {

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
		VisionId visionId = new VisionId(id);
		//実行されない。
		visionId.id();
	}
	//値オブジェクトの不変性のテスト。
	@Test
	public void testInvariant() {
		//自身とクローンの等価性検証。
		VisionId visionId = new VisionId("111");
		VisionId clone = visionId.clone();
		assertEquals(visionId, clone);
		//副作用のないメソッドの実行
		System.out.println(visionId.id());
		//メソッドを実行することによって自身の状態が変化していないか検証。
		assertEquals(visionId, clone);
	}
	//値オブジェクトの等価性のテスト。
	@Test
	public void testEquality() {
		VisionId id1 = new VisionId("111");
		VisionId id2 = new VisionId("111");
		assertEquals(id1, id2);
	}
	//値オブジェクトの交換可能性のテスト。
	@Test
	public void testExchangeability() {
		VisionId id1 = new VisionId("111");
		VisionId id2 = new VisionId("222");
		VisionId id3 = new VisionId("222");
		assertNotEquals(id1, id3);
		//id1をid2に置き換える。
		id1 = id2;
		assertEquals(id1, id3);
	}

}
