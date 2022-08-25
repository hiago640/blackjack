package game;

public class Carta {

	private Valor valor;
	private Naipe naipe;

	public Carta(Valor valor, Naipe naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}

	@Override
	public String toString() {
		return String.format("%s de %s (%s)", valor.getName(), naipe.getName(), valor.rankValue);
	}

	public Valor getValor() {
		return valor;
	}
}
