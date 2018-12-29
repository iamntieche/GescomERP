package org.erp.gescom.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.erp.gescom.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	Optional<User> findOneByActivationKey(String activationKey);
	
	List<User> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);
	
	Optional<User> findOneByResetKey(String resetKey);
	
	Optional<User> findOneByEmailIgnoreCase(String email);
	
	Optional<User> findOneByLogin(String login);
	
	Page<User> findAllbyLoginNot(Pageable pageable, String login);

}
