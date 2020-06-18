package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.model.EventLogger;

public interface EventLoggerRepository extends JpaRepository<EventLogger, Long> {

}
