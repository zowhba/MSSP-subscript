package com.sk.sample.mssp.subscriptions.application.sp.web;

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

import com.sk.sample.mssp.subscriptions.domain.model.Subscriptions;
import com.sk.sample.mssp.subscriptions.domain.service.SubscriptionsService;

@RestController
@RequestMapping("/v1/subscriptions")
public class SubscriptionsRestController implements SubscriptionsService {
	@Autowired
	private SubscriptionsService subscriptionsService;

	@Override
	@GetMapping
	public List<Subscriptions> findAll() {
		return subscriptionsService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Subscriptions findById(@PathVariable("id") Long id) {
		return subscriptionsService.findById(id);
	}

	@Override
	@PostMapping
	public Subscriptions register(@RequestBody Subscriptions subscriptions) {
		return subscriptionsService.register(subscriptions);
	}

	@Override
	@PutMapping("/{id}")
	public Subscriptions update(@PathVariable("id") Long id, @RequestBody Subscriptions subscriptions) {
		return subscriptionsService.update(id, subscriptions);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		subscriptionsService.delete(id);
	}
	
	@Override
	@GetMapping("/search/partyId")
	public Subscriptions findByPartyId(@RequestParam("partyId") Long partyId) {
		return subscriptionsService.findByPartyId(partyId);
	}

	@Override
	//@GetMapping
	public Page<Subscriptions> findAll(Pageable pageable) {
		return subscriptionsService.findAll(pageable); 
	}


}
