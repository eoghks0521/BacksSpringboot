package me.bigring.springboot.mongo;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MaccountRepositoryTest {

	@Autowired
	MaccountRepository accountRepository;

	@Test
	public void findByEmail(){
		Maccount account = new Maccount();
		account.setUsername("daehwan");
		account.setEmail("daehwna@mail.com");

		accountRepository.save(account);

		Optional<Maccount> byId = accountRepository.findById(account.getId());
		assertThat(byId).isNotEmpty();

		Optional<Maccount> byEmail = accountRepository.findByEmail(account.getEmail());
		assertThat(byEmail).isNotEmpty();
		assertThat(byEmail.get().getUsername()).isEqualTo("daehwan");
	}
}
