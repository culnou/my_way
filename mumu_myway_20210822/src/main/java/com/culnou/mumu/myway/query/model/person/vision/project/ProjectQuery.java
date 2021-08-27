package com.culnou.mumu.myway.query.model.person.vision.project;


import java.util.List;



import com.culnou.mumu.myway.domain.model.person.vision.VisionId;
import com.culnou.mumu.myway.domain.model.person.vision.project.Project;
import com.culnou.mumu.myway.domain.model.person.vision.project.ProjectId;
import com.culnou.mumu.myway.domain.model.person.vision.project.ProjectType;

public interface ProjectQuery {
	
	public Project findById(ProjectId experimentId) throws Exception;
	
	public List<Project> findProjectsOfProjectType(ProjectType projectType) throws Exception;
	
	public List<Project> findProjectsOfVision(VisionId visionId) throws Exception;

}
