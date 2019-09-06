package practice.microservices.accountservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practice.microservices.accountservice.entity.AccountEntity;

@Repository
public interface AccountDao extends JpaRepository<AccountEntity, Long> {

}
