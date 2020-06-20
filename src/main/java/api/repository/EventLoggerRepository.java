package api.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import api.model.EventLogger;
import api.model.enums.Level;
import api.model.projection.EventLoggerDefaultProjection;

@RepositoryRestResource(path = "eventLoggers", collectionResourceRel = "eventLoggers", excerptProjection = EventLoggerDefaultProjection.class)
public interface EventLoggerRepository extends JpaRepository<EventLogger, Long> {

	@Query("from EventLogger e"
			+ " where ((:level is null or e.level = :level)"
			+ " and (:eventDescription is null or lower(text(e.eventDescription)) like concat('%', lower(text(:eventDescription)), '%'))"
			+ " and (:eventLogger is null or lower(text(e.eventLogger)) like concat('%', lower(text(:eventLogger)), '%'))"
			+ " and (:source is null or lower(text(e.source)) like concat('%', lower(text(:source)), '%'))"
			+ " and (cast(:date as LocalDate) is null or cast(e.date as LocalDate) = :date)"
			+ " and (:quantity is null or e.quantity = :quantity))")
	Page<EventLogger> findBy(@Param("level") Level level, 
							 @Param("eventDescription") String eventDescription,
							 @Param("eventLogger") String eventLogger,
							 @Param("source") String source,
							 @Param("date") @DateTimeFormat(iso = ISO.DATE) LocalDate date,
							 @Param("quantity") Integer quantity, 
							 Pageable pageable);

}
