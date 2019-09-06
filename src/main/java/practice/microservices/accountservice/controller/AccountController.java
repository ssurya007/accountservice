package practice.microservices.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import practice.microservices.accountservice.dto.Customer;
import practice.microservices.accountservice.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/getAccountNumber")
	public String getAccountNumber(@RequestBody Customer customer) {
		return accountService.generateAccount(customer);
	}

}
