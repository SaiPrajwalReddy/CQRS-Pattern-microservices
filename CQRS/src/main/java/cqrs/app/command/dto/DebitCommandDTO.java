package cqrs.app.command.dto;

public class DebitCommandDTO extends BaseCommand<String> {

	String accountId;
	Double debitAmount;

	public DebitCommandDTO(String accountId, Double debitAmount) {
		super(accountId);
		this.accountId = accountId;
		this.debitAmount = debitAmount;
	}

	public String getAccountId() {
		return accountId;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}
}
