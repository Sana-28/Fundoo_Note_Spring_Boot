package com.fundoonotes.adminservice;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.fundoonotes.userservice.User;
import com.fundoonotes.userservice.UserDto;

import com.fundoonotes.utility.TokenUtils;

@Service
public class AdminServiceImpl implements AdminService {
     @Autowired
	AdminRepositry adminRepositry;
     private static final Logger logger = Logger.getLogger(AdminServiceImpl.class);

	@Override
	public String adminLogin(UserDto userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		System.out.println(user.getEmail());
         User userDbObj = adminRepositry.findByEmail(user.getEmail());

		if (userDbObj.getRole().equals("admin") && userDbObj != null && userDbObj.isActive() == true
				&& BCrypt.checkpw(user.getPassword(), userDbObj.getPassword())) {
			int id = userDbObj.getUserId();
			String token = TokenUtils.generateToken(id);
			System.out.println("toekn genrated :" + token);
			logger.info("token genrate" + token);

			return token;
		}
		return null;
	}
}
