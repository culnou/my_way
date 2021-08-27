package com.culnou.mumu.myway.infrastructure.persistence;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.culnou.mumu.myway.domain.model.person.vision.project.Project;
import com.culnou.mumu.myway.domain.model.person.vision.project.ProjectId;
import com.culnou.mumu.myway.domain.model.person.vision.project.ProjectRepository;
@Service("projectMongoRepository")
@Transactional
public class ProjectMongoRepository implements ProjectRepository {

	@Autowired
	private ProjectMongoDataRepository projectRepository;

	@Override
	public ProjectId nextIdentity() throws Exception {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        
		return new ProjectId(str);
	}

	@Override
	public void save(Project project) throws Exception {
		// TODO Auto-generated method stub
		ProjectDocument doc = this.convertExperimentToExperimentDocument(project);
		projectRepository.save(doc);
	}

	@Override
	public void remove(Project project) throws Exception {
		// TODO Auto-generated method stub
		ProjectDocument doc = this.convertExperimentToExperimentDocument(project);
		projectRepository.delete(doc);
	}

	@Override
	public void removeAll() throws Exception {
		// TODO Auto-generated method stub
		projectRepository.deleteAll();
		
	}
	
	private ProjectDocument convertExperimentToExperimentDocument(Project project) {
		ProjectDocument doc = new ProjectDocument();
		doc.setId(project.projectId().id());
		doc.setPersonId(project.personId());
		doc.setVisionId(project.visionId());
		doc.setProjectId(project.projectId());
		doc.setName(project.name());
		doc.setDescription(project.description());
		doc.setProjectType(project.projectType());
		doc.setGoal(project.goal());
		return doc;
	}
	
	
}
