package  com.sk.sample.mssp.subscriptions.domain.model;

import javax.persistence.Entity;

import com.sk.sample.mssp.shared.base.AbstractEntity;
import com.sk.sample.mssp.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Subscriptions extends AbstractEntity implements AggregateRoot {
	private Long partyId;
	private String ottId;
	private String subscriptionsName;
	
	public Subscriptions(String subscriptionsName, Long partyId, String ottId) {
		this.partyId = partyId;
		this.ottId = ottId;
		this.subscriptionsName = subscriptionsName;

	}
}

