package cqrs.app.controller.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cqrs.app.dto.CreateAccountDTO;
import cqrs.app.dto.CreditAccountDTO;
import cqrs.app.dto.DebitAccountDTO;
import cqrs.app.service.command.AccountCommandService;

@RestController
public class AccountCommandController {

	@Autowired
	private AccountCommandService accountCommandService;
	
	@PostMapping(path = "/createAccount")
	public void createAccount(@RequestBody CreateAccountDTO createAccount) {
		
		accountCommandService.createAccount(createAccount);
	}
	
	@PostMapping(path = "/debitMoney/{id}")
	public void debitMoneyFromAccount(@PathVariable("id") String accountId, @RequestBody DebitAccountDTO debitMoney) {
		accountCommandService.debitMoneyFromAccount(debitMoney);
	}
	
	@PostMapping(path = "/creditMoney/{id}")
	public void creditMoneyFromAccount(@PathVariable("id") String accountId ,@RequestBody CreditAccountDTO creditMoney) {
		accountCommandService.creditMoneyFromAccount(creditMoney);
	}
	
}
