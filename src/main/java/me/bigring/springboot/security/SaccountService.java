package me.bigring.springboot.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import me.bigring.springboot.account.Account;

@Service
public class SaccountService implements UserDetailsService {

	@Autowired
	private SaccountRepository accountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Saccount createAccount(String username, String password){
		Saccount account = new Saccount();
		account.setUsername(username);
		account.setPassword(passwordEncoder.encode(password));
		return accountRepository.save(account);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Saccount> byUsername = accountRepository.findByUsername(username);
		Saccount account = byUsername.orElseThrow(()->new UsernameNotFoundException(username));

		return new User(account.getUsername(), account.getPassword(), authorities());
	}

	private Collection<? extends GrantedAuthority> authorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
}
