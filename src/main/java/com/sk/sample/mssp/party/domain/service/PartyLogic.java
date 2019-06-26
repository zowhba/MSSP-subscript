package com.sk.sample.mssp.party.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.mssp.party.domain.model.Party;
import com.sk.sample.mssp.party.domain.repository.PartyRepository;

@Service("accountLogic")
public class PartyLogic implements PartyService {
	@Autowired
	private PartyRepository accountRepository;

	@Override
	@Transactional(readOnly=true)
	public Party findById(Long id) {
		return accountRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Party> findByNameLike(String name) {
		return accountRepository.findByNameLike(name);
	}

	@Override
	@Transactional(readOnly=true)
	public Party findByEmail(String email) {
		return accountRepository.findByEmail(email);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Party> findAll() {
		return accountRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Party> findAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Party register(Party account) {
		return accountRepository.save(account);
	}

	@Override
	@Transactional
	public Party update(Long id, Party newAccount) {
		Party oldAccount = accountRepository.findOne(id);
		if(oldAccount != null) {
			BeanUtils.copyProperties(newAccount,  oldAccount, "id");
			return accountRepository.save(oldAccount);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		accountRepository.delete(id);
	}
}
