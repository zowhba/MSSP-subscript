package com.sk.sample.mssp.party.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.sample.mssp.party.domain.model.Party;

public interface PartyService {
	Party findById(Long id);
	List<Party> findAll();
	Page<Party> findAll(Pageable pageable);
	
	List<Party> findByNameLike(String name);
	Party findByEmail(String email);
	
	Party register(Party account);
	Party update(Long id, Party account);

	void delete(Long id);
}
