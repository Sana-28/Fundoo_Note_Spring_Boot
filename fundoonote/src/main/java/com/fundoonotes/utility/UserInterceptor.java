package com.fundoonotes.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
<<<<<<< HEAD
=======
import org.springframework.web.servlet.HandlerInterceptor;
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
import org.springframework.web.servlet.ModelAndView;

import com.fundoonotes.userservice.User;
import com.fundoonotes.userservice.UserService;
<<<<<<< HEAD

@Component
public class UserInterceptor {
=======
import com.fundoonotes.utility.TokenUtils;

@Component
public class UserInterceptor implements HandlerInterceptor {
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
	@Autowired
	private UserService userService;
	private static final Logger logger = Logger.getLogger(UserInterceptor.class);

<<<<<<< HEAD

=======
	@Override
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
		try {
			System.out.println("toekon for jwt user"+TokenUtils.verifyToken(request.getHeader("Authorization")));
			int userId = TokenUtils.verifyToken(request.getHeader("Authorization"));
			request.setAttribute("userId",userId);
			
			
			logger.info("this  is interceptor");
			logger.info("this is the place where you should get logged user");
			//check user null
			User user=userService.getUserById(userId);
			if(user==null)
			{
				return false;
			}
		   } catch (Exception e) 
		      {
			  e.printStackTrace();
			 return false;
	        	}
		  return true;
	}
	
<<<<<<< HEAD
=======
	@Override
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info("After handling the request");
		System.out.println("After handling the request");

	}

<<<<<<< HEAD
	
=======
	@Override
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		logger.info("After rendering the view");
		System.out.println("After rendering the view");
	}
<<<<<<< HEAD
=======

>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
}
