package br.com.ayranandrade.pseudotinder.repositories;

import br.com.ayranandrade.pseudotinder.models.Message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {}