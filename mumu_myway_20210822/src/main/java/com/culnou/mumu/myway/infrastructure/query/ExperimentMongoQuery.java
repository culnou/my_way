package com.culnou.mumu.myway.infrastructure.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.myway.domain.model.person.vision.VisionId;
import com.culnou.mumu.myway.domain.model.person.vision.project.Experiment;
import com.culnou.mumu.myway.domain.model.person.vision.project.ExperimentId;
import com.culnou.mumu.myway.query.model.person.vision.project.ExperimentQuery;
@Service("experimentMongoQuery")
@Transactional
public class ExperimentMongoQuery implements ExperimentQuery {
	
	@Autowired
	private ExperimentMongoDataQuery experimentQuery;

	@Override
	public Experiment findById(ExperimentId experimentId) throws Exception {
		// TODO Auto-generated method stub
		Optional<ExperimentQueryDocument> readDoc = experimentQuery.findById(experimentId.id());
		if (readDoc.isPresent()){
			ExperimentQueryDocument doc = readDoc.get();
			return this.convertExperimentQueryDocumentToExperiment(doc);
		}else {
			return null;
		}
	}
	
	@Override
	public List<Experiment> findExperimentsOfVision(VisionId visionId) throws Exception {
		// TODO Auto-generated method stub
		List<ExperimentQueryDocument> docs = experimentQuery.findExperimentsByVisionId(visionId);
		//検証用
		System.out.println("******* vision " + docs.get(0).getVisionId().id());
		return convertExperimentQueryDocumentsToExperiments(docs);
	}
	
	private Experiment convertExperimentQueryDocumentToExperiment(ExperimentQueryDocument doc) {
		Experiment experiment = new Experiment(doc.getPersonId(), doc.getVisionId(), doc.getExperimentId(), doc.getName(), doc.getDescription());
		if(doc.getMesurement() != null) {
			experiment.defineMeasurement(doc.getMesurement());
		}
		return experiment;
		
	}
	
	private List<Experiment> convertExperimentQueryDocumentsToExperiments(List<ExperimentQueryDocument> docs) {
		List<Experiment> experiments = new ArrayList<>();
		for(ExperimentQueryDocument doc : docs) {
			Experiment experiment = convertExperimentQueryDocumentToExperiment(doc);
			experiments.add(experiment);
		}
		return experiments;
	}



	

}
