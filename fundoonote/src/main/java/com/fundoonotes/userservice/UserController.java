package com.fundoonotes.userservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.utility.RegisterErrors;
import com.fundoonotes.exception.UnAuthorizedAccessUser;
import com.fundoonotes.userservice.User;
import com.fundoonotes.userservice.UserDto;
import com.fundoonotes.userservice.UserServiceImpl;
import com.fundoonotes.utility.CustomResponse;
import com.fundoonotes.utility.UserValidator;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private UserValidator userValidator;
	
	private static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping("/index")
	public String index() {
		return "hii";
	}

	//@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerUser(@Validated @RequestBody UserDto userDto, BindingResult bindingResult,
			HttpServletRequest request) throws Exception {

		userValidator.validate(userDto, bindingResult);
		List<FieldError> errors = bindingResult.getFieldErrors();

		RegisterErrors response = new RegisterErrors();
		//CustomResponse customRes = new CustomResponse();
		if (bindingResult.hasErrors()) {
			logger.info("This is an info log entry");
			response.setMsg("registrtion fail");
			response.setStatus(-200);

			return new ResponseEntity<RegisterErrors>(response, HttpStatus.CONFLICT);
		}

		String url = request.getRequestURL().toString().substring(0, request.getRequestURL().lastIndexOf("/"));
		userService.register(userDto, url);

		response.setMsg("user register successfully");
		response.setStatus(200);

		logger.info("This is info message");

		return new ResponseEntity<RegisterErrors>(response, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody UserDto userDto, HttpServletResponse response) {

		CustomResponse customRes = new CustomResponse();
		String token = userService.login(userDto);
		if (token != null) {
			response.setHeader("Authorization", token);
			customRes.setMessage("user login successfully");
			customRes.setStatusCode(100);

			return new ResponseEntity<CustomResponse>(customRes, HttpStatus.OK);
		} else {

			throw new UnAuthorizedAccessUser();
		}
	}
}
