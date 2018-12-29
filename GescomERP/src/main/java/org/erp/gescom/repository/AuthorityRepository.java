package org.erp.gescom.repository;

import org.erp.gescom.domain.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorityRepository extends MongoRepository<Authority, String> {

}
