package br.com.ayranandrade.pseudotinder.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.Match;
import br.com.ayranandrade.pseudotinder.models.People;

public class MatchRepositoryTest extends AbstractSpringBootTest {
	
    @Autowired
    private MatchRepository matchRepository;
    
    @Autowired
    private PeopleRepository peopleRepository;
    
    @Test
    public void shouldAddMatchToDatabase() {
    	People firstPerson = peopleRepository.getOne(10);
    	People secondPerson = peopleRepository.getOne(11);
    	Match match = new Match(firstPerson, secondPerson, true);
    	matchRepository.save(match);
    	Integer matchId = match.getId();
    	Optional<Match> optionalMatch = matchRepository.findById(matchId);
    	assertTrue(optionalMatch.isPresent());
    }

    @Test
    @Transactional
    public void shouldGetMatchById() {
    	Optional<Match> optionalMatch = matchRepository.findById(1);
    	assertTrue(optionalMatch.isPresent());
    	String matchToString = optionalMatch.get().toString(); 
    	assertTrue(matchToString.contains("1"));
    }
    
    @Test
    public void shouldDeleteMatchFromDatabase() {
    	matchRepository.deleteById(2);
    	Optional<Match> optionalMatch = matchRepository.findById(2);
    	assertTrue(optionalMatch.isEmpty());
    }

}
