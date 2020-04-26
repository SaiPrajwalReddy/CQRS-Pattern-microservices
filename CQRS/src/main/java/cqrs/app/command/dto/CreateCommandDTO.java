package cqrs.app.command.dto;

public class CreateCommandDTO extends BaseCommand<String> {

	private String accountId;
	private Double startingBalance;
	private String accountName;

	public CreateCommandDTO(String accountId, Double startingBalance, String accountName) {
		super(accountId);
		this.accountId = accountId;
		this.startingBalance = startingBalance;
		this.accountName = accountName;
	}

	public String getAccountId() {
		return accountId;
	}

	public Double getStartingBalance() {
		return startingBalance;
	}

	public String getAccountName() {
		// TODO Auto-generated method stub
		return accountName;
	}
}
