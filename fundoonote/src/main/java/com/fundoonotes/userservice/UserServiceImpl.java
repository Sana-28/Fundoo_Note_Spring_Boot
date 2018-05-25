package com.fundoonotes.userservice;
<<<<<<< HEAD

import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fundoonotes.exception.EmailAlreadyExistsException;
import com.fundoonotes.utility.TokenUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;// crudRespositry instance
	@Autowired
	public MailService mailService;

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Transactional
	public void register(UserDto userDto, String requestURL) {

		//User userFromDB = userDao.getUserByEmailId(userDto.getEmail());
		User userFromDB = userDao.findByEmail(userDto.getEmail());
=======
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
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
		if (userFromDB != null) {
			throw new EmailAlreadyExistsException();
		}

		User user = new User(userDto);
<<<<<<< HEAD
		// String hashCode =
		// encryptPassword.getMD5EncryptedValue(userDto.getPassword());
=======
		//String hashCode = encryptPassword.getMD5EncryptedValue(userDto.getPassword());
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashCode = passwordEncoder.encode(userDto.getPassword());
		user.setPassword(hashCode);

<<<<<<< HEAD
		String randomId = UUID.randomUUID().toString();
		user.setRandomId(randomId);

		userDao.save(user);// jpa given

		String to = user.getEmail();
		String subject = "FundooPay registration verification";
		String message = requestURL + "/RegistrationConfirm/" + randomId;
=======
		String randomUUID = UUID.randomUUID().toString();
		user.setRandomID(randomUUID);

	       userDao.save(user);//jpa given
		

		String to = user.getEmail();
		String subject = "FundooPay registration verification";
		String message = requestURL + "/RegistrationConfirm/" + randomUUID;
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
		mailService.sendMail(to, subject, message);
	}

	@Override
	public String login(UserDto userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		System.out.println(user.getEmail());
<<<<<<< HEAD

		// User userDbObj = userDao.getUserByEmailId(user.getEmail());

		User userDbObj = userDao.findByEmail(user.getEmail());

		if (userDbObj != null && userDbObj.isActive() == true
				&& BCrypt.checkpw(user.getPassword(), userDbObj.getPassword())) {
			int id = userDbObj.getUserId();
			String token = TokenUtils.generateToken(id);
			System.out.println("toekn genrated :" + token);
			logger.info("token genrate" + token);

=======
		
		User userDbObj = userDao.getUserByEmailId(user.getEmail());
	
		if (userDbObj != null && userDbObj.isActive() == true
				&& BCrypt.checkpw(user.getPassword(),userDbObj.getPassword())) 
		{
			int id =userDbObj.getUserId();
			String token = TokenUtils.generateToken(id);
			System.out.println("toekn genrated :" + token);
			logger.info("token genrate" + token);
			
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
			return token;
		}
		return null;
	}

	@Override
	public User getUserById(int userId) {
<<<<<<< HEAD
		// User user=userDao.getUserById(userId);
		User user = userDao.findById(userId).get();
		System.out.println("name of user" + user.getName());
		System.out.println("email of user" + user.getEmail());
		return user;

	}

	@Transactional
	@Override
	public int userActivation(String randomId) {
		//User user = userDao.getUserByUIID(randomId);
		User user = userDao.findByRandomId(randomId);
		user.setActive(true);
		//return userDao.activeUser(user.getEmail(), user.isActive());
		userDao.save(user);
		
		return 1;
	}

	@Override
	public boolean forgetPassword(String email, String requestURL) {
		boolean flag = false;
		//User user = userDao.getUserByEmailId(email);
		User user = userDao.findByEmail(email);
		if (user != null) {
			String emailID = user.getEmail();
			String randomId = UUID.randomUUID().toString();
			String jwtToken = TokenUtils.generateToken(user.getUserId());
			String to = user.getEmail();
			String subject = "Link to reset password";

			String message = requestURL + "/resetpassword/" + jwtToken;
			mailService.sendMail(to, subject, message);
			flag = true;

			//userDao.saveUsernameUid(emailID, randomId);
			user.setEmail(emailID);
			user.setRandomId(randomId);
			userDao.save(user);
			

		}
		return flag;
	}

	@Transactional
	@Override
	public int resetPassword(UserDto userDto) {
		User user = userDao.findByEmail(userDto.getEmail());
		//user.setEmail(userDto.getEmail());
		//user.setPassword(userDto.getPassword());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String hashCode = passwordEncoder.encode(userDto.getPassword());
		user.setPassword(hashCode);
		//return userDao.resetPassword(user.getPassword(), user.getEmail());
		userDao.save(user);
		return 1;

	}


}
=======
		 User user=userDao.getUserById(userId);
		 // User user=userDao.findById(userId);
		  System.out.println("name of user" + user.getName());
			System.out.println("email of user" + user.getEmail());
			return user;	
	}

}

>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
