package br.com.ayranandrade.pseudotinder.integrationtests.repositories;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.Region;
import br.com.ayranandrade.pseudotinder.models.Street;
import br.com.ayranandrade.pseudotinder.repositories.RegionRepository;
import br.com.ayranandrade.pseudotinder.repositories.StreetRepository;

@Transactional
public class StreetRepositoryTest extends AbstractSpringBootTest {

	@Autowired
	private StreetRepository streetRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Test
	public void shouldAddStreetAndGetItFromDatabase() {
		Region region = regionRepository.findById(1).get();

		Street street = new Street("Paulista Avenue", region);

		streetRepository.save(street);

		Example<Street> exampleStreet = Example.of(street);
		Optional<Street> optionalStreet = streetRepository.findOne(exampleStreet);

		assertTrue(optionalStreet.isPresent());

		String streetDescription = optionalStreet.get().toString();

		assertTrue(streetDescription.contains("Paulista Avenue"));
	}

	@Test(expected = NoSuchElementException.class)
	public void shouldDeleteStreetFromDatabase() {
		streetRepository.deleteById(12);
		streetRepository.findById(12).orElseThrow();
	}

}
