package  com.sk.sample.mssp.subscriptions.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import  com.sk.sample.mssp.subscriptions.domain.model.Subscriptions;

public interface SubscriptionsService {
	Subscriptions findById(Long id);
	List<Subscriptions> findAll();
	Page<Subscriptions> findAll(Pageable pageable);
	
	Subscriptions findByPartyId(Long partyId);
	
	Subscriptions register(Subscriptions subscriptions);
	/*
	 * Subscriptions update(Long id, Subscriptions subscriptions);
	 * 
	 * void delete(Long id);
	 */
}
