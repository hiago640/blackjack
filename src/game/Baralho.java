package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baralho {

	private List<Carta> baralho;
	
	public List<Carta> getBaralho() {
		return baralho;
	}

	public Baralho() {
		baralho = new ArrayList<>();

		for (Naipe naipe : Naipe.values())
			for (Valor valor : Valor.values())
				baralho.add(new Carta(valor, naipe));
	}

	public Baralho(Baralho baralho) {
		Collections.copy(this.baralho, baralho.getCartas());
	}

	public void embaralhar() {
		Collections.shuffle(baralho, new Random());
		Collections.shuffle(baralho, new Random());
	}

	public Carta pegarCarta() {
		return baralho.remove(0);
	}

	public void limparBaralho() {
		baralho.clear();
	}

	public int cartasRestantes() {
		return baralho.size();
	}

	public List<Carta> getCartas() {
		return baralho;
	}
	
	public boolean isEmpty() {
		return baralho.isEmpty();
	}
	
	public void recarregarBaralhoFromDescarte(Baralho descarte) {
		Collections.copy(this.baralho, descarte.getCartas());
		this.embaralhar();
		descarte.limparBaralho();
		System.out.println("Criando novo baralho a partir da pilha de descartes.");
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		baralho.forEach(carta -> sb.append(carta + "\n"));
		return sb.toString();
	}
}
