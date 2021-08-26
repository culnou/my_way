package com.culnou.mumu.myway.domain.model.person.vision.project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.vision.VisionId;

public class ExperimentTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//NULLを防いで正しく初期化できる（セッターのテストも兼ねる）
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeByNoPersonId() {
		PersonId personId = null;
		VisionId visionId = new VisionId("111");
		ExperimentId experimentId = new ExperimentId("111");
		String name = "111";
		String description = "111";
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		//実行されない。
		experiment.name();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeByNoVisionId() {
		PersonId personId = new PersonId("111");
		VisionId visionId = null;
		ExperimentId experimentId = new ExperimentId("111");
		String name = "111";
		String description = "111";
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		//実行されない。
		experiment.name();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeByNoExperimentId() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		ExperimentId experimentId = null;
		String name = "111";
		String description = "111";
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		//実行されない。
		experiment.name();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeByNoName() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		ExperimentId experimentId = new ExperimentId("111");
		String name = null;
		String description = "111";
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		//実行されない。
		experiment.name();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeByNoDescription() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		ExperimentId experimentId = new ExperimentId("111");
		String name = "111";
		String description = null;
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		//実行されない。
		experiment.name();
	}
	
	//識別子オブジェクトが正しく設定される
	@Test
	public void testPersonId() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		ExperimentId experimentId = new ExperimentId("111");
		String name = "111";
		String description = "111";
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		assertEquals(experiment.personId(), personId);
	}
	
	@Test
	public void testVisionId() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		ExperimentId experimentId = new ExperimentId("111");
		String name = "111";
		String description = "111";
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		assertEquals(experiment.visionId(), visionId);
	}
	
	@Test
	public void testExperimentId() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		ExperimentId experimentId = new ExperimentId("111");
		String name = "111";
		String description = "111";
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		assertEquals(experiment.experimentId(), experimentId);
	}
	
	@Test
	public void testName() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		ExperimentId experimentId = new ExperimentId("111");
		String name = "111";
		String description = "111";
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		assertEquals(experiment.name(), name);
	}
	
	@Test
	public void testDescription() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		ExperimentId experimentId = new ExperimentId("111");
		String name = "111";
		String description = "111";
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		assertEquals(experiment.description(), description);
	}
	
	//測定の定義のテスト
	@Test
	public void testDefineMeasurement() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		ExperimentId experimentId = new ExperimentId("111");
		String name = "111";
		String description = "111";
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		Measurement measurement = new Measurement("111", "111");
		experiment.defineMeasurement(measurement);
		//測定は値オブジェクトなので等価。
		assertEquals(experiment.measurement(), measurement);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDefineNoMeasurement() {
		PersonId personId = new PersonId("111");
		VisionId visionId = new VisionId("111");
		ExperimentId experimentId = new ExperimentId("111");
		String name = "111";
		String description = "111";
		Experiment experiment = new Experiment(personId, visionId, experimentId, name, description);
		Measurement measurement = null;
		experiment.defineMeasurement(measurement);
		//実行されない。
		experiment.measurement();
	}

}
