package org.hmis.cardGame;

import java.util.Scanner;

public class JuegoBaraja {

	public static void main(String[] args) {

		// Jugador 1
		int dineroJugador = 10;
		int apuesta;
		// Jugador Banca

		System.out.println("  ========================================================");
		System.out.println("          BIENVENIDO AL JUEGO DE LA CARTA MÁS ALTA        ");
		System.out.println("  ========================================================");

		Scanner entrada = new Scanner(System.in);
		Deck baraja = new Deck();
		baraja.shuffle(); // Barajamos las cartas

		System.out.println("\n   || Usted dispone de " + dineroJugador + " € para apostar en la partida ||");
		System.out.println(" REGLAS - El juego termina si se queda sin dinero o apuesta 0 €\n");


		do {
			System.out.print(" > ¿ Cuánto desea apostar ? ");
			
			try {
				apuesta = Integer.valueOf(entrada.next());
			}catch(NumberFormatException e){
				apuesta = -1;
			}
			
			if (apuesta == 0)
				break;
			
			if (apuesta > dineroJugador || apuesta < 0) {
					System.out.print(" > Usted dispone de " + dineroJugador + " €, por favor apueste una cantidad válida: ");
					continue;
			}
			
			System.out.println("\nRobando una carta de la baraja...");
			Card cartaJugador = baraja.dealCard();
			System.out.println("   -La carta del jugador es: " + cartaJugador.toString());
			Card cartaBanca = baraja.dealCard();
			System.out.println("   -La carta de la banca es: " + cartaBanca.toString());

			if (cartaJugador.getValue() < cartaBanca.getValue()) {
				dineroJugador -= apuesta;
				System.out.println("¡QUE MALA SUERTE HAS PERDIDO!, ahora dispone de " + dineroJugador + " €.\n");
			} else if (cartaJugador.getValue() > cartaBanca.getValue()) {
				dineroJugador += apuesta;
				System.out.println("ENHORABUENA HAS GANADO, ahora dispone de " + dineroJugador + " €.\n");
			} else {
				System.out.println("HABEIS EMPATADO, dispone de " + dineroJugador + " €.\n");
			}

		} while (dineroJugador != 0);

		System.out.println(
				"\nEl juego ha terminado, el dinero final obtenido es: " + dineroJugador + " €, gracias por jugar.");
	}

}
