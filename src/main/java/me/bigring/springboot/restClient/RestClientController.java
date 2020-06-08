package me.bigring.springboot.restClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestClientController {

	@GetMapping("/api/hello")
	public String hello() throws InterruptedException{
		Thread.sleep(5000l);
		return "hello";
	}
	@GetMapping("/api/world")
	public String world() throws InterruptedException{
		Thread.sleep(3000l);
		return "world";
	}
}
