package br.com.ayranandrade.pseudotinder.integrationtests.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.City;
import br.com.ayranandrade.pseudotinder.repositories.CityRepository;

public class CityRepositoryTest extends AbstractSpringBootTest {

	@Autowired
	private CityRepository cityRepository;

	@Test
	@Transactional
	public void shouldGetCityById() {
		Optional<City> optionalCity = cityRepository.findById(1000);
		assertTrue(optionalCity.isPresent());
		String cityDescription = optionalCity.get().toString();
		assertTrue(cityDescription.contains("1000"));
	}
}