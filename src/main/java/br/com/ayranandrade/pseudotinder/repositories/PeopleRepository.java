package br.com.ayranandrade.pseudotinder.repositories;

import br.com.ayranandrade.pseudotinder.models.People;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Integer> {}