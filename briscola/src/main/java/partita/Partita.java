package partita;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

import classiDMN.Carta;
import classiDMN.Giocatore;
import classiDMN.Turno;

public class Partita {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Nome Giocatore 1: ");
		String nomeGiocatore1 = in.nextLine();
		
		System.out.println("Nome Giocatore 2: ");
		String nomeGiocatore2 = in.nextLine();
		
		Mazziere mazziere = new Mazziere();
		Giocatore giocatore1 = new Giocatore(nomeGiocatore1,0, new ArrayList<Carta>());
		Giocatore giocatore2 = new Giocatore(nomeGiocatore2,0, new ArrayList<Carta>());
		
		ArrayDeque<Carta> mazzoMischiato = mazziere.mazzo();
		
		String semeBriscola = mazziere.mostraCartaDiBriscola(mazzoMischiato).getSeme();
        
		// InizioPartita -> distribuzione carte -> 3 carte per ciascun Giocatore
		mazziere.distribuzioneCarte(mazzoMischiato, 3, giocatore1, giocatore2);
		Modello modello = new Modello();
		
		while (!giocatore1.getMano().isEmpty() && !giocatore2.getMano().isEmpty()) {
			System.out.println("Briscola: " + semeBriscola);
			Carta carta1 = giocatore1.giocata();
			Carta carta2 = giocatore2.giocata();

			System.out.println(giocatore1.getNome() + " ha scelto la " + carta1.toString());
			System.out.println(giocatore2.getNome() + " ha scelto la " + carta2.toString());

			Turno turno = new Turno(carta1, carta2, semeBriscola);
			modello.esecuzioneModello(turno, giocatore1, giocatore2);
			Giocatore vincitore = modello.vincitoreTurno();

			System.out.println(vincitore.getNome() + " ha vinto");
			System.out.println("Punti di " + vincitore.getNome() + " : " + vincitore.getPunti());

			if (vincitore.getNome() != giocatore1.getNome()) {
				giocatore2 = giocatore1;
				giocatore1 = vincitore;
			} else {
				giocatore1 = vincitore;
			}

			if (!mazzoMischiato.isEmpty()) {
				giocatore1.aggiungiCartaMano(mazzoMischiato);
				giocatore2.aggiungiCartaMano(mazzoMischiato);
			}
			System.out.println("_____________________________________________");

		}
		System.out.println(modello.esitoPartita());
	}

}
