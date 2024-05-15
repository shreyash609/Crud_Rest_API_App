package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public boolean save(Customer c);
	
	public boolean updateCustomer(Customer c);
		
	public String deleteCustomer(Integer id);
}
