package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepo customerRepo;
	
	public CustomerServiceImpl(CustomerRepo customerRepo) {
		this.customerRepo=customerRepo;
	}
	
	@Override
	public List<Customer> getCustomers() {
		return (List<Customer>) customerRepo.findAll();
	}

	@Override
	public boolean save(Customer c) {
		return customerRepo.save(c) != null;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		return customerRepo.save(c) != null;
	}

	@Override
	public String deleteCustomer(Integer id) {
		Optional<Customer> findById = customerRepo.findById(id);
		if(findById.isPresent()) {
			Customer customer = findById.get();
			customerRepo.delete(customer);
		}
		return "Customer Deleted SucessFully";
	}

}







