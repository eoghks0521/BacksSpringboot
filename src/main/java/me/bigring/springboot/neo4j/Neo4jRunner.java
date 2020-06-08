package me.bigring.springboot.neo4j;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Component;

//@Component
public class Neo4jRunner implements ApplicationRunner {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	NaccountRepository naccountRepository;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Naccount account = new Naccount();
		account.setEmail("daehwna@email.com");
		account.setUsername("daehwan2");

		Role role = new Role();
		role.setName("user");

		account.getRoles().add(role);

		// Session session = sessionFactory.openSession();
		// session.save(account);
		// sessionFactory.close();
		naccountRepository.save(account);

		System.out.println("finished");
	}
}
