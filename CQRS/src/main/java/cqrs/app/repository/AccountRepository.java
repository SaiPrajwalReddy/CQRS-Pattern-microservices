package cqrs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cqrs.app.query.entity.AccountQueryDTO;

@Repository	
public interface AccountRepository extends JpaRepository<AccountQueryDTO,String> {

}
