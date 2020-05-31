package code;

import java.util.Random;

public class DeckOfCards
{
	public int NB_CARDS;
	protected Card[] mCard;

	public DeckOfCards(int nb_cards) {
		int i = 0;
		if (nb_cards < 0) nb_cards = 0;
		NB_CARDS = nb_cards;
		mCard = new Card[NB_CARDS];
		Random random = new Random();

		while (i < NB_CARDS) {
			mCard[i] = new Card(random.nextInt(13) + 1, random.nextInt(4) + 1);
			i++;
		}
	}

	public Card getter_card(int index) { return (mCard[index]); }

	public void print_card(int i) {
		if (mCard[i].get_rank() == 11)
			System.out.println("Jack" + " of " + mCard[i].get_suit());
		else if (mCard[i].get_rank() == 12)
			System.out.println("Queen" + " of " + mCard[i].get_suit());
		else if (mCard[i].get_rank() == 13)
			System.out.println("King" + " of " + mCard[i].get_suit());
		else
			System.out.println(mCard[i].get_rank() + " of " + mCard[i].get_suit());
	}

	public void print() {
		int i = 0;

		while (i < NB_CARDS) {
			if (mCard[i].get_rank() == 11)
				System.out.println("Jack" + " of " + mCard[i].get_suit());
			else if (mCard[i].get_rank() == 12)
				System.out.println("Queen" + " of " + mCard[i].get_suit());
			else if (mCard[i].get_rank() == 13)
				System.out.println("King" + " of " + mCard[i].get_suit());
			else
				System.out.println(mCard[i].get_rank() + " of " + mCard[i].get_suit());
			i++;
		}
	}

	public void cut() {
		Random random = new Random();
		int nb = random.nextInt(NB_CARDS - 1) + 1;
		Card[] card = new Card[NB_CARDS];
		int i = 0;

		while (nb < NB_CARDS) {
			card[i] = mCard[nb];
			nb++;
			i++;
		}
		nb = 0;
		while (i < NB_CARDS) {
			card[i] = mCard[nb];
			nb++;
			i++;
		}
		this.mCard = card;
	}

	public void shuffle() {
		Random random = new Random();
		Card card_flag = new Card(1, 1);
		int i = 0;
		int nb;

		while (i < NB_CARDS) {
			nb = random.nextInt(NB_CARDS);
			card_flag = mCard[i];
			mCard[i] = mCard[nb];
			mCard[nb] = card_flag;
			i++;
		}
	}

	public void reverse() {
		Card[] Card = new Card[NB_CARDS];
		int i = NB_CARDS - 1;
		int j = 0;

		while (j < NB_CARDS && i >= 0) {
			Card[i] = mCard[j];
			j++;
			i--;
		}
		this.mCard = Card;
	}

	public boolean isEmpty() {
		if (NB_CARDS <= 0)
			return (true);
		return (false);
	}

	public void addTop(Card c) {
		NB_CARDS += 1;
		Card[] Card = new Card[NB_CARDS];
		int i = 0;

		while (i < NB_CARDS - 1) {
			Card[i] = mCard[i];
			i++;
		}
		Card[i] = c;
		this.mCard = Card;
	}

	public void addBottom(Card c) {
		NB_CARDS += 1;
		Card[] Card = new Card[NB_CARDS];
		int i = 1;

		Card[0] = c;
		while (i < NB_CARDS) {
			Card[i] = mCard[i - 1];
			i++;
		}
		this.mCard = Card;
	}

	public void addIndex(Card c, int index) {
		NB_CARDS += 1;
		Card[] Card = new Card[NB_CARDS];
		int i = 0;
		int j = 0;

		while (i < NB_CARDS) {
			if (i == index) {
				Card[i] = c;
				i++;
			}
			else {
				if (j < NB_CARDS - 1)
					Card[i] = mCard[j];
				else
					Card[i] = c;
				i++;
				j++;
			}
		}
		this.mCard = Card;
	}

	public Card removeTop() {
		Card c;

		if (NB_CARDS > 0)
		{
			c = mCard[NB_CARDS - 1];
			NB_CARDS -= 1;
			Card[] Card = new Card[NB_CARDS];
			int i = 0;

			while (i < NB_CARDS) {
				Card[i] = mCard[i];
				i++;
			}
			this.mCard = Card;
			return (c);
		}
		c = new Card(1, 1);
		return (c);
	}

	public Card removeBottom() {
		Card c;

		if (NB_CARDS > 0)
		{
			NB_CARDS -= 1;
			Card[] Card = new Card[NB_CARDS];
			int i = 0;

			c = mCard[0];
			while (i < NB_CARDS) {
				Card[i] = mCard[i + 1];
				i++;
			}
			this.mCard = Card;
			return (c);
		}
		c = new Card(1, 1);
		return (c);
	}

	public Card removeIndex(int index) {
		Card c;

		if (NB_CARDS > 0)
		{
			NB_CARDS -= 1;
			Card[] Card = new Card[NB_CARDS];
			int i = 0;
			int j = 0;
			c = mCard[index];

			while (i < NB_CARDS) {
				if (j == index) {
					j++;
				}
				else {
					Card[i] = mCard[j];
					i++;
					j++;
				}
			}
			this.mCard = Card;
			return (c);
		}
		c = new Card(1, 1);
		return (c);
	}
}
