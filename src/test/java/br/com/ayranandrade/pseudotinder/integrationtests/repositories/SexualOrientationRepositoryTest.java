package br.com.ayranandrade.pseudotinder.integrationtests.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.SexualOrientation;
import br.com.ayranandrade.pseudotinder.models.SexualOrientationType;
import br.com.ayranandrade.pseudotinder.repositories.SexualOrientationRepository;

public class SexualOrientationRepositoryTest extends AbstractSpringBootTest {
	
    @Autowired
    private SexualOrientationRepository sexualOrientationRepository;
    
    @Test
    public void shouldGetSexualOrientationByName() {
      Optional<SexualOrientation> optionalSexualOrientation = 
      sexualOrientationRepository.findByName(SexualOrientationType.PANSEXUAL);
      assertTrue(optionalSexualOrientation.isPresent());
      String sexualOrientationDescription = optionalSexualOrientation.get().toString();
      assertTrue(sexualOrientationDescription.contains("PANSEXUAL"));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotDeleteSexualOrientationFromDatabaseIfItIsUsed() {
    	sexualOrientationRepository.deleteById(1);
    }

}
