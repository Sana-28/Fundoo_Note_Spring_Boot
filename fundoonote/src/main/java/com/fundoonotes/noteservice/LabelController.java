package com.fundoonotes.noteservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.utility.TokenUtils;

@RestController
public class LabelController {

	@Autowired
	ILabelService labelService;
	
	@RequestMapping(value="createlabel", method = RequestMethod.POST)
	public ResponseEntity<String> createLabel(@RequestBody Label label, HttpServletRequest request,
			@RequestHeader("Authorization") String token){

		int userId = TokenUtils.verifyToken(token);
		labelService.createLabel(label, userId);
		return new ResponseEntity<>("label add", HttpStatus.OK);

	}
	
	@RequestMapping(value="getlabels", method = RequestMethod.GET)
	public ResponseEntity<?> getLabels(HttpServletRequest request,
			@RequestHeader("Authorization") String token){
	
		System.out.println("In side get label controller...");
		int userId = TokenUtils.verifyToken(token);
		
		List<LabelResDto> label= labelService.getLabels(userId);
		
		return new ResponseEntity<List>(label, HttpStatus.OK);
	}

}

