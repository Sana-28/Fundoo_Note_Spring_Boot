package com.fundoonotes.adminservice;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.exception.UnAuthorizedAccessUser;
import com.fundoonotes.userservice.UserDto;
import com.fundoonotes.utility.CustomResponse;



@RestController
public class AdminController {
//login
    @Autowired
	AdminService adminService;
	
		@RequestMapping(value = "/admin/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> login(@RequestBody UserDto userDto, HttpServletResponse response) {

			CustomResponse customRes = new CustomResponse();
			String token = adminService.adminLogin(userDto);
			System.out.println("this is your tooekn:"+token);
			if (token != null) {
				response.setHeader("Authorization", token);
				customRes.setMessage("admin login successfully");
				customRes.setStatusCode(100);

				return new ResponseEntity<CustomResponse>(customRes, HttpStatus.OK);
			} else {

				throw new UnAuthorizedAccessUser();
			}

		}
}
