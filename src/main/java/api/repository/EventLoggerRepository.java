package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import api.model.EventLogger;
import api.model.projection.EventLoggerDefaultProjection;

@RepositoryRestResource(path = "eventLoggers", collectionResourceRel = "eventLoggers", excerptProjection = EventLoggerDefaultProjection.class)
public interface EventLoggerRepository extends JpaRepository<EventLogger, Long> {

}
