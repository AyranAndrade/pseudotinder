package br.com.ayranandrade.pseudotinder.integrationtests.repositories;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.Profession;
import br.com.ayranandrade.pseudotinder.repositories.ProfessionRepository;

public class ProfessionRepositoryTest extends AbstractSpringBootTest {
	
    @Autowired
    private ProfessionRepository professionRepository;
    
    @Test
    public void shouldAddProfessionToDatabaseAndGetItById() {
    	Profession profession = new Profession("CEO");
    	professionRepository.save(profession);
    	Integer professionId = profession.getId();
    	Optional<Profession> optionalProfession = professionRepository.findById(professionId);
    	assertTrue(optionalProfession.isPresent());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotDeleteProfessionThatIsUsedByPeople() {
    	professionRepository.deleteById(1);
    }

}
