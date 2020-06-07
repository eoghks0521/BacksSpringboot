package me.bigring.springboot.mongo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaccountRepository extends MongoRepository<Maccount,String> {
	Optional<Maccount> findByEmail(String email);
}
