package me.bigring.springboot.redis;

import org.springframework.data.repository.CrudRepository;

public interface ExampleRepository extends CrudRepository<Example,Long> {
}

