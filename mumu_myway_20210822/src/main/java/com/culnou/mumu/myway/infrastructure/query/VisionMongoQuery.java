package com.culnou.mumu.myway.infrastructure.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.vision.Vision;
import com.culnou.mumu.myway.domain.model.person.vision.VisionId;
import com.culnou.mumu.myway.query.model.person.vision.VisionQuery;
@Service("visionMongoQuery")
@Transactional
public class VisionMongoQuery implements VisionQuery {
	
	@Autowired
	private VisionMongoDataQuery visionQuery;

	@Override
	public Vision findById(VisionId visionId) throws Exception {
		// TODO Auto-generated method stub
		Optional<VisionQueryDocument> readDoc = visionQuery.findById(visionId.id());
		if (readDoc.isPresent()){
			VisionQueryDocument doc = readDoc.get();
			return this.convertVisionQueryDocumentToVision(doc);
		}else {
			return null;
		}
	}
	@Override
	public List<Vision> findVisionsOfPerson(PersonId personId) throws Exception{
		List<VisionQueryDocument> docs = visionQuery.findVisionsByPersonId(personId);
		//検証用
		System.out.println("******* person " + docs.get(0).getPersonId().id());
		return convertVisionQueryDocumentsToVisions(docs);
	}
	@Override
	public List<Vision> findVisionsByVisionType(String type) throws Exception{
		List<VisionQueryDocument> docs = visionQuery.findVisionsByVisionType(type);
		return convertVisionQueryDocumentsToVisions(docs);
	}
	@Override
	public List<Vision> findVisionsCauseBy(VisionId cause) throws Exception {
		List<VisionQueryDocument> docs = visionQuery.findVisionsByCause(cause);
		//検証用
		System.out.println("******* cause " + docs.get(0).getCause().id());
		return convertVisionQueryDocumentsToVisions(docs);
	}
	
	@Override
	public boolean hasVisionsCauseBy(VisionId cause) throws Exception {
		// TODO Auto-generated method stub
		List<VisionQueryDocument> docs = visionQuery.findVisionsByCause(cause);
		//検証用
		System.out.println("******* cause " + docs.get(0).getCause().id());
		if(docs.size() > 0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	private Vision convertVisionQueryDocumentToVision(VisionQueryDocument doc) {
		Vision vision = new Vision(doc.getPersonId(), doc.getVisionId(), doc.getVisionType(), doc.getContent());
		if(doc.getCause() != null) {
			vision.setCause(doc.getCause());
		}
		if(doc.getStrategy() != null) {
			vision.setStrategy(doc.getStrategy());
		}
		return vision;
		
	}
	
	private List<Vision> convertVisionQueryDocumentsToVisions(List<VisionQueryDocument> docs) {
		List<Vision> visions = new ArrayList<>();
		for(VisionQueryDocument doc : docs) {
			Vision vision = convertVisionQueryDocumentToVision(doc);
			visions.add(vision);
		}
		return visions;
	}
	
	

}