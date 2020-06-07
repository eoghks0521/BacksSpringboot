package me.bigring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import me.bigring.springboot.account.Account;
import me.bigring.springboot.mongo.Maccount;
import me.bigring.springboot.mongo.MaccountRepository;

@SpringBootApplication
public class SpringbootjpaApplication {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	MaccountRepository maccountRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(){
		return args->{
			Maccount account = new Maccount();
			account.setEmail("daehwan@email.com");
			account.setUsername("daehwan");

			//mongoTemplate.insert(account);
			maccountRepository.insert(account);
			System.out.println("finished");

		};
	}

}
