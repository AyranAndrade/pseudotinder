package br.com.ayranandrade.pseudotinder.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ayranandrade.pseudotinder.models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	public Optional<Person> findByUsername(String username);
}