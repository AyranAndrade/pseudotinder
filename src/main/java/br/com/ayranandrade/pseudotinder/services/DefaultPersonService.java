package br.com.ayranandrade.pseudotinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ayranandrade.pseudotinder.models.Person;
import br.com.ayranandrade.pseudotinder.repositories.PersonRepository;

@Service
public class DefaultPersonService implements PersonService {

	@Autowired
	private PersonRepository peopleRep;

	@Override
	public Person nextPossibleLovingPartner(Person user) {
		return null;
	}

	@Override
	public void registerUser(Person user) {
		this.peopleRep.save(user);
	}

	@Override
	public Person findPeopleByUsername(String username) {
		return peopleRep.findByUsername(username).get();
	}
}