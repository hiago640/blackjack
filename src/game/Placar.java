package game;

public class Placar {

	private int vitorias;
	private int derrotas;
	private int pushes;

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias() {
		this.vitorias++;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas() {
		this.derrotas++;
	}

	public int getPushes() {
		return pushes;
	}

	public void setPushes() {
		this.pushes++;
	}
	
	public void zerarPlacar() {
		vitorias = 0;
		derrotas = 0;
		pushes = 0;
	}
	
	public boolean placarZerado() {
		return vitorias == 0 && derrotas == 0 && pushes == 0;
	}

	@Override
	public String toString() {
		String msg = "Placar Atualmente: Vitorias: %s Derrotas: %s Pushes: %s\n";
		return String.format(msg, vitorias, derrotas, pushes);
	}

}
