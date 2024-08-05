package com.database.config.repo;

import org.springframework.data.repository.CrudRepository;

import com.database.config.entity.User;

public interface UserRepo extends CrudRepository<User, Integer>{

}
