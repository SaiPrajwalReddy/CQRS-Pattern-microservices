package cqrs.app.controller.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cqrs.app.service.query.AccountQueryService;

@RestController
public class AccountQueryController {

	@Autowired
	private AccountQueryService accountQueryService;
	
	@GetMapping(path = "/getAccountDetails/{id}")
	public void getAccount(@PathVariable("id") String accountId) {
		
		accountQueryService.getAccountdetails(accountId);
	}
	
	@GetMapping(path = "/getAccountTransactions/{id}")
	public void listAccountTransactions(@PathVariable("id") String accountId) {
		
		accountQueryService.findAllTransactions(accountId);
	}
}
