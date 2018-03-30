package br.com.ayranandrade.pseudotinder.repositories;

import br.com.ayranandrade.pseudotinder.models.State;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {}