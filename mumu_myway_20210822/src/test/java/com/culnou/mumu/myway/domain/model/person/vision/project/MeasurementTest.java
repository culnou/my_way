package com.culnou.mumu.myway.domain.model.person.vision.project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MeasurementTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetIndicator() {
		String indicator = null;
		String criteria = "111";
		Measurement mesurement = new Measurement(indicator, criteria);
		//実行されない。
		mesurement.indicator();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSetCriteria() {
		String indicator = "111";
		String criteria = null;
		Measurement mesurement = new Measurement(indicator, criteria);
		//実行されない。
		mesurement.indicator();
	}
	@Test
	public void testInvariant() {
		//自身とクローンの等価性検証。
		Measurement measurement = new Measurement("111", "111");
		Measurement clone = measurement.clone();
		assertEquals(measurement, clone);
		//副作用のないメソッドの実行
		System.out.println(measurement.indicator());
		//メソッドを実行することによって自身の状態が変化していないか検証。
		assertEquals(measurement, clone);
	}
	@Test
	public void testEquality() {
		Measurement mesurement1 = new Measurement("111", "111");
		Measurement mesurement2 = new Measurement("111", "111");
		assertEquals(mesurement1, mesurement2);
	}
	@Test
	public void testExchangeability() {
		Measurement mesurement1 = new Measurement("111", "111");
		Measurement mesurement2 = new Measurement("222", "222");
		Measurement mesurement3 = new Measurement("222", "222");
		assertNotEquals(mesurement1, mesurement3);
		mesurement1 = mesurement2;
		assertEquals(mesurement1, mesurement3);
	}

}
