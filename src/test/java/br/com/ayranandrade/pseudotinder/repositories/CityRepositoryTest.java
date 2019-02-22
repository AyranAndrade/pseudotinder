package br.com.ayranandrade.pseudotinder.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ayranandrade.pseudotinder.models.City;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryTest {

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