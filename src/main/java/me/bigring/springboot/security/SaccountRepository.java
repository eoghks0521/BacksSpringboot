package me.bigring.springboot.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaccountRepository extends JpaRepository<Saccount,Long> {

	Optional<Saccount> findByUsername(String username);
}
