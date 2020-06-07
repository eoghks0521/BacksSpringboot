package me.bigring.springboot.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

	@Id @GeneratedValue
	private  Long id;

	private String username;

	private String password;

	private String email;

	private boolean active;

}
