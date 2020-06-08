package me.bigring.springboot.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Saccount {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
}
