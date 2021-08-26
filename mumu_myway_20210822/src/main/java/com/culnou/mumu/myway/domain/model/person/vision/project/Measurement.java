package com.culnou.mumu.myway.domain.model.person.vision.project;

import java.io.Serializable;


public class Measurement implements Serializable, Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String indicator;
	private String criteria;
	
	
	public Measurement(String indicator, String criteria) {
		this.setIndicator(indicator);
		this.setCriteria(criteria);
	}
	
	protected void setIndicator(String indicator) {
		if(indicator == null) {
			throw new IllegalArgumentException("The indicator may not be set to null.");
		}
		this.indicator = indicator;
	}
	
	public String indicator() {
		return this.indicator;
	}
	
	protected void setCriteria(String criteria) {
		if(criteria == null) {
			throw new IllegalArgumentException("The criteria may not be set to null.");
		}
		this.criteria = criteria;
	}
	
	public String criteria() {
		return this.criteria;
	}
	
	@Override
	public Measurement clone() {
		try {
			super.clone();
		}catch(CloneNotSupportedException e) {
			throw new InternalError();
		}
		return new Measurement(this.indicator(), this.criteria());
	}
	@Override
	public boolean equals(Object object) {
		boolean equality = false;
		if(object != null && this.getClass() == object.getClass()) {
			Measurement mesurement = (Measurement)object;
			//必ず参照の比較（＝＝）ではなく内容の比較（equals）を行う。
			if(mesurement.indicator().equals(this.indicator()) && mesurement.criteria().equals(this.criteria())){
				equality = true;
			}
		}
		return equality;
	}

}
