package  com.sk.sample.mssp.subscriptions.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import  com.sk.sample.mssp.subscriptions.domain.model.Subscriptions;
import  com.sk.sample.mssp.subscriptions.domain.repository.SubscriptionsRepository;

@Service("subscriptionsLogic")
public class SubscriptionsLogic implements SubscriptionsService {
	@Autowired
	private SubscriptionsRepository subscriptionsRepository;

	@Override
	@Transactional(readOnly=true)
	public Subscriptions findById(Long id) {
		return subscriptionsRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Subscriptions findByPartyId(Long partyId) {
		return subscriptionsRepository.findByPartyId(partyId);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Subscriptions> findAll() {
		return subscriptionsRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Subscriptions> findAll(Pageable pageable) {
		return subscriptionsRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Subscriptions register(Subscriptions subscriptions) {
		return subscriptionsRepository.save(subscriptions);
	}

	/*
	 * @Override
	 * 
	 * @Transactional public Subscriptions update(Long id, Subscriptions
	 * newSubscriptions) { Subscriptions oldSubscriptions =
	 * subscriptionsRepository.findOne(id); if(oldSubscriptions != null) {
	 * BeanUtils.copyProperties(newSubscriptions, oldSubscriptions, "id"); return
	 * subscriptionsRepository.save(oldSubscriptions); } else { return null; } }
	 * 
	 * @Override
	 * 
	 * @Transactional public void delete(Long id) {
	 * subscriptionsRepository.delete(id); }
	 */
}
