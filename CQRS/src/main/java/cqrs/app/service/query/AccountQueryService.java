package cqrs.app.service.query;

import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cqrs.app.repository.AccountRepository;
@Service
public class AccountQueryService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private EventStore eventStore;

	public void getAccountdetails(String accountId) {
		// TODO Auto-generated method stub
		accountRepository.getOne(accountId);
	}

	public void findAllTransactions(String accountId) {
		// TODO Auto-generated method stub
		eventStore.readEvents(accountId).asStream().map(s -> s.getPayload()).collect(Collectors.toList());
	}

}
