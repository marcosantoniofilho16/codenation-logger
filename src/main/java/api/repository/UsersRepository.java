package api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import api.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Optional<Users> findByUsername(@Param("username") String username);

}
