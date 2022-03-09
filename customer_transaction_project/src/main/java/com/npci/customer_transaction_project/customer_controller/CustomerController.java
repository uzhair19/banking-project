package com.npci.customer_transaction_project.customer_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.customer_transaction_project.customer_entity.Customers;
import com.npci.customer_transaction_project.customer_service.CustomerService;
import com.npci.customer_transaction_project.customer_service.TransactionService;
import com.npci.customer_transaction_project.transaction_entity.Transaction;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/allcustomers")
	public ResponseEntity<List<Customers>> getAllCustomers() {
		List<Customers> customers = null;

		try {
			customers = customerService.getAllCustomers();
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}

	@GetMapping("/getcustomerbyId/{id}")
	@Cacheable(value="customers", key="#customer_Id")
	public Customers getCustomerById(@PathVariable("id") int customer_Id) {

		Customers customers = null;

		customers = customerService.getCustomersById(customer_Id);

		return customers;
	}

	@PostMapping("/addorupdateCustomers")
	public ResponseEntity<Customers> addOrUpdate(@RequestBody Customers customer) {
		Customers customers = null;

		try {
			customers = customerService.addOrUpdate(customer);
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	

	// delete the customer by Id
	@DeleteMapping("/deletecustomerbyId/{id}")
	@CacheEvict(value="customers", key="#customer_Id")
	public ResponseEntity<Customers> deleteCustomers(@PathVariable("id") int customer_Id) {
		Customers customers = null;

		try {
			customers = customerService.deleteCustomers(customer_Id);
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@GetMapping("/getcustomerbyage/{age}")
	public ResponseEntity<List<Customers>> getAllCustomerByAge(@PathVariable("age") int age) {
		List<Customers> customers = null;

		try {
			customers = customerService.getCustomerByAge(age);
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}

	@GetMapping("/getcustomerbyfirst_name/{first_name}")
	public ResponseEntity<List<Customers>> getAllCustomerByFirstName(@PathVariable("first_name") String first_name) {
		List<Customers> customers = null;

		try {
			customers = customerService.getCustomerByFirstName(first_name);
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}

	@GetMapping("/getcustomerbylast_name/{last_name}")
	public ResponseEntity<List<Customers>> getAllCustomerByLastName(@PathVariable("last_name") String last_name) {
		List<Customers> customers = null;

		try {
			customers = customerService.getCustomerByLastName(last_name);
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}

	@GetMapping("/gettransactiondetailsbyId/{id}")
	@Cacheable(value="transactions", key="#transaction_Id")
	public Transaction getTransactionsDetailsById(@PathVariable("id") int transaction_Id) {

		Transaction transactions = null;

		transactions = transactionService.getTransactionsDetailsById(transaction_Id);

		return transactions;
	}

	@GetMapping("/getalltransactiondetails")
	public ResponseEntity<List<Transaction>> getAllTransactionDetails() {
		List<Transaction> transactions = null;

		try {
			transactions = transactionService.getAllTransactionDetails();
		} catch (Exception e) {
			e.getMessage();
		}
	
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}

	@PostMapping("/addtransactions")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transactions) {
		Transaction transaction = null;

		try {
			transaction = transactionService.addTransaction(transactions);
		} catch (Exception e) {
			e.getStackTrace();
		}

		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

}
