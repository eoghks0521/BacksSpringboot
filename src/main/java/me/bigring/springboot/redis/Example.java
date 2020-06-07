package me.bigring.springboot.redis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RedisHash("accounts")
public class Example {

	@Id
	private  Long id;

	private String username;

	private String email;

}
