package in.ashokit.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Customer;
import in.ashokit.service.CustomerService;

@RestController
public class CustomerRestController {

	private CustomerService customerService;

	public CustomerRestController( CustomerService customerService) {
		this.customerService=customerService;
	}		

	//	for deleting the customer
	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") Integer id) {
		return customerService.deleteCustomer(id);
	}

	//  for updating the data
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer c){
		boolean status = customerService.updateCustomer(c);
		if(status) {
			return new ResponseEntity<String>("updated",HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("not updated",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	//	for retrieving the data from db
	@GetMapping("/get")
	public List<Customer> getCustomers() {
		List<Customer> customers = customerService.getCustomers();
		return customers;
	}


	//	inserting the data into database
	@PostMapping(value="/save",consumes="application/json",produces="text/plain")
	public ResponseEntity<String> save(@RequestBody Customer c){
		boolean save = customerService.save(c);

		if(save) {
			return new ResponseEntity<String>("record created",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("record not created",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
