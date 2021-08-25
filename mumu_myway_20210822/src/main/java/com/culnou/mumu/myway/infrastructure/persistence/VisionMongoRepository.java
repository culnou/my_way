package com.culnou.mumu.myway.infrastructure.persistence;




import com.culnou.mumu.myway.domain.model.person.vision.Vision;
import com.culnou.mumu.myway.domain.model.person.vision.VisionId;
import com.culnou.mumu.myway.domain.model.person.vision.VisionRepository;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("visionMongoRepository")
@Transactional
public class VisionMongoRepository implements VisionRepository {
	
	@Autowired
	private VisionMongoDataRepository visionRepository;

	@Override
	public VisionId nextIdentity() throws Exception {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        
		return new VisionId(str);
	}
    
	@Override
	public void save(Vision vision) throws Exception {
		// TODO Auto-generated method stub
		VisionDocument doc = this.convertVisionToVisionDocument(vision);
        visionRepository.save(doc);
	}

	@Override
	public void remove(Vision vision) throws Exception {
		// TODO Auto-generated method stub
		VisionDocument doc = this.convertVisionToVisionDocument(vision);
		visionRepository.delete(doc);
	}

	@Override
	public void removeAll() throws Exception {
		// TODO Auto-generated method stub
		visionRepository.deleteAll();

	}
	
	private VisionDocument convertVisionToVisionDocument(Vision vision) {
		VisionDocument doc = new VisionDocument();
		doc.setId(vision.visionId().id());
		doc.setPersonId(vision.personId());
		doc.setVisionId(vision.visionId());
		doc.setVisionType(vision.visionType());
		doc.setContent(vision.content());
		return doc;
	}
	
}
