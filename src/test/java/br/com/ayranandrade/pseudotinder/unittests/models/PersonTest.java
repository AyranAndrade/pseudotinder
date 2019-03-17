package br.com.ayranandrade.pseudotinder.unittests.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.Person;

public class PersonTest extends AbstractSpringBootTest {

	@Test
	public void shouldUpdateEloScoreAfterGabrielGivesLikeToAna() {
		Person gabriel = new Person.Builder().name("Gabriel").eloScore(2500).build();
		Person ana = new Person.Builder().name("Ana").eloScore(2200).build();

		gabriel.giveLikeTo(ana);
		ana.receiveLikeFrom(gabriel);

		Integer obtainedEloScoreFromGabriel = gabriel.getEloScore();
		Integer expectedEloScoreFromGabriel = 2473;
		assertEquals(expectedEloScoreFromGabriel, obtainedEloScoreFromGabriel);

		Integer obtainedEloScoreFromAna = ana.getEloScore();
		Integer expectedEloScoreFromAna = 2226;
		assertEquals(expectedEloScoreFromAna, obtainedEloScoreFromAna);
	}

	@Test
	public void shouldUpdateEloScoreAfterJulianaGivesDislikeToFabio() {
		Person fabio = new Person.Builder().name("Fabio").eloScore(2473).build();
		Person juliana = new Person.Builder().name("Juliana").eloScore(2226).build();

		juliana.giveDislikeTo(fabio);
		fabio.receiveDislikeFrom(juliana);

		Integer obtainedEloScoreFromJuliana = juliana.getEloScore();
		Integer expectedEloScoreFromJuliana = 2252;
		assertEquals(expectedEloScoreFromJuliana, obtainedEloScoreFromJuliana);

		Integer obtainedEloScoreFromFabio = fabio.getEloScore();
		Integer expectedEloScoreFromFabio = 2448;
		assertEquals(expectedEloScoreFromFabio, obtainedEloScoreFromFabio);
	}

	@Test
	public void shouldUpdateEloScoreAfterAntonioGivesLikeToMaria() {
		Person antonio = new Person.Builder().name("Antônio").eloScore(2400).build();
		Person maria = new Person.Builder().name("Maria").eloScore(2000).build();

		antonio.giveLikeTo(maria);
		maria.receiveLikeFrom(antonio);

		Integer obtainedEloScoreFromAntonio = antonio.getEloScore();
		Integer expectedEloScoreFromAntonio = 2371;
		assertEquals(expectedEloScoreFromAntonio, obtainedEloScoreFromAntonio);

		Integer obtainedEloScoreFromMaria = maria.getEloScore();
		Integer expectedEloScoreFromMaria = 2029;
		assertEquals(expectedEloScoreFromMaria, obtainedEloScoreFromMaria);
	}

	@Test
	public void shouldUpdateEloScoreAfterStefaniGivesDislikeToAndre() {
		Person andre = new Person.Builder().name("André").eloScore(2371).build();
		Person stefani = new Person.Builder().name("Stefani").eloScore(2029).build();

		stefani.giveDislikeTo(andre);
		andre.receiveDislikeFrom(stefani);

		Integer obtainedEloScoreFromAndre = andre.getEloScore();
		Integer expectedEloScoreFromAndre = 2344;
		assertEquals(expectedEloScoreFromAndre, obtainedEloScoreFromAndre);

		Integer obtainedEloScoreFromStefani = stefani.getEloScore();
		Integer expectedEloScoreFromStefani = 2057;
		assertEquals(expectedEloScoreFromStefani, obtainedEloScoreFromStefani);
	}

	@Test
	public void shouldUpdateEloScoreAfterJoseGivesLikeToCassia() {
		Person jose = new Person.Builder().name("José").eloScore(1200).build();
		Person cassia = new Person.Builder().name("Cássia").eloScore(1200).build();

		jose.giveLikeTo(cassia);
		cassia.receiveLikeFrom(jose);

		Integer obtainedEloScoreFromJose = jose.getEloScore();
		Integer expectedEloScoreFromJose = 1184;
		assertEquals(expectedEloScoreFromJose, obtainedEloScoreFromJose);

		Integer obtainedEloScoreFromCassia = cassia.getEloScore();
		Integer expectedEloScoreFromCassia = 1215;
		assertEquals(expectedEloScoreFromCassia, obtainedEloScoreFromCassia);
	}

	@Test
	public void shouldUpdateEloScoreAfterPaolaGivesLikeToEduardo() {
		Person paola = new Person.Builder().name("Paola").eloScore(1215).build();
		Person eduardo = new Person.Builder().name("Eduardo").eloScore(1184).build();

		paola.giveLikeTo(eduardo);
		eduardo.receiveLikeFrom(paola);

		Integer obtainedEloScoreFromPaola = paola.getEloScore();
		Integer expectedEloScoreFromPaola = 1198;
		assertEquals(expectedEloScoreFromPaola, obtainedEloScoreFromPaola);

		Integer obtainedEloScoreFromEduardo = eduardo.getEloScore();
		Integer expectedEloScoreFromEduardo = 1201;
		assertEquals(expectedEloScoreFromEduardo, obtainedEloScoreFromEduardo);
	}

	@Test
	public void shouldUpdateEloScoreAfterGabrielaGivesLikeToRoberto() {
		Person gabriela = new Person.Builder().name("Gabriela").eloScore(1200).build();
		Person roberto = new Person.Builder().name("Roberto").eloScore(1000).build();

		gabriela.giveLikeTo(roberto);
		roberto.receiveLikeFrom(gabriela);

		Integer obtainedEloScoreFromGabriela = gabriela.getEloScore();
		Integer expectedEloScoreFromGabriela = 1176;
		assertEquals(expectedEloScoreFromGabriela, obtainedEloScoreFromGabriela);

		Integer obtainedEloScoreFromRoberto = roberto.getEloScore();
		Integer expectedEloScoreFromRoberto = 1023;
		assertEquals(expectedEloScoreFromRoberto, obtainedEloScoreFromRoberto);
	}

	@Test
	public void shouldUpdateEloScoreAfterBrunaGivesLikeToAlex() {
		Person bruna = new Person.Builder().name("Bruna").eloScore(1023).build();
		Person alex = new Person.Builder().name("Alex").eloScore(1176).build();

		bruna.giveLikeTo(alex);
		alex.receiveLikeFrom(bruna);

		Integer obtainedEloScoreFromBruna = bruna.getEloScore();
		Integer expectedEloScoreFromBruna = 1014;
		assertEquals(expectedEloScoreFromBruna, obtainedEloScoreFromBruna);

		Integer obtainedEloScoreFromAlex = alex.getEloScore();
		Integer expectedEloScoreFromAlex = 1185;
		assertEquals(expectedEloScoreFromAlex, obtainedEloScoreFromAlex);
	}

}
