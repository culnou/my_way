package com.culnou.mumu.myway.domain.model.person.vision.project;

import static org.junit.Assert.*;

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

import com.culnou.mumu.myway.query.model.person.vision.project.ProjectQuery;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepositoryTest {
	
	@Qualifier("projectMongoRepository")
	@Autowired
	private ProjectRepository projectRepository;
	
	@Qualifier("projectMongoQuery")
	@Autowired
	private ProjectQuery projectQuery;

	@Qualifier("visionMongoRepository")
	@Autowired
	private VisionRepository visionRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		//projectRepository.removeAll();
	}

	@Test
	public void testSaveAndFindOneproject() throws Exception{
		String name = "111";
		PersonId personId = new PersonId("111");
		Person person = new Person(personId, name);
		
		VisionId visionId = visionRepository.nextIdentity();
		VisionType visionType = VisionType.BUSINESS;
		String content = "111";
		
		Vision vision = person.createVision(visionId, visionType, content);
		
		ProjectId projectId = new ProjectId("111");
		String projectName = "111";
		String description = "111";
		Project project = vision.launchProject(projectId, projectName, description, ProjectType.EXPERIMENT);
		
		projectRepository.save(project);
		Project readproject = projectQuery.findById(projectId);
		assertEquals(readproject.personId(), personId);
		assertEquals(readproject.visionId(), visionId);
		assertEquals(readproject.projectId(), projectId);
		assertEquals(readproject.name(), projectName);
		assertEquals(readproject.description(), description);
		assertEquals(readproject.projectType(), ProjectType.EXPERIMENT);
		
	}

}
