package cqrs.app.service.command;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import cqrs.app.command.dto.CreateCommandDTO;
import cqrs.app.command.dto.CreditCommandDTO;
import cqrs.app.command.dto.DebitCommandDTO;
import cqrs.app.dto.CreateAccountDTO;
import cqrs.app.dto.CreditAccountDTO;
import cqrs.app.dto.DebitAccountDTO;

@Service
public class AccountCommandService {
	
	private CommandGateway commandGateway;

	public void createAccount(CreateAccountDTO createAccount) {
		// TODO Auto-generated method stub
		commandGateway.send(new CreateCommandDTO(UUID.randomUUID().toString(),createAccount.getStartingBalance(), createAccount.getName()));
	}

	public void debitMoneyFromAccount(DebitAccountDTO debitMoney) {
		// TODO Auto-generated method stub
		commandGateway.send(new DebitCommandDTO(UUID.randomUUID().toString(),debitMoney.getDebitAmount()));
	}

	public void creditMoneyFromAccount(CreditAccountDTO creditMoney) {
		// TODO Auto-generated method stub
		commandGateway.send(new CreditCommandDTO(UUID.randomUUID().toString(),creditMoney.getCreditAmount()));
	}

}
