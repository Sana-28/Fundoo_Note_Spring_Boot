package com.fundoonotes.userservice;
import java.util.Optional;


import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoonotes.userservice.UserDAO;
import com.fundoonotes.exception.EmailAlreadyExistsException;
import com.fundoonotes.userservice.User;
import com.fundoonotes.userservice.UserDto;
import com.fundoonotes.userservice.UserController;
import com.fundoonotes.utility.TokenUtils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDao;//crudRespositry instance
    @Autowired
	public MailService mailService;
	
    
	
	private static final Logger logger = Logger.getLogger(UserController.class);

	
	
	@Transactional
	public void register(UserDto userDto, String requestURL) {

	 
		User userFromDB = userDao.getUserByEmailId(userDto.getEmail());
		if (userFromDB != null) {
			throw new EmailAlreadyExistsException();
		}

		User user = new User(userDto);
		//String hashCode = encryptPassword.getMD5EncryptedValue(userDto.getPassword());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashCode = passwordEncoder.encode(userDto.getPassword());
		user.setPassword(hashCode);

		String randomUUID = UUID.randomUUID().toString();
		user.setRandomID(randomUUID);

	       userDao.save(user);//jpa given
		

		String to = user.getEmail();
		String subject = "FundooPay registration verification";
		String message = requestURL + "/RegistrationConfirm/" + randomUUID;
		mailService.sendMail(to, subject, message);
	}

	@Override
	public String login(UserDto userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		System.out.println(user.getEmail());
		
		User userDbObj = userDao.getUserByEmailId(user.getEmail());
	
		if (userDbObj != null && userDbObj.isActive() == true
				&& BCrypt.checkpw(user.getPassword(),userDbObj.getPassword())) 
		{
			int id =userDbObj.getUserId();
			String token = TokenUtils.generateToken(id);
			System.out.println("toekn genrated :" + token);
			logger.info("token genrate" + token);
			
			return token;
		}
		return null;
	}

	@Override
	public User getUserById(int userId) {
		 User user=userDao.getUserById(userId);
		 // User user=userDao.findById(userId);
		  System.out.println("name of user" + user.getName());
			System.out.println("email of user" + user.getEmail());
			return user;	
	}

}

