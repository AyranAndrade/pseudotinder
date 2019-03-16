package br.com.ayranandrade.pseudotinder.unittests.models;

import static org.junit.Assert.assertEquals;

import static br.com.ayranandrade.pseudotinder.models.PossibleMatchResults.I_LIKED_THAT_PERSON;
import static br.com.ayranandrade.pseudotinder.models.PossibleMatchResults.THAT_PERSON_LIKED_ME;
import static br.com.ayranandrade.pseudotinder.models.PossibleMatchResults.I_DISLIKED_THAT_PERSON;
import static br.com.ayranandrade.pseudotinder.models.PossibleMatchResults.THAT_PERSON_DISLIKED_ME;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.Person;

public class PersonTest extends AbstractSpringBootTest {

  Person gabriel, ana, antonio, maria, jose, cassia, gabriela, roberto;

  @Before
  public void setup() {
    gabriel = new Person.Builder().name("Gabriel").eloScore(2500).build();

    ana = new Person.Builder().name("Ana").eloScore(2200).build();

    antonio = new Person.Builder().name("Antônio").eloScore(2400).build();

    maria = new Person.Builder().name("Maria").eloScore(2000).build();

    jose = new Person.Builder().name("José").eloScore(1200).build();

    cassia = new Person.Builder().name("Cássia").eloScore(1200).build();

    gabriela = new Person.Builder().name("Gabriela").eloScore(1200).build();

    roberto = new Person.Builder().name("Roberto").eloScore(1000).build();

  }

  @Test
  public void shouldReturnCorrectProbability() {
    BigDecimal obtained, expected;

    obtained = getProbabilityOfFirstPersonLikesSecondPerson(gabriel, ana);
    expected = new BigDecimal("0.849");
    assertEquals(expected, obtained);

    obtained = getProbabilityOfFirstPersonLikesSecondPerson(antonio, maria);
    expected = new BigDecimal("0.909");
    assertEquals(expected, obtained);

    obtained = getProbabilityOfFirstPersonLikesSecondPerson(jose, cassia);
    expected = new BigDecimal("0.5");
    assertEquals(expected, obtained);

    obtained = getProbabilityOfFirstPersonLikesSecondPerson(gabriela, roberto);
    expected = new BigDecimal("0.760");
    assertEquals(expected, obtained);
  }

  private BigDecimal getProbabilityOfFirstPersonLikesSecondPerson(Person firstPerson, Person secondPerson) {
	  // "getProbabilityOfILikeThisPerson" is a private method from class Person.
	  return ReflectionTestUtils.invokeMethod(firstPerson, "getProbabilityOfILikeThisPerson", secondPerson);
  }

  @Test
  public void shouldUpdateCorrectlyEloScore() {
    Integer obtained, expected;

    gabriel.updateMyEloScore(ana, I_LIKED_THAT_PERSON);
    obtained = gabriel.getEloScore();
    expected = 2473;
    assertEquals(expected, obtained);

    ana.updateMyEloScore(gabriel, THAT_PERSON_LIKED_ME);
    obtained = ana.getEloScore();
    expected = 2226;
    assertEquals(expected, obtained);

    ana.updateMyEloScore(gabriel, I_DISLIKED_THAT_PERSON);
    obtained = ana.getEloScore();
    expected = 2252;
    assertEquals(expected, obtained);

    gabriel.updateMyEloScore(ana, THAT_PERSON_DISLIKED_ME);
    obtained = gabriel.getEloScore();
    expected = 2448;
    assertEquals(expected, obtained);

    antonio.updateMyEloScore(maria, I_LIKED_THAT_PERSON);
    obtained = antonio.getEloScore();
    expected = 2371;
    assertEquals(expected, obtained);

    maria.updateMyEloScore(antonio, THAT_PERSON_LIKED_ME);
    obtained = maria.getEloScore();
    expected = 2029;
    assertEquals(expected, obtained);

    maria.updateMyEloScore(antonio, I_DISLIKED_THAT_PERSON);
    obtained = maria.getEloScore();
    expected = 2057;
    assertEquals(expected, obtained);

    antonio.updateMyEloScore(maria, THAT_PERSON_DISLIKED_ME);
    obtained = antonio.getEloScore();
    expected = 2344;
    assertEquals(expected, obtained);

    jose.updateMyEloScore(cassia, I_LIKED_THAT_PERSON);
    obtained = jose.getEloScore();
    expected = 1184;
    assertEquals(expected, obtained);

    cassia.updateMyEloScore(jose, THAT_PERSON_LIKED_ME);
    obtained = cassia.getEloScore();
    expected = 1215;
    assertEquals(expected, obtained);

    cassia.updateMyEloScore(jose, I_LIKED_THAT_PERSON);
    obtained = cassia.getEloScore();
    expected = 1198;
    assertEquals(expected, obtained);

    jose.updateMyEloScore(cassia, THAT_PERSON_LIKED_ME);
    obtained = jose.getEloScore();
    expected = 1201;
    assertEquals(expected, obtained);

    gabriela.updateMyEloScore(roberto, I_LIKED_THAT_PERSON);
    obtained = gabriela.getEloScore();
    expected = 1176;
    assertEquals(expected, obtained);

    roberto.updateMyEloScore(gabriela, THAT_PERSON_LIKED_ME);
    obtained = roberto.getEloScore();
    expected = 1023;
    assertEquals(expected, obtained);

    roberto.updateMyEloScore(gabriela, I_LIKED_THAT_PERSON);
    obtained = roberto.getEloScore();
    expected = 1014;
    assertEquals(expected, obtained);

    gabriela.updateMyEloScore(roberto, THAT_PERSON_LIKED_ME);
    obtained = gabriela.getEloScore();
    expected = 1185;
    assertEquals(expected, obtained);
  }

}
