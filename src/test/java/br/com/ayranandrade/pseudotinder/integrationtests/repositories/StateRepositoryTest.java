package br.com.ayranandrade.pseudotinder.integrationtests.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.State;
import br.com.ayranandrade.pseudotinder.repositories.StateRepository;

public class StateRepositoryTest extends AbstractSpringBootTest {

	@Autowired
	private StateRepository stateRepository;

	@Test
	public void shouldAddStateAndGetItFromDatabase() {
		State state = new State("New York");

		stateRepository.save(state);

		Example<State> exampleState = Example.of(state);
		Optional<State> optionalState = stateRepository.findOne(exampleState);

		assertTrue(optionalState.isPresent());

		String stateDescription = optionalState.get().toString();

		assertTrue(stateDescription.contains("New York"));
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void shouldNotDeleteStateFromDatabaseIfItIsUsed() {
		stateRepository.deleteById(1);
	}

}
