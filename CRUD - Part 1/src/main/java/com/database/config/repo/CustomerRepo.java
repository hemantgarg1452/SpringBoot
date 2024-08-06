package com.database.config.repo;

import com.database.config.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {
}
