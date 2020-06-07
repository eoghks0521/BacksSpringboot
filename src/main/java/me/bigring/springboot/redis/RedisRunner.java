package me.bigring.springboot.redis;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;


//@Component
public class RedisRunner implements ApplicationRunner {

	@Autowired
	StringRedisTemplate redisTemplate;

	@Autowired
	ExampleRepository exampleRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ValueOperations<String,String> values = redisTemplate.opsForValue();
		values.set("daehwan","bigring");
		values.set("springboot", "2.0");
		values.set("helllo","world");

		Example example = new Example();
		example.setEmail("bigring@email.com");
		example.setUsername("daehwan");

		exampleRepository.save(example);

		Optional<Example> byId= exampleRepository.findById(example.getId());
		System.out.println(byId.get().getUsername());
		System.out.println(byId.get().getEmail());

	}
}
