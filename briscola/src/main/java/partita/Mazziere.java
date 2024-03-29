package partita;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classiDMN.Carta;
import classiDMN.Giocatore;

public class Mazziere {

	List<Carta> preparazioneMazzo() {
		String[] Seme = { "Cuori", "Picche", "Fiori", "Quadri" };
		List<String> valore = List.of("2", "4", "5", "6", "7");
		List<Carta> mazzo = new ArrayList<Carta>();
		for (String seme : Seme) {
			for (String ent : valore) {
				mazzo.add(new Carta(ent, seme, 0));
			}
			mazzo.add(new Carta("J", seme, 2));
			mazzo.add(new Carta("Q", seme, 3));
			mazzo.add(new Carta("K", seme, 4));
			mazzo.add(new Carta("3", seme, 10));
			mazzo.add(new Carta("A", seme, 11));
		}
		return mazzo;
	}
      
	public ArrayDeque<Carta> mazzo(){
		List<Carta>mazzo=this.preparazioneMazzo();
		Collections.shuffle(mazzo);
		return new ArrayDeque<Carta>(mazzo);
	}

	public void distribuzioneCarte(ArrayDeque<Carta> mazzo, int numeroDiCarte, Giocatore g1, Giocatore g2) {
		for (int i = 0; i < numeroDiCarte; i++) {
			g1.aggiungiCartaMano(mazzo);
			g2.aggiungiCartaMano(mazzo);
		}
	}
	public Carta mostraCartaDiBriscola(ArrayDeque<Carta> mazzo) {
		Carta cartaBriscola=mazzo.pop();
		mazzo.addLast(cartaBriscola);
		return cartaBriscola;
	}

}
