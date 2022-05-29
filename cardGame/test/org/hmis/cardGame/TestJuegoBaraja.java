package org.hmis.cardGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestJuegoBaraja {

	@Test
	void testRobarCarta() {
		Deck baraja = new Deck();
		int cartasIniciales = baraja.cardsLeft();
		baraja.dealCard();
		int cartasTrasRobar = baraja.cardsLeft();
		assertNotEquals(cartasIniciales, cartasTrasRobar);
	}
	
	@Test
	void testShuffleBaraja() {
		Deck baraja = new Deck();
		String barajaInicial = baraja.toString();
		baraja.shuffle();
		String barajaTrasMezclar = baraja.toString();
		assertNotEquals(barajaInicial, barajaTrasMezclar);
	}
	
	@Test
	void testNotNullCard() {
		Deck baraja = new Deck();
		Card carta = baraja.dealCard();
		int suit = carta.getSuit();
		int value= carta.getValue();
		assertNotNull(suit);
		assertNotNull(value);
	}
}
