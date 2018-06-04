package com.fundoonotes.adminservice;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.userservice.UserDto;
import com.fundoonotes.utility.CustomResponse;
import com.fundoonotes.utility.UserNotedDto;

@RestController
public class AdminController
{

   @Autowired
   IAdminService adminService;
   
   @Value("${spring.boot.admin.username}")
   private String email;
   
   @Value("${spring.boot.admin.password}")
   private String password;

   @RequestMapping(value = "admin/login", method = RequestMethod.POST)
   public ResponseEntity<?> adminLogin(@RequestBody AdminDto adminDto)
   {

      CustomResponse customRes = new CustomResponse();

      if (adminDto.getEmail().equals(email) && adminDto.getPassword().equals(password)) {
         customRes.setMessage("admin login successfully");
         customRes.setStatusCode(200);
         return new ResponseEntity<CustomResponse>(customRes, HttpStatus.OK);
      } else {

         customRes.setMessage("Invalid username or password");
         customRes.setStatusCode(409);
         return new ResponseEntity<CustomResponse>(customRes, HttpStatus.CONFLICT);
      }
   }

   @RequestMapping(value = "/admin/getusernotecount", method = RequestMethod.GET)
   public ResponseEntity<List<UserNotedDto>> getUserNoteCount()
   {
      return new ResponseEntity<>(adminService.getUserNoteCount(), HttpStatus.OK);
   }
}
