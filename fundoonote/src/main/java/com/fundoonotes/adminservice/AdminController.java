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

import com.fundoonotes.exception.UnAuthorizedAccessUser;
import com.fundoonotes.userservice.UserDto;
import com.fundoonotes.utility.CustomResponse;
import com.fundoonotes.utility.UserNotedDto;



@RestController
public class AdminController {
//login
    @Autowired
	IAdminService adminService;


    
    
    @RequestMapping(value = "/admin/getusernotecount", method = RequestMethod.GET)
    public ResponseEntity<List<UserNotedDto>> getUserNoteCount()
    {

       return new ResponseEntity<>(adminService.getUserNoteCount(), HttpStatus.OK);

    }

	
		
}
