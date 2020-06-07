package me.bigring.springboot.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "accounts")
@Getter
@Setter
public class Maccount {

	@Id
	private String id;

	private String username;

	private String email;
}
