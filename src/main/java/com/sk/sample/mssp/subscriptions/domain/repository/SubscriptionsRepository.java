package  com.sk.sample.mssp.subscriptions.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import  com.sk.sample.mssp.subscriptions.domain.model.Subscriptions;

@RepositoryRestResource
public interface SubscriptionsRepository extends PagingAndSortingRepository<Subscriptions, Long>,
                                           QueryDslPredicateExecutor<Subscriptions> {
	
	Subscriptions findByPartyId(@Param("partyId") Long partyId);
	List<Subscriptions> findAll();
	List<Subscriptions> findAll(Predicate predicate); 
	
}
