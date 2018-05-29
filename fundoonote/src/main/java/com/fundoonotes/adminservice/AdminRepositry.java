package com.fundoonotes.adminservice;

import org.springframework.data.repository.CrudRepository;

import com.fundoonotes.userservice.User;

public interface AdminRepositry extends CrudRepository<User,Integer>{
	 User findByEmail(String email);
}
