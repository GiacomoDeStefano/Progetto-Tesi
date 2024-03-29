package classiDMN;

import java.util.ArrayDeque;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Giocatore {
	private String nome;
	private int punti;
	private List<Carta> mano;

	public Giocatore(String nome, int punti, List<Carta> mano) {
		super();
		this.nome = nome;
		this.punti = punti;
		this.mano = mano;
	}

	public String getNome() {
		return nome;
	}

	public int getPunti() {
		return punti;
	}

	public List<Carta> getMano() {
		return mano;
	}

	public void aggiungiCartaMano(ArrayDeque<Carta> mazzo) {
		mano.add(mazzo.pop());
	}

	public Carta giocata() {
		boolean ripeti_scelta = true;
		Carta cartaScelta = null;
		@SuppressWarnings("resource")
		Scanner scelta = new Scanner(System.in);
		while (ripeti_scelta) {
			try {
				System.out.println(this.nome + " digita un numero tra 1 e "+ this.mano.size() +" per scegliere la carta dalla mano");
				System.out.println(mano.toString());
				int sceltaGiocatore1 = scelta.nextInt();
				cartaScelta = scegliCarta((sceltaGiocatore1 - 1));
				ripeti_scelta = false;
			} catch (IndexOutOfBoundsException | InputMismatchException e) {
				System.out.println("Scelta non corretta: scegliere un numero tra 1 e " + this.mano.size());
				scelta.nextLine();
			}
		}

		return cartaScelta;

	}

	Carta scegliCarta(int indexCarta) {
		Carta c = mano.get(indexCarta);
		mano.remove(indexCarta);
		return c;
	}

}
