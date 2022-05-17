package routeplannerpoc.windesheimdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import routeplannerpoc.windesheimdemo.model.Address;

@Repository
public interface AdressRepository extends CrudRepository<Address, Long> {

}