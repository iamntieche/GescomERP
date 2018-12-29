package org.erp.gescom.service;

import java.time.Instant;
import java.util.Optional;

import org.erp.gescom.config.audit.AuditEventConverter;
import org.erp.gescom.repository.PersistenceAuditEventrepository;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service for managing audit events.
 * <p>
 * This is the default implementation to support SpringBoot Actuator AuditEventRepository
 */
@Service
public class AuditEventService {
	
	private final PersistenceAuditEventrepository persistenceAuditEventrepository;
	private final AuditEventConverter auditEventConverter;
	
	public AuditEventService(PersistenceAuditEventrepository persistenceAuditEventrepository,
							 AuditEventConverter auditEventConverter){
		this.persistenceAuditEventrepository = persistenceAuditEventrepository;
		this.auditEventConverter = auditEventConverter;
	}
	
	public Page<AuditEvent> findAll(Pageable pageable){
		return persistenceAuditEventrepository.findAll(pageable)
				.map(auditEventConverter :: convertToAuditEvent);
	}
	
	public Page<AuditEvent> findByDates(Instant formDate,Instant toDate, Pageable pageable){
		return persistenceAuditEventrepository.findAllByAuditEventDateBetween(formDate, toDate, pageable)
				.map(auditEventConverter :: convertToAuditEvent);
	}
	
	public Optional<AuditEvent> find(String id){
		return Optional.ofNullable(persistenceAuditEventrepository.findById(id))
			   .filter(Optional::isPresent)
			   .map(Optional::get)
			   .map(auditEventConverter::convertToAuditEvent);
	}

}
