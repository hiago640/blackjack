package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		List<Carta> cartas = new ArrayList<>();
		
		for(Naipe naipe : Naipe.values()) {
			for(Valor valor : Valor.values())
				cartas.add(new Carta(valor, naipe));
		}
		
		cartas.forEach(e -> System.out.println(e));
		
		System.out.println("\n\n\n\nembaralhando....\n\n\n\n");
		Collections.shuffle(cartas, new Random());
		cartas.forEach(e -> System.out.println(e));
	}
	
}
