package cqrs.app.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import cqrs.app.command.dto.CreateCommandDTO;
import cqrs.app.command.dto.CreditCommandDTO;
import cqrs.app.command.dto.DebitCommandDTO;
import cqrs.app.events.AccountActivatedEvent;
import cqrs.app.events.AccountCreatedEvent;
import cqrs.app.events.AccountHeldEvent;
import cqrs.app.events.MoneyCreditedEvent;
import cqrs.app.events.MoneyDebitedEvent;

@Aggregate
public class Aggregator {

	@AggregateIdentifier
	private String id;
	private Double accountBalance;
	private Status status;
	private String accountName;

	public Aggregator() {

	}

	@CommandHandler
	public Aggregator(CreateCommandDTO createAccount) {
		AggregateLifecycle.apply(new AccountCreatedEvent(createAccount.getAccountId(),
				createAccount.getStartingBalance(), createAccount.getAccountName()));
	}

	@EventSourcingHandler
	protected void on(AccountCreatedEvent accountCreatedEvent) {
		this.id = accountCreatedEvent.id;
		this.accountBalance = accountCreatedEvent.accountBalance;
		this.accountName = accountCreatedEvent.accountName;
		this.status = Status.ACTIVATED;

		AggregateLifecycle.apply(new AccountActivatedEvent(this.id, Status.ACTIVATED));
	}

	@CommandHandler
	public Aggregator(CreditCommandDTO createAccount) {
		AggregateLifecycle.apply(new MoneyCreditedEvent(createAccount.getAccountId(), createAccount.getCreditAmount()));
	}

	@EventSourcingHandler
	protected void on(MoneyCreditedEvent moneyCreditedEvent) {
		if (accountBalance < 0 && accountBalance + moneyCreditedEvent.creditAmount >= 0) {
			AggregateLifecycle.apply(new AccountActivatedEvent(this.id, Status.ACTIVATED));
		}
		this.accountBalance = accountBalance + moneyCreditedEvent.creditAmount;

	}

	@EventSourcingHandler
	protected void on(AccountActivatedEvent accountActivatedEvent) {
		this.status = accountActivatedEvent.getStatus();
	}

	@CommandHandler
	public Aggregator(DebitCommandDTO createAccount) {
		AggregateLifecycle.apply(new MoneyDebitedEvent(createAccount.getAccountId(), createAccount.getDebitAmount()));
	}

	@EventSourcingHandler
	protected void on(MoneyDebitedEvent moneyDebitedEvent) {
		if (accountBalance - moneyDebitedEvent.debitAmount < 0) {
			AggregateLifecycle.apply(new AccountHeldEvent(this.id, Status.HELD));
		}
		this.accountBalance = accountBalance - moneyDebitedEvent.debitAmount;

	}

	@EventSourcingHandler
	protected void on(AccountHeldEvent accountHeldEvent) {
		this.status = accountHeldEvent.getStatus();
	}

	public String getAccountId() {
		return id;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public Status getStatus() {
		return status;
	}

	public String getAccountName() {
		return accountName;
	}

}
