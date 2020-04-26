package cqrs.app.command.dto;

public class CreditCommandDTO extends BaseCommand<String> {

	String accountId;
	Double creditAmount;

	public CreditCommandDTO(String accountId, Double creditAmount) {
		super(accountId);
		this.accountId = accountId;
		this.creditAmount = creditAmount;
	}

	public String getAccountId() {
		return accountId;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}
}
