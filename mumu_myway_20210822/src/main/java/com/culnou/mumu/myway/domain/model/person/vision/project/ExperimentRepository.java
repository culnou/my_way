package com.culnou.mumu.myway.domain.model.person.vision.project;



public interface ExperimentRepository {
	
	//識別子オブジェクトはリポジトリが生成する。
	public ExperimentId nextIdentity() throws Exception;
		
		
	//コマンド。
	public void save(Experiment experiment) throws Exception;
			
	//コマンド。
	public void remove(Experiment experiment) throws Exception;
			
	//コマンド。
	public void removeAll() throws Exception;

}
