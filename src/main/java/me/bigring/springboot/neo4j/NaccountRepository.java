package me.bigring.springboot.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface NaccountRepository extends Neo4jRepository<Naccount,Long> {
}
