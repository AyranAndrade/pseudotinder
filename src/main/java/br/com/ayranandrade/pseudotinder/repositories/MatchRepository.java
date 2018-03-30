package br.com.ayranandrade.pseudotinder.repositories;

import br.com.ayranandrade.pseudotinder.models.Match;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer> {}