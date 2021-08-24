package com.culnou.mumu.myway.query.model.person.vision;

import java.util.List;

import com.culnou.mumu.myway.domain.model.person.PersonId;
import com.culnou.mumu.myway.domain.model.person.vision.Vision;
import com.culnou.mumu.myway.domain.model.person.vision.VisionId;

public interface VisionQuery {
	
	//findByIdはクエリだがリポジトリで定義する。
	//集約間、ドメインモデルとアプリケーションサービスの間、モジュール間の受け渡しには、識別子はStringのidではなく、不変性が保証された識別子オブジェクトを使う。
	public Vision findById(VisionId visionId) throws Exception;
	
	public List<Vision> findVisionsOfPerson(PersonId personId) throws Exception;
	
	public List<Vision> findVisionsCauseBy(VisionId cause) throws Exception;
	
	public boolean hasVisionsCauseBy(VisionId cause) throws Exception;
	
	public List<Vision> findVisionsByVisionType(String type) throws Exception;

}
