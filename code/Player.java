package code;

public class Player
{
	private int num_player;
	private int end = 0;
	public DeckOfCards deck = new DeckOfCards(0);

	public Player(int num_player) {
		this.num_player = num_player;
	}

	public void verif_pairs() {
		int i = 0;
		int j;

		while (i < deck.NB_CARDS) {
			j = 0;
			while (j < deck.NB_CARDS) {
				if (j != i && deck.getter_card(j).get_rank() == deck.getter_card(i).get_rank()) {
					if (deck.getter_card(j).get_suit().equals("clover")) {
						if (deck.getter_card(i).get_suit().equals("spade")) {
							if (i < j) {
								System.out.println("From player " + (num_player+1) + " we remove the following cards :");
								deck.print_card(j);
								deck.removeIndex(j);
								deck.print_card(i);
								deck.removeIndex(i);
								i = 0;
								j = 0;
							}
							else {
								System.out.println("From player " + (num_player+1) + " we remove the following cards :");
								deck.print_card(i);
								deck.removeIndex(i);
								deck.print_card(j);
								deck.removeIndex(j);
								i = 0;
								j = 0;
							}
						}
					}
					else if (deck.getter_card(j).get_suit().equals("heart")) {
						if (deck.getter_card(i).get_suit().equals("diamond")) {
							if (i < j) {
								System.out.println("From player " + (num_player+1) + " we remove the following cards :");
								deck.print_card(j);
								deck.removeIndex(j);
								deck.print_card(i);
								deck.removeIndex(i);
								i = 0;
								j = 0;
							}
							else {
								System.out.println("From player " + (num_player+1) + " we remove the following cards :");
								deck.print_card(i);
								deck.removeIndex(i);
								deck.print_card(j);
								deck.removeIndex(j);
								i = 0;
								j = 0;
							}
						}
					}
					else if (deck.getter_card(j).get_suit().equals("spade")) {
						if (deck.getter_card(i).get_suit().equals("clover")) {
							if (i < j) {
								System.out.println("From player " + (num_player+1) + " we remove the following cards :");
								deck.print_card(j);
								deck.removeIndex(j);
								deck.print_card(i);
								deck.removeIndex(i);
								i = 0;
								j = 0;
							}
							else {
								System.out.println("From player " + (num_player+1) + " we remove the following cards :");
								deck.print_card(i);
								deck.removeIndex(i);
								deck.print_card(j);
								deck.removeIndex(j);
								i = 0;
								j = 0;
							}
						}
					}
					else if (deck.getter_card(j).get_suit().equals("diamond")) {
						if (deck.getter_card(i).get_suit().equals("heart")) {
							if (i < j) {
								System.out.println("From player " + (num_player+1) + " we remove the following cards :");
								deck.print_card(j);
								deck.removeIndex(j);
								deck.print_card(i);
								deck.removeIndex(i);
								i = 0;
								j = 0;
							}
							else {
								System.out.println("From player " + (num_player+1) + " we remove the following cards :");
								deck.print_card(i);
								deck.removeIndex(i);
								deck.print_card(j);
								deck.removeIndex(j);
								i = 0;
								j = 0;
							}
						}
					}
				}
				j++;
			}
			i++;
		}
	}

	public int getter_num() { return (this.num_player); }
}
