package com.paula.account.business;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paula.account.business.exception.BusinessException;
import com.paula.account.entity.AccountEntity;
import com.paula.account.repository.AccountRepository;
import com.paula.account.schema.Account;

@Component
public class AccountBusiness {

	@Autowired
	AccountRepository accountRepository;
	
	public Account accountById(Long accountId) {
		Optional<AccountEntity> accountEntity = accountRepository.findById(accountId);
		Account account = new Account();
		
		if(Objects.isNull(accountEntity.get())) {
			throw new BusinessException("Conta não existe!");
		}
		
		BeanUtils.copyProperties(accountEntity.get(), account);
		
		return account;
	}

	public Account insert(Account account) {
		AccountEntity accountEntity = new AccountEntity();
		BeanUtils.copyProperties(account, accountEntity);
		
//		AccountEntity accountEmail = accountRepository.findByEmail(account.getEmail());
//		
//		if (Objects.nonNull(accountEmail)) {
//			throw new BusinessException("Este e-mail já esta vinculado a outra conta !");
//		}
//		
		AccountEntity newAccount = accountRepository.save(accountEntity);
		
		BeanUtils.copyProperties(newAccount, account);
		
		return account;
	}

	public Account update(Account account, Long accountId ) {
		Optional<AccountEntity> accountEntity = accountRepository.findById(accountId);
		
		if(Objects.isNull(accountEntity.get())) {
			throw new BusinessException("Conta não existe!");
		}
		
		account.setId(accountEntity.get().getId());
		
		BeanUtils.copyProperties(account, accountEntity.get());
		
		AccountEntity accountSave = accountRepository.save(accountEntity.get());
		
		BeanUtils.copyProperties(accountSave, account);
		
		return account;
	}

	public void delete(Long accountId) {
		Optional<AccountEntity> accountEntity = accountRepository.findById(accountId);
		
		if(Objects.isNull(accountEntity)) {
			throw new BusinessException("Conta não existe!");
		}
		
		AccountEntity accountDelete= new AccountEntity();
		BeanUtils.copyProperties(accountEntity, accountDelete);
		
		accountRepository.delete(accountDelete);
	}
	
}
