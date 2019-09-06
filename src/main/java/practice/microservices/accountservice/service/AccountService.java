package practice.microservices.accountservice.service;

import org.springframework.stereotype.Service;

import practice.microservices.accountservice.dto.Customer;

public interface AccountService {
	public String generateAccount(Customer customer);

}
