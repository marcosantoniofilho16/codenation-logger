package api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import api.model.Users;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Optional<Users> findByUsername(@Param("username") String username);

}
