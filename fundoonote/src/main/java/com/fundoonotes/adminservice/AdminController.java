package com.fundoonotes.adminservice;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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

   @RequestMapping(value = "/admin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> login(@RequestBody AdminDto adminDto, HttpServletResponse response)
   {

      CustomResponse customRes = new CustomResponse();
      adminService.login(adminDto);
      return new ResponseEntity<CustomResponse>(customRes, HttpStatus.OK);

   }

   @RequestMapping(value = "/admin/getusernotecount", method = RequestMethod.GET)
   public ResponseEntity<List<UserNotedDto>> getUserNoteCount()
   {
      return new ResponseEntity<>(adminService.getUserNoteCount(), HttpStatus.OK);
   }
}
