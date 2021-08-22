package com.culnou.mumu.myway.domain.model.person;

public interface PersonRepository {
	
	//識別子オブジェクトはリポジトリが生成する。
	public PersonId nextIdentity() throws Exception;
	
	//findByIdはクエリだがリポジトリで定義する。
	//集約間、ドメインモデルとアプリケーションサービスの間、モジュール間の受け渡しには、識別子はStringのidではなく、不変性が保証された識別子オブジェクトを使う。
	public Person findById(PersonId personId) throws Exception;
	
	//コマンド。
	public void save(Person person) throws Exception;
	
	//コマンド。
	public void remove(Person person) throws Exception;
	
	//コマンド。
	public void removeAll() throws Exception;

}
