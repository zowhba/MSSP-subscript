package com.sk.sample.mssp.party.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.mssp.party.domain.model.Party;
import com.sk.sample.mssp.party.domain.service.PartyService;

@RestController
@RequestMapping("/v1/parties")
public class PartyRestController implements PartyService {
	@Autowired
	private PartyService accountService;

	@Override
	@GetMapping
	public List<Party> findAll() {
		return accountService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Party findById(@PathVariable("id") Long id) {
		return accountService.findById(id);
	}

	@Override
	@PostMapping
	public Party register(@RequestBody Party account) {
		return accountService.register(account);
	}

	@Override
	@PutMapping("/{id}")
	public Party update(@PathVariable("id") Long id, @RequestBody Party account) {
		return accountService.update(id, account);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		accountService.delete(id);
	}
	
	@Override
	@GetMapping("/search/name")
	public List<Party> findByNameLike(@RequestParam("name") String name) {
		return accountService.findByNameLike(name);
	}

	@Override
	@GetMapping("/search/email")
	public Party findByEmail(@RequestParam("email") String email) {
		return accountService.findByEmail(email);
	}

	@Override
	//@GetMapping
	public Page<Party> findAll(Pageable pageable) {
		return accountService.findAll(pageable); 
	}


}
