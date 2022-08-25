package game;

public class Blackjack {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	private Baralho baralho;
	private Baralho descarte;

	private Dealer dealer;
	private Jogador jogador;

	private Placar placar;

	public void iniciar() {
		baralho = new Baralho();
		descarte = new Baralho();
		descarte.limparBaralho();

		jogador = new Jogador();
		dealer = new Dealer();

		baralho.embaralhar();

		placar = new Placar();
		iniciarRodada();
	}

	private void iniciarRodada() {
		pause();
		
		if (!placar.placarZerado()) {
			System.out.println(ANSI_CYAN + placar + ANSI_RESET);
			dealer.descartarMao(descarte);
			jogador.descartarMao(descarte);
		}

		dealer.pegarCarta(baralho);
		dealer.pegarCarta(baralho);

		jogador.pegarCarta(baralho);
		jogador.pegarCarta(baralho);

		dealer.mostrarPrimeiraMao();
		jogador.mostrarMao();

		if (dealer.hasBlackjack()) {
			dealer.mostrarMao();

			if (jogador.hasBlackjack()) {
				System.out.println(ANSI_BLUE + "Vocês dois possuem Blackjack - Push." + ANSI_RESET);
				placar.setPushes();
			} else {
				System.out.println(ANSI_RED + "Dealer possui Blackjack! Você perdeu." + ANSI_RESET);
				placar.setDerrotas();
			}
			iniciarRodada();
		}
		
		if(jogador.hasBlackjack()) {
			System.out.println(ANSI_GREEN + "Você possui Blackjack! Você venceu." + ANSI_RESET);
			placar.setVitorias();
			iniciarRodada();
		}
		
		jogador.tomarDecisao(baralho, descarte);
		
		if (jogador.getPontuacao() > 21) {
			System.out.println(ANSI_RED + "Você estourou!" + ANSI_RESET);
			placar.setDerrotas();
			iniciarRodada();
		}
		
		dealer.mostrarMao();
		
		while (dealer.getPontuacao() < 17)
			dealer.descerCarta(baralho, descarte);
		
		if(dealer.getPontuacao() > 21) {
			placar.setVitorias();
			iniciarRodada();
		}
		
		if(dealer.getPontuacao() > jogador.getPontuacao()) {
			System.out.println(ANSI_RED + "Você perdeu." + ANSI_RESET);
			placar.setDerrotas();
		} else if (dealer.getPontuacao() < jogador.getPontuacao()){
			System.out.println(ANSI_GREEN + "Você venceu." + ANSI_RESET);
			placar.setVitorias();
		} else {
			System.out.println(ANSI_BLUE + "Push." + ANSI_RESET);
			placar.setPushes();
		}
		iniciarRodada();
		
	}

	public static void pause(){
		try {
			Thread.sleep(1500);
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("\n\n\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
