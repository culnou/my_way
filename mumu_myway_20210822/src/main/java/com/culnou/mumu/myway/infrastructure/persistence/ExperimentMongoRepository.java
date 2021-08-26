package com.culnou.mumu.myway.infrastructure.persistence;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.culnou.mumu.myway.domain.model.person.vision.project.Experiment;
import com.culnou.mumu.myway.domain.model.person.vision.project.ExperimentId;
import com.culnou.mumu.myway.domain.model.person.vision.project.ExperimentRepository;
@Service("experimentMongoRepository")
@Transactional
public class ExperimentMongoRepository implements ExperimentRepository {

	@Autowired
	private ExperimentMongoDataRepository experimentRepository;

	@Override
	public ExperimentId nextIdentity() throws Exception {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        
		return new ExperimentId(str);
	}

	@Override
	public void save(Experiment experiment) throws Exception {
		// TODO Auto-generated method stub
		ExperimentDocument doc = this.convertExperimentToExperimentDocument(experiment);
		experimentRepository.save(doc);
	}

	@Override
	public void remove(Experiment experiment) throws Exception {
		// TODO Auto-generated method stub
		ExperimentDocument doc = this.convertExperimentToExperimentDocument(experiment);
		experimentRepository.delete(doc);
	}

	@Override
	public void removeAll() throws Exception {
		// TODO Auto-generated method stub
		experimentRepository.deleteAll();
		
	}
	
	private ExperimentDocument convertExperimentToExperimentDocument(Experiment experiment) {
		ExperimentDocument doc = new ExperimentDocument();
		doc.setId(experiment.experimentId().id());
		doc.setPersonId(experiment.personId());
		doc.setVisionId(experiment.visionId());
		doc.setExperimentId(experiment.experimentId());
		doc.setName(experiment.name());
		doc.setDescription(experiment.description());
		doc.setMesurement(experiment.measurement());
		return doc;
	}
	
	
}
