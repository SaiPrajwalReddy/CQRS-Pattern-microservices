package cqrs.app.query.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountQueryDTO {

	@Id
	String accountId;
	Double accountBalance;
	String accountName;
	String accountState;

	public AccountQueryDTO() {

	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountState() {
		return accountState;
	}

	public void setAccountState(String accountState) {
		this.accountState = accountState;
	}
}
