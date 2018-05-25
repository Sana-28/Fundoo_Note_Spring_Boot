package com.fundoonotes.userservice;
<<<<<<< HEAD

public interface UserService {
	  public void register(UserDto userDto, String requestURL);
	  public String login(UserDto userDto);
	  public User getUserById(int userId);
	  int userActivation(String randomId);
	  public boolean forgetPassword(String email, String url);
	  public int resetPassword(UserDto userDto);

}
=======
import com.fundoonotes.userservice.User;
import com.fundoonotes.userservice.UserDto;
public interface UserService {
	//void register(User user);
	  public void register(UserDto userDto, String requestURL);
	  public String login(UserDto userDto);
	  public User getUserById(int userId);

}
		 
	 
	
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
