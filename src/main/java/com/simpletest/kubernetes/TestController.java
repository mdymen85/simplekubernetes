package com.simpletest.kubernetes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/api/v1/test", method = RequestMethod.GET)
	public String test() {
		return "Hello World";
	}
	
}
