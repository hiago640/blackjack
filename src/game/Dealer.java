package game;

public class Dealer extends Pessoa {

	public Dealer() {
		nome = "Dealer";
	}
	
	public void mostrarPrimeiraMao() {
		System.out.println("A mão do Dealer se parece com isso: ");
		System.out.println(mao.getCarta(0));
		System.out.println("A segunda carta está virada para baixo\n\n");
	}
}
