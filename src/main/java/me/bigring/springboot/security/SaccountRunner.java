package me.bigring.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class SaccountRunner implements ApplicationRunner {

	@Autowired
	SaccountService accountService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Saccount account = accountService.createAccount("daehwan","1234");
		System.out.println(account.getUsername()+" password: "+account.getPassword());

	}
}
