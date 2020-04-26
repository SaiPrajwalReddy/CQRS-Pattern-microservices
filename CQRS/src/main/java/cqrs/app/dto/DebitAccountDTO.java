package cqrs.app.dto;

public class DebitAccountDTO {

	private Double debitAmount;

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}
}
