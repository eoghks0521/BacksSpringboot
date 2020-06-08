package me.bigring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import me.bigring.springboot.mongo.Maccount;
import me.bigring.springboot.mongo.MaccountRepository;

@SpringBootApplication
public class SpringbootjpaApplication {

	// @Autowired
	// MongoTemplate mongoTemplate;

	// @Autowired
	// MaccountRepository maccountRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaApplication.class, args);
	}

	// @Bean
	// public ApplicationRunner applicationRunner(){
	// 	return args->{
	// 		Maccount account = new Maccount();
	// 		account.setEmail("daehwan@email.com");
	// 		account.setUsername("daehwan");
	//
	// 		//mongoTemplate.insert(account);
	// 		maccountRepository.insert(account);
	// 		System.out.println("finished");
	//
	// 	};
	// }

	//webClientBuilder 전역 적용
	@Bean
	public WebClientCustomizer webClientCustomizer(){
		return webClientBuilder -> webClientBuilder.baseUrl("http://localhost:8080/api");
	}

	@Bean
	public RestTemplateCustomizer restTemplateCustomizer(){
		return restTemplate -> {
			//java 기본 Http Connect 대신 Apache Http Client 사용 -> PSA
			restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		};
	}

}
