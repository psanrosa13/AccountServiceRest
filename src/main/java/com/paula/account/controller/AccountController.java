package com.paula.account.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paula.account.business.AccountBusiness;
import com.paula.account.schema.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@RestController
@RequestMapping(path = "accounts/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

	@Autowired
	AccountBusiness accountBusiness;
	
	@RequestMapping(method = GET, path = "{accountId}")
	public Account account(@PathVariable("accountId") Long accountId) {
		return accountBusiness.accountById(accountId);
	}
	
	
	@RequestMapping(method = POST)
	public Account insertAccount(@Valid @RequestBody Account account) {
		return accountBusiness.insert(account);
	}
	
	
	@RequestMapping(method = PUT, path = "{accountId}")
	public Account updateAccount(@PathVariable("accountId") Long accountId
			,@RequestBody Account account) {
		return accountBusiness.update(account, accountId);
	}
	
	@RequestMapping(method = DELETE, path = "{accountId}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accountId") Long accountId) {
		accountBusiness.delete(accountId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
