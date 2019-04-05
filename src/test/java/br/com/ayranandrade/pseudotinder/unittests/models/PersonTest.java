package br.com.ayranandrade.pseudotinder.unittests.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.Person;

public class PersonTest extends AbstractSpringBootTest {

	@Test
	public void shouldUpdateEloScoreAfterGabrielGivesLikeToAna() {
		Person gabriel = new Person();
		gabriel.setName("Gabriel");
		gabriel.setEloScore(2500);

		Person ana = new Person();
		ana.setName("Ana");
		ana.setEloScore(2200);

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
		Person fabio = new Person();
		fabio.setName("Fabio");
		fabio.setEloScore(2473);

		Person juliana = new Person();
		juliana.setName("Juliana");
		juliana.setEloScore(2226);

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
		Person antonio = new Person();
		antonio.setName("Antônio");
		antonio.setEloScore(2400);

		Person maria = new Person();
		maria.setName("Maria");
		maria.setEloScore(2000);

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
		Person andre = new Person();
		andre.setName("André");
		andre.setEloScore(2371);

		Person stefani = new Person();
		stefani.setName("Stefani");
		stefani.setEloScore(2029);

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
		Person jose = new Person();
		jose.setName("José");
		jose.setEloScore(1200);

		Person cassia = new Person();
		cassia.setName("Cássia");
		cassia.setEloScore(1200);

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
		Person paola = new Person();
		paola.setName("Paola");
		paola.setEloScore(1215);

		Person eduardo = new Person();
		eduardo.setName("Eduardo");
		eduardo.setEloScore(1184);

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
		Person gabriela = new Person();
		gabriela.setName("Gabriela");
		gabriela.setEloScore(1200);

		Person roberto = new Person();
		roberto.setName("Roberto");
		roberto.setEloScore(1000);

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
		Person bruna = new Person();
		bruna.setName("Bruna");
		bruna.setEloScore(1023);

		Person alex = new Person();
		alex.setName("Alex");
		alex.setEloScore(1176);

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
