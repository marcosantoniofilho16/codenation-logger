package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
