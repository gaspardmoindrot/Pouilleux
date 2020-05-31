package code;

public class Standard32Deck extends DeckOfCards
{
	public Standard32Deck(int nb_cards) {
		super(nb_cards);
		NB_CARDS = 32;
		int i = 0;
		int j = 1;
		int k = 1;
		Card[] Card = new Card[NB_CARDS];

		while (i < NB_CARDS) {
			while (j < 5) {
				k = 1;
				while (k < 14) {
					Card[i] = new Card(k, j);
					i++;
					if (k == 1) k = 7;
					else k++;
				}
				j++;
			}
		}
		this.mCard = Card;
	}
}
