package game;

import java.util.ArrayList;
import java.util.List;

public class Mao {

	private List<Carta> mao;
	
	public Mao() {
		mao = new ArrayList<>();
	}
	
	public void pegarCartaDoBaralho(Baralho baralho) {
		 mao.add(baralho.pegarCarta());
	}
	
	public void descartarMao(Baralho descarte) {
		descarte.getBaralho().addAll(mao);
		mao.clear();
	}
	
	public int getPontuacao() {

		int pontuacao = 0;
		int qtdAs = 0;

		for (Carta carta : mao) {
			pontuacao += carta.getValor().rankValue;

			if (carta.getValor() == Valor.AS)
				qtdAs++;
		}

		// situacao de quando tiver mais de um ÁS na mão do jogador 
		// e a pontuacao ser maior que 21
		// tratar a somatoria de pontuacao
		while (pontuacao > 21 && qtdAs > 0) {
			pontuacao -= 10;
			qtdAs--;
		}

		return pontuacao;
	}
	
	public Carta getCarta(int index) {
		return mao.get(index);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		mao.forEach(carta -> sb.append(carta + " - "));
		return sb.toString();
	}
}
