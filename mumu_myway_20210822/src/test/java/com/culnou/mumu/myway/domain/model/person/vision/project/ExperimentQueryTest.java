package com.culnou.mumu.myway.domain.model.person.vision.project;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.culnou.mumu.myway.domain.model.person.Person;
import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.vision.Vision;
import com.culnou.mumu.myway.domain.model.person.vision.VisionId;
import com.culnou.mumu.myway.domain.model.person.vision.VisionRepository;
import com.culnou.mumu.myway.domain.model.person.vision.VisionType;
import com.culnou.mumu.myway.query.model.person.vision.project.ExperimentQuery;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExperimentQueryTest {
	
	@Qualifier("experimentMongoRepository")
	@Autowired
	private ExperimentRepository experimentRepository;
	
	@Qualifier("experimentMongoQuery")
	@Autowired
	private ExperimentQuery experimentQuery;
	
	@Qualifier("visionMongoRepository")
	@Autowired
	private VisionRepository visionRepository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		experimentRepository.removeAll();
	}

	@Test
	public void testFindExperimentsOfVision() throws Exception{
		
		String name = "111";
		PersonId personId = new PersonId("111");
		Person person = new Person(personId, name);
		
		VisionId visionId = visionRepository.nextIdentity();
		VisionType visionType = VisionType.BUSINESS;
		String content = "111";
		
		Vision vision = person.createVision(visionId, visionType, content);
		
		ExperimentId experimentId = new ExperimentId("111");
		String experimentName = "111";
		String description = "111";
		Experiment experiment = vision.launchExperiment(experimentId, experimentName, description);
		Measurement measurement = new Measurement("111", "111");
		experiment.defineMeasurement(measurement);
		experimentRepository.save(experiment);
		List<Experiment> experiments = experimentQuery.findExperimentsOfVision(visionId);
		assertEquals(experiments.get(0).measurement(), measurement);
		assertEquals(experiments.get(0).visionId(), visionId);
	}

}
