package practice.microservices.accountservice.service.impl;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import practice.microservices.accountservice.dao.AccountDao;
import practice.microservices.accountservice.dto.Customer;
import practice.microservices.accountservice.entity.AccountEntity;
import practice.microservices.accountservice.helper.AccountNumberGenerator;
import practice.microservices.accountservice.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;
	
	@Autowired
	MessageSource messageSource;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Override
	public String generateAccount(Customer customer) {
		String accountNumber = null;
		try {
			accountNumber = Integer.toString(AccountNumberGenerator.generateAccountNumber());
		} catch (Exception e) {
			logger.error(messageSource.getMessage("error.acoount.generation", null, Locale.ENGLISH));
		}
		AccountEntity accountEntity = createAccount(accountNumber, customer);
		accountDao.save(accountEntity);
		return accountNumber;
		
	}

	private AccountEntity createAccount(String accountNumber, Customer customer) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setAccountNumber(accountNumber);
		accountEntity.setAccountBalance(Double.valueOf(10000));
		accountEntity.setCustomerId(customer.getCustomerId());
		return accountEntity;
	}

}
