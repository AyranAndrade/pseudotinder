package br.com.ayranandrade.pseudotinder.repositories.integrationtests;

import static br.com.ayranandrade.pseudotinder.models.GenderType.CISMAN;
import static br.com.ayranandrade.pseudotinder.models.SexualOrientationType.HETEROSEXUAL;
import static java.math.BigDecimal.TEN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.Gender;
import br.com.ayranandrade.pseudotinder.models.Person;
import br.com.ayranandrade.pseudotinder.models.Profession;
import br.com.ayranandrade.pseudotinder.models.SexualOrientation;
import br.com.ayranandrade.pseudotinder.models.Street;
import br.com.ayranandrade.pseudotinder.repositories.GenderRepository;
import br.com.ayranandrade.pseudotinder.repositories.PersonRepository;
import br.com.ayranandrade.pseudotinder.repositories.ProfessionRepository;
import br.com.ayranandrade.pseudotinder.repositories.SexualOrientationRepository;
import br.com.ayranandrade.pseudotinder.repositories.StreetRepository;

public class PersonRepositoryTest extends AbstractSpringBootTest {
	
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private ProfessionRepository professionRepository;
    
    @Autowired
    private GenderRepository genderRepository;
    
    @Autowired
    private StreetRepository streetRepository;
    
    @Autowired
    private SexualOrientationRepository sexualOrientationRepository;

    @Test
    @Transactional
    public void shouldFindPersonByUsername() {
    	Person person = personRepository.findByUsername("eelstera");

    	assertFalse(person == null);
    	
    	String descriptionPerson = person.toString();
    	
    	assertTrue(descriptionPerson.contains("eelstera"));
    }
    
    @Test
    @Transactional
    public void shouldAddPerson() {
    	Integer professionId = 1;
    	Profession profession = professionRepository.findById(professionId)
    			.orElseThrow(() -> new AssertionError("Profession with id " 
    	+ professionId + " not found."));
    	
    	Gender gender = genderRepository.findByGenderName(CISMAN)
    			.orElseThrow(() -> new AssertionError("Gender " + CISMAN.name() 
    			+ " not found"));
    	
    	Integer streetId = 1;
    	Street street = streetRepository.findById(streetId)
    			.orElseThrow(() -> new AssertionError("Street with id " 
    	+ streetId + " not found."));
    	
    	SexualOrientation sexualOrientation = sexualOrientationRepository
    			.findByName(HETEROSEXUAL)
    			.orElseThrow(() -> new AssertionError("Sexuality " 
    			+ HETEROSEXUAL.name() + " not found."));
    	
    	Person person = new Person.Builder()
    			.name("John Doe")
    			.birthDate(LocalDate.now())
    			.aboutMe("I am a nice guy.")
    			.username("johndoe")
    			.maxDistance(TEN)
    			.maxAge(30)
    			.minAge(18)
    			.sexualOrientation(sexualOrientation)
    			.gender(gender)
    			.profession(profession)
    			.street(street)
    			.build();
    	
    	personRepository.save(person);
    	
    	Integer personId = person.getId();
    	
    	Optional<Person> optionalPerson = personRepository.findById(personId);
    	
    	assertTrue(optionalPerson.isPresent());
    	
    	String descriptionPersonExpected = person.toString();
    	String descriptionPerson = optionalPerson.get().toString();
    	
    	assertEquals(descriptionPersonExpected, descriptionPerson);
    }

    @Test
    @Transactional
    public void shouldGetPeopleById() {
    	Optional<Person> optionalPerson = personRepository.findById(1);
    	assertTrue(optionalPerson.isPresent());
    	String descriptionPersom = optionalPerson.get().toString(); 
    	assertTrue(descriptionPersom.contains("1"));
    }
    
    @Test
    @Transactional
    public void shouldDeletePeopleFromDatabase() {
    	personRepository.deleteById(2);
    	Optional<Person> optionalPerson = personRepository.findById(2);
    	assertTrue(optionalPerson.isEmpty());
    }

}
