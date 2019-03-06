package br.com.ayranandrade.pseudotinder.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ayranandrade.pseudotinder.models.SexualOrientation;
import br.com.ayranandrade.pseudotinder.models.SexualOrientationType;

public interface SexualOrientationRepository extends JpaRepository<SexualOrientation, Integer> {
	public Optional<SexualOrientation> findByName(SexualOrientationType name);
}
