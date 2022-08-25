package game;

import java.util.Scanner;

public class Jogador extends Pessoa {
	
	 Scanner input = new Scanner(System.in);
	 
	public Jogador() {
		nome = "Jogador";
	}
	
	public void tomarDecisao(Baralho baralho, Baralho descarte) {
		showMenu();
		int decisao = input.nextInt();

		if (decisao == 1) {
			descerCarta(baralho, descarte);
			if (mao.getPontuacao() < 20)
				tomarDecisao(baralho, descarte);
		} else {
			System.out.println("Você terminou sua jogada.");
		}
	}

	private void showMenu() {
		StringBuilder sbMessage = new StringBuilder();
		sbMessage.append("Escolha uma das opções abaixo:\n");
		sbMessage.append("1 - Descer mais uma carta.\n");
		sbMessage.append("2 - Terminar jogada.\n");
		sbMessage.append("> ");
		System.out.print(sbMessage.toString());
	}
}
