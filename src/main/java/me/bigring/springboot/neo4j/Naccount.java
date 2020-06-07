package me.bigring.springboot.neo4j;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;

@NodeEntity
@Getter
@Setter
public class Naccount {

	@Id @GeneratedValue
	private Long id;

	private String username;

	private String email;

	@Relationship(type="has")
	private Set<Role> roles = new HashSet<>();
}
