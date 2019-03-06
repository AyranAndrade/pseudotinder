package br.com.ayranandrade.pseudotinder.models.unittests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.Person;
import br.com.ayranandrade.pseudotinder.models.PossibleMatchResults;

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

    obtained = ReflectionTestUtils.invokeMethod(gabriel, "getProbabilityOfILikeThisPerson", ana);
    expected = new BigDecimal("0.849");
    assertEquals(expected, obtained);

    obtained = ReflectionTestUtils.invokeMethod(antonio, "getProbabilityOfILikeThisPerson", maria);
    expected = new BigDecimal("0.909");
    assertEquals(expected, obtained);

    obtained = ReflectionTestUtils.invokeMethod(jose, "getProbabilityOfILikeThisPerson", cassia);
    expected = new BigDecimal("0.5");
    assertEquals(expected, obtained);

    obtained = ReflectionTestUtils.invokeMethod(gabriela, "getProbabilityOfILikeThisPerson", roberto);
    expected = new BigDecimal("0.760");
    assertEquals(expected, obtained);
  }

  @Test
  public void shouldUpdateCorrectlyEloScore() {
    Integer obtained, expected;

    gabriel.updateMyEloScore(ana, PossibleMatchResults.I_LIKED_THAT_PERSON);
    obtained = gabriel.getEloScore();
    expected = 2473;
    assertEquals(expected, obtained);

    ana.updateMyEloScore(gabriel, PossibleMatchResults.THAT_PERSON_LIKED_ME);
    obtained = ana.getEloScore();
    expected = 2226;
    assertEquals(expected, obtained);

    antonio.updateMyEloScore(maria, PossibleMatchResults.I_LIKED_THAT_PERSON);
    obtained = antonio.getEloScore();
    expected = 2371;
    assertEquals(expected, obtained);

    maria.updateMyEloScore(antonio, PossibleMatchResults.THAT_PERSON_LIKED_ME);
    obtained = maria.getEloScore();
    expected = 2029;
    assertEquals(expected, obtained);

    jose.updateMyEloScore(cassia, PossibleMatchResults.I_LIKED_THAT_PERSON);
    obtained = jose.getEloScore();
    expected = 1184;
    assertEquals(expected, obtained);

    cassia.updateMyEloScore(jose, PossibleMatchResults.THAT_PERSON_LIKED_ME);
    obtained = cassia.getEloScore();
    expected = 1215;
    assertEquals(expected, obtained);

    gabriela.updateMyEloScore(roberto, PossibleMatchResults.I_LIKED_THAT_PERSON);
    obtained = gabriela.getEloScore();
    expected = 1176;
    assertEquals(expected, obtained);

    roberto.updateMyEloScore(gabriela, PossibleMatchResults.THAT_PERSON_LIKED_ME);
    obtained = roberto.getEloScore();
    expected = 1023;
    assertEquals(expected, obtained);
  }

}
