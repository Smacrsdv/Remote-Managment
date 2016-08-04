package com.smacrs.timemanagment.rest.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tmapi")
public class FakeController {

	@Autowired
	BCryptPasswordEncoder encoder;

	@RequestMapping(value = "/fake0", method = RequestMethod.GET)
	public ResponseEntity<String> f0() {
		System.out.println("f0");
		return new ResponseEntity<String>("f0", HttpStatus.OK);
	}

	@RequestMapping(value = "/fake1", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<String> f1() {
		System.out.println("f1");
		return new ResponseEntity<String>("f1", HttpStatus.OK);
	}

	@RequestMapping(value = "/fake2", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> f2() {
		System.out.println("f2");
		return new ResponseEntity<String>("f2", HttpStatus.OK);
	}

	@RequestMapping(value = "/fake3", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public ResponseEntity<String> f3() {
		System.out.println("f3");
		return new ResponseEntity<String>("f3", HttpStatus.OK);
	}

	@RequestMapping(value = "{nickname}/fake4", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER_' + #nickname)")
	public ResponseEntity<String> f4(@PathVariable String nickname) {
		System.out.println("f4 " + nickname);
		return new ResponseEntity<String>("f4 " + nickname, HttpStatus.OK);
	}

	@RequestMapping(value = "{nickname}/fake5", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER') and #nickname == 'smacrs'")
	public ResponseEntity<String> f5(@PathVariable String nickname) {
		System.out.println("f5 " + nickname);
		return new ResponseEntity<String>("f5", HttpStatus.OK);
	}
	
	@RequestMapping(value = "{nickname}/fake6", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<String> f6(@PathVariable String nickname) {
		System.out.println("f6 " + nickname);
		return new ResponseEntity<String>("f6", HttpStatus.OK);
	}

}
