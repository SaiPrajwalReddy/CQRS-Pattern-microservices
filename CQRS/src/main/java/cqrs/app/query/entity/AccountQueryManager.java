package cqrs.app.query.entity;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cqrs.app.aggregate.Aggregator;
import cqrs.app.events.BaseEvent;
import cqrs.app.repository.AccountRepository;

@Component
public class AccountQueryManager {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	@Qualifier("accountAggregateEventSourcingRepository")
	private EventSourcingRepository<Aggregator> aggregatorRepository;

	@EventSourcingHandler
	public void on(BaseEvent event) {
		saveToQueryRepo(event);
	}

	private void saveToQueryRepo(BaseEvent event) {
		// TODO Auto-generated method stub
		Aggregator aggregator = getAccountDetaisFromEvent(event);
		AccountQueryDTO accountQueryObj = buildAccountQueryEntity(aggregator);
		accountRepository.save(accountQueryObj);
	}

	private AccountQueryDTO buildAccountQueryEntity(Aggregator aggregator) {
		// TODO Auto-generated method stub
		AccountQueryDTO accountQueryObj = new AccountQueryDTO();
		accountQueryObj.setAccountId(aggregator.getAccountId());
		accountQueryObj.setAccountName(aggregator.getAccountName());
		accountQueryObj.setAccountBalance(aggregator.getAccountBalance());
		accountQueryObj.setAccountState(aggregator.getStatus().toString());
		
		return accountQueryObj;
	}

	private Aggregator getAccountDetaisFromEvent(BaseEvent event) {
		// TODO Auto-generated method stub
		return aggregatorRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();

	}
}
