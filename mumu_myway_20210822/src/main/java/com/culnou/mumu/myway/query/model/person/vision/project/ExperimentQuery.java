package com.culnou.mumu.myway.query.model.person.vision.project;


import java.util.List;



import com.culnou.mumu.myway.domain.model.person.vision.VisionId;
import com.culnou.mumu.myway.domain.model.person.vision.project.Experiment;
import com.culnou.mumu.myway.domain.model.person.vision.project.ExperimentId;

public interface ExperimentQuery {
	
	public Experiment findById(ExperimentId experimentId) throws Exception;
	
	public List<Experiment> findExperimentsOfVision(VisionId visionId) throws Exception;

}
