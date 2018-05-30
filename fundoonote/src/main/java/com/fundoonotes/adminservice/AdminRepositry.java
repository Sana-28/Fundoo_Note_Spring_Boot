package com.fundoonotes.adminservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoonotes.userservice.User;

public interface AdminRepositry extends JpaRepository<User,Integer>{
	
	User findByEmail(String email);
	 //get note particular user
	 // long getNoteCount(User user);
	  //get number notes which contain images
	  // long getImageNoteCount(User user);
	   
	   

	
}
