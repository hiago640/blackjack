package game;

public abstract class Pessoa {

	protected Mao mao;
	protected String nome;

	protected Pessoa() {
		this.mao = new Mao();
		this.nome = "";
	}

	protected void descerCarta(Baralho baralho, Baralho descarte) {

		if (baralho.isEmpty())
			baralho.recarregarBaralhoFromDescarte(descarte);

		mao.pegarCartaDoBaralho(baralho);
		System.out.println(String.format("%s pegou a carta.", nome));
		mostrarMao();
	}
	
	protected void descartarMao(Baralho descarte) {
		mao.descartarMao(descarte);
	}
	
	protected void pegarCarta(Baralho baralho) {
		mao.pegarCartaDoBaralho(baralho);
	}

	protected int getPontuacao() {
		return mao.getPontuacao();
	}

	public void mostrarMao() {
		System.out.println(String.format("Mão de [%s]", nome));
		System.out.println(String.format("%s. Valor total até o momento %d", mao, mao.getPontuacao()));
	}

	public boolean hasBlackjack() {
		return (mao.getPontuacao() == 21);
	}
}
