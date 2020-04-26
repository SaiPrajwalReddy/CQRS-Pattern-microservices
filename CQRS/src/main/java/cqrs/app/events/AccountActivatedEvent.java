package cqrs.app.events;

import org.springframework.beans.factory.annotation.Autowired;
import cqrs.app.aggregate.Status;

public class AccountActivatedEvent extends BaseEvent<String> {

	@Autowired
	private Status status;

	public AccountActivatedEvent(String id, Status status) {
		super(id);
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}
}
