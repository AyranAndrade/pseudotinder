package br.com.ayranandrade.pseudotinder.repositories.integrationtests;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.City;
import br.com.ayranandrade.pseudotinder.repositories.CityRepository;

public class CityRepositoryTest extends AbstractSpringBootTest {

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void shouldGetCityById() {
    	Optional<City> optionalCity = cityRepository.findById(1000);
    	assertTrue(optionalCity.isPresent());
    	String cityDescription = optionalCity.get().toString(); 
    	assertTrue(cityDescription.contains("1000"));
    }
}