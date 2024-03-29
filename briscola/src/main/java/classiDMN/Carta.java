package classiDMN;

import java.util.Objects;

public class Carta {
	private String valore;
	private String seme;
	private int punti;

	public Carta(String valore, String seme, int punti) {
		super();
		this.valore = valore;
		this.seme = seme;
		this.punti = punti;
	}

	public String getValore() {
		return valore;
	}

	public String getSeme() {
		return seme;
	}

	public int getPunti() {
		return punti;
	}

	@Override
	public String toString() {
		return "Carta [valore=" + valore + ", seme=" + seme + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return Objects.equals(valore, other.valore) && punti == other.punti && Objects.equals(seme, other.seme);
	}
}
