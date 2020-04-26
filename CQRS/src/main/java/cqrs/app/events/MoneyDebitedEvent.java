package cqrs.app.events;

public class MoneyDebitedEvent extends BaseEvent<String>{

	public final double debitAmount;

	public MoneyDebitedEvent(String id, double debitAmount) {
		super(id);
		this.debitAmount = debitAmount;
	}
}
