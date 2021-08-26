package com.culnou.mumu.myway.domain.model.person.vision.project;

import java.io.Serializable;



public class ExperimentId implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	public ExperimentId(String id) {
	    setId(id);	
	}
	
	protected void setId(String id) {
		//セッターで一貫性制約を保持する。
		if(id == null) {
			throw new IllegalArgumentException("The id may not be set to null.");
		}
		this.id = id;
	}
	
	public String id() {
		return this.id;
	}
	
	@Override
	public ExperimentId clone() {
		try {
			super.clone();
		}catch(CloneNotSupportedException e) {
			throw new InternalError();
		}
		return new ExperimentId(this.id());
	}
	
	@Override
	public boolean equals(Object object) {
		boolean equality = false;
		if(object != null && this.getClass() == object.getClass()) {
			ExperimentId experimentId = (ExperimentId)object;
			//必ず参照の比較（＝＝）ではなく内容の比較（equals）を行う。
			if(experimentId.id().equals(this.id())){
				equality = true;
			}
		}
		return equality;
	}	

}
