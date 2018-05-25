package com.fundoonotes.userservice;
import com.fundoonotes.userservice.User;
import com.fundoonotes.userservice.UserDto;
public interface UserService {
	//void register(User user);
	  public void register(UserDto userDto, String requestURL);
	  public String login(UserDto userDto);
	  public User getUserById(int userId);

}
		 
	 
	