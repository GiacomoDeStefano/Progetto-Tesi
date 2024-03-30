package classiDMN;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import partita.Mazziere;

public class GiocatoreTest {

	void provideInput(String data) {
		ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}

	@Test
	public void giocataCorrettaTest() {
		Carta cartaDaGiocare = new Carta("K", "Cuori", 4);
		List<Carta> mano = new ArrayList<Carta>();
		mano.add(new Carta("A", "Cuori", 11));
		mano.add(new Carta("3", "Cuori", 10));
		mano.add(cartaDaGiocare);
		Giocatore giocatore = new Giocatore("GiocatoreTest", 10, mano);
		provideInput("3");
		Carta cartaGiocataTest = giocatore.giocata();

		assertThat(cartaGiocataTest).isEqualTo(cartaDaGiocare);
		assertEquals(2, giocatore.getMano().size());
		assertThat(giocatore.getMano()).doesNotContain(cartaGiocataTest);

	}


	@Test
	public void aggiungiCartaManoTest() {
		Giocatore giocatore = new Giocatore("GiocatoreTest", 10, new ArrayList<Carta>());
		ArrayDeque<Carta> mazzo = (new Mazziere()).mazzo();
		Carta cartaDaAggiungere = mazzo.getFirst();
		giocatore.aggiungiCartaMano(mazzo);
		assertEquals(1, giocatore.getMano().size());
		assertThat(giocatore.getMano()).contains(cartaDaAggiungere);
		assertThat(mazzo).doesNotContain(cartaDaAggiungere);
	}

}
