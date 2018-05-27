package com.paula.account.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paula.account.entity.AccountEntity;


@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long>{

	@Query("SELECT AccountEntity FROM AccountEntity a WHERE a.email=:email")
	AccountEntity findByEmail(@Param("email") String email);
}
