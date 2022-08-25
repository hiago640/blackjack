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
		return String.format("%s de %s", valor.getName(), naipe.getName());
	}
	
}
