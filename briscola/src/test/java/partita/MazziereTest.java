package partita;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;


import classiDMN.Carta;
import classiDMN.Giocatore;

public class MazziereTest {



	@Test
	public void preparazioneMazzoTest() {
		Mazziere mazziere = new Mazziere();
		List<Carta> mazzo = mazziere.preparazioneMazzo();
		List<String> valore = List.of("2", "4", "5", "6", "7", "J", "Q", "K", "3", "A");
		assertEquals(40, mazzo.size());
		assertEquals(40,mazzo.stream().distinct().count());
		for (String nom : valore) {
			assertEquals(4, mazzo.stream().filter(c -> c.getValore() == nom).distinct().collect(Collectors.toList()).size());
		}
	}
	
	@Test
	public void mazzoTest() {
		Mazziere mazziere = new Mazziere();
		List<Carta> mazzo = mazziere.preparazioneMazzo();;
		ArrayDeque<Carta>mazzoMischiato =mazziere.mazzo();
		assertEquals(40, mazzoMischiato.size());
	    assertEquals(40,mazzoMischiato.stream().distinct().count());
		assertThat(mazzoMischiato).containsExactlyInAnyOrderElementsOf(mazzo);
	}


	@Test
	public void distribuzioneCarteTest() {
		Mazziere mazziere = new Mazziere();
		Giocatore g1 = new Giocatore("Giocatore 1", 10, new ArrayList<Carta>());
		Giocatore g2 = new Giocatore("Giocatore 2", 30, new ArrayList<Carta>());
		ArrayDeque<Carta> mazzo = mazziere.mazzo();
		mazziere.distribuzioneCarte(mazzo, 3, g1, g2);
		assertEquals(3, g1.getMano().size());
		assertEquals(3, g2.getMano().size());
		assertThat(g1.getMano()).doesNotContainAnyElementsOf(g2.getMano());
	}

	@Test
	public void mostraCartaDiBriscolaTest() {
		Mazziere mazziere = new Mazziere();
		ArrayDeque<Carta> mazzo = mazziere.mazzo();
		Carta briscolaAttesa = mazzo.getFirst();
		Carta briscolaTest = mazziere.mostraCartaDiBriscola(mazzo);
		assertThat(briscolaAttesa).isEqualTo(briscolaTest);
		assertThat(briscolaTest).isEqualTo(mazzo.getLast());
	}
	
	

}
