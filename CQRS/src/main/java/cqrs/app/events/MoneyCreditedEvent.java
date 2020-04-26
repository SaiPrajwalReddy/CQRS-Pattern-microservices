package cqrs.app.events;

public class MoneyCreditedEvent extends BaseEvent<String> {

	public final double creditAmount;

	public MoneyCreditedEvent(String id, double creditAmount) {
		super(id);
		this.creditAmount = creditAmount;
	}
}
