package br.com.ayranandrade.pseudotinder.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ayranandrade.pseudotinder.models.PersonUserDetails;
import br.com.ayranandrade.pseudotinder.repositories.PersonRepository;

@Service
public class DefaultLoginService implements UserDetailsService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return personRepository
				.findByUsername(username)
				.flatMap(person -> Optional.of(new PersonUserDetails(person)))
				.orElseThrow(() -> new UsernameNotFoundException("Username "
						+ username + " was not found."));
	}

}
