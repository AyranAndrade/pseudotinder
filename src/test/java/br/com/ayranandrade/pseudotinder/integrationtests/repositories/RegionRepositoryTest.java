package br.com.ayranandrade.pseudotinder.integrationtests.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.City;
import br.com.ayranandrade.pseudotinder.models.Region;
import br.com.ayranandrade.pseudotinder.repositories.CityRepository;
import br.com.ayranandrade.pseudotinder.repositories.RegionRepository;

public class RegionRepositoryTest extends AbstractSpringBootTest {
	
    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private CityRepository cityRepository;
    
    @Test
    public void shouldAddRegionToDatabaseAndGetItById() {
      City city = cityRepository.findById(1).get();
    	Region region = new Region("Silicon Valley", city);
    	regionRepository.save(region);
    	Integer regionId = region.getId();
    	Optional<Region> optionalRegion = regionRepository.findById(regionId);
    	assertTrue(optionalRegion.isPresent());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotDeleteRegionFromDatabaseIfItIsUsed() {
    	regionRepository.deleteById(1);
    }

}
