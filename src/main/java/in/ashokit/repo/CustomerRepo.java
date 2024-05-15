package in.ashokit.repo;

import org.springframework.data.repository.CrudRepository;

import in.ashokit.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer,Integer>{

}
