package iuh.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import iuh.exercise.entities.Address;

@RepositoryRestResource(collectionResourceRel = "address", path = "address", exported = false)
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
