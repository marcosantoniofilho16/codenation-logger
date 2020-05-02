package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.model.Logger;

public interface LoggerRepository extends JpaRepository<Logger, Long> {

}
