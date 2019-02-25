package br.com.ayranandrade.pseudotinder.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.Match;

public class MatchRepositoryTest extends AbstractSpringBootTest {
	
    @Autowired
    private MatchRepository matchRepository;

    @Test
    public void shouldGetMatchById() {
    	/*Optional<Match> optionalMatch = matchRepository.findById(5000);
    	assertTrue(optionalMatch.isPresent());
    	String matchToString = optionalMatch.get().toString(); 
    	assertTrue(matchToString.contains("5000"));*/
    }

}
