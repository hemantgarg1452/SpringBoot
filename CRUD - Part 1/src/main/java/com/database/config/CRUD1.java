package com.database.config;

import com.database.config.entity.Customer;
import com.database.config.repo.CustomerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CRUD1 {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CRUD1.class, args);

		CustomerRepo repo = context.getBean(CustomerRepo.class);

		//first customer
		Customer customer1 = new Customer();
		customer1.setId(124);
		customer1.setName("Alex Standyol");
		customer1.setIdType("Driving License");
		customer1.setCity("New York");
		customer1.setAmount(5480L);
		customer1.setPaymentType("Credit Card");

		//Second Customer
		Customer customer2 = new Customer();
		customer2.setId(128);
		customer2.setName("Jesica Grov");
		customer2.setIdType("Green Card");
		customer2.setCity("New York");
		customer2.setAmount(4260L);
		customer2.setPaymentType("Cash Payment");

		//Third Customer
		Customer customer3 = new Customer();
		customer3.setId(214);
		customer3.setName("Clay Janson");
		customer3.setIdType("Driving License");
		customer3.setCity("New York");
		customer3.setAmount(2800L);
		customer3.setPaymentType("Debit Card");


		//----------------------Create object for Customer---------------------------

		//Saving sinle object
		Customer Invoice = task.save(customer1);

		//Saving Multiple objects using list
		List<Customer>resultSet = List.of(customer1, customer2, customer3);
		Iterable<Customer>resultIterable = repo.saveAll(resultSet);

		resultIterable.forEach(System.out::println); //Method Exp., Lambda Exp.

		System.out.println("Thank you, Come back again!");


		//----------------------Updating object for Customer---------------------------
		Optional<Customer> optional = repo.findById(214); //first check the details in repo for updating
		Customer update = optional.get(); //.get method gives value ? got : exception
		update.setAmount(5400L);

		Customer updatedResult = repo.save(update); //again save as same

		System.out.println(update);


		////----------------------find(Read) all Customer---------------------------
		Iterable<Customer> itr = repo.findAll();

		itr.forEach(System.out::println);


		//----------------------Delete object in Customer table---------------------------
		//Delete by id
		repo.deleteById(214);
		System.out.println("Deleted Sucessfully!");

		//Delete all using iterable
		Iterable<Customer> iterable =  repo.findAll();
		iterable.forEach(System.out::println);

		repo.deleteAll(iterable);

	}

}
