package br.com.ayranandrade.pseudotinder.repositories;

import br.com.ayranandrade.pseudotinder.models.Photo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {}