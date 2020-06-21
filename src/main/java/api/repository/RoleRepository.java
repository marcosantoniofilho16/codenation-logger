package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import api.model.Role;

@RepositoryRestResource(path = "roles", collectionResourceRel = "roles")
public interface RoleRepository extends JpaRepository<Role, Long> {

}
