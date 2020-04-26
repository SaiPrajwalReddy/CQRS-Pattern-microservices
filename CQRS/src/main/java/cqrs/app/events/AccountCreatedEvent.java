package cqrs.app.events;

public class AccountCreatedEvent extends BaseEvent<String> {

	public final double accountBalance;
	public String accountName;

	public AccountCreatedEvent(String id, double accountBalance, String accountName) {
		super(id);
		this.accountBalance = accountBalance;
		this.accountName = accountName;
	}
}
