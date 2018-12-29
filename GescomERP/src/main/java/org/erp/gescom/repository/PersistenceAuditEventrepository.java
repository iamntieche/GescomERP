package org.erp.gescom.repository;

import java.time.Instant;
import java.util.List;

import org.erp.gescom.domain.PersistentAuditEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the PersistentAuditEvent entity.
 */
public interface PersistenceAuditEventrepository extends MongoRepository<PersistentAuditEvent, String>{

	List<PersistentAuditEvent> findByPrincipal(String principal);
	
	List<PersistentAuditEvent> findByAuditEventDateAfter(Instant after);
	
	List<PersistentAuditEvent> findByPrincipalAndAuditEventDateAfter(String principal,Instant after);
	
	List<PersistentAuditEvent> findByPrincipalAndAuditEventDateAfterAndAuditEventType(String principal, Instant after, String type);
	
	Page<PersistentAuditEvent> findAllByAuditEventDateBetween(Instant formDate,Instant toDate,Pageable  pageable);
}
 