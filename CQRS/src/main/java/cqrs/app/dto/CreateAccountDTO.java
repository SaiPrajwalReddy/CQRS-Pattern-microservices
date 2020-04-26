package cqrs.app.dto;

public class CreateAccountDTO {

	private String name;
	private Double startingBalance;

	public String getName() {
		return name;
	}

	public Double getStartingBalance() {
		return startingBalance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStartingBalance(Double startingBalance) {
		this.startingBalance = startingBalance;
	}
}
