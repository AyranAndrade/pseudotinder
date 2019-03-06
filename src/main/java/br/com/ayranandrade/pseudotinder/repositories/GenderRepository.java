package br.com.ayranandrade.pseudotinder.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ayranandrade.pseudotinder.models.Gender;
import br.com.ayranandrade.pseudotinder.models.GenderType;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
	public Optional<Gender> findByGenderName(GenderType name);
}
