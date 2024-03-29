package classiDMN;

public class Turno {
	private Carta carta1;
	private Carta carta2;
	private String briscola;

	public Turno(Carta carta1, Carta carta2, String briscola) {
		super();
		this.carta1 = carta1;
		this.carta2 = carta2;
		this.briscola = briscola;
	}

	public Carta getCarta1() {
		return carta1;
	}

	public Carta getCarta2() {
		return carta2;
	}

	public String getBriscola() {
		return briscola;
	}
}
