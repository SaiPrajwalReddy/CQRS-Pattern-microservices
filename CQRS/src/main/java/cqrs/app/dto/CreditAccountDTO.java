package cqrs.app.dto;

public class CreditAccountDTO {
	
	private Double creditAmount;

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}
}
