package com.database.config.repo;

import com.database.config.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    public List<Customer> findByName(String name); //CRUD 2 (Custom methods)

    public List<Customer> findByNameAndCity(String name, String city); //CRUD 2 (Custom methods)
}
