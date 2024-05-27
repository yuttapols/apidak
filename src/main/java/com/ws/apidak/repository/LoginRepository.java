package com.ws.apidak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ws.apidak.entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long>{

	@Query("select t from LoginEntity t where t.userName = ?1 and t.password = ?2 ")
	LoginEntity findByUserNameAndPassword(String userName, String password);
	
	@Query("select t from LoginEntity t where t.userName = ?1")
	LoginEntity findByUserName(String userName);
}
