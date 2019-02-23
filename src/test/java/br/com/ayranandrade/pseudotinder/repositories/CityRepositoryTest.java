package br.com.ayranandrade.pseudotinder.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.City;

public class CityRepositoryTest extends AbstractSpringBootTest {

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void shouldGetCityById() {
    	Optional<City> optionalCity = cityRepository.findById(5000);
    	assertTrue(optionalCity.isPresent());
    	String cityDescription = optionalCity.get().toString(); 
    	assertTrue(cityDescription.contains("5000"));
    }
}