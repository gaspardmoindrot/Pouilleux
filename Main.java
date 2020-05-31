import code.*;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Standard32Deck deck;
		Player[] player;
		Scanner sc = new Scanner(System.in);
		int i;
		int j;
		int type;
		Card c;
		int pioche;

		System.out.print("The game will start soon, you are the player number 1, if you want to know the rules type 1 (otherwise 0) : ");
		type = sc.nextInt();
		if (type == 1)
			System.out.println("\nPouilleux - rules\n\nTo play this game, we need to have a 32 game of cards and 4 players.\nBefore distributing the game of cards to the players, we take off randomly one of the card of the packet. This unknown card is called « le pouilleux ».\nAfterwards, all cards are fairly distributed to the 4 players. \nOnce every player has its cards, they can look at them. The goal is now for every player to form the maximum of pairs, for example two black cards with the same value (indeed it has to be same colors and same numbers to form a pair). Every time a player has a pair in its game, it can put them on the table. Indeed the goal of the game is too ged rid off your cards.  \nOnce the pairs are on the table, the first player allows the second player to choose randomly a card in its game. Then the third player can choose a card in the second player’s game, the fourth player picks a card to the third player, and the first to the fourth. If a player pick a card allowing him to form a pair, it can put it on the table immediately. This game continues as long as all pairs will not be put on the table. In fact, the winner is the player that put first all its cards on the table. \nAmong all the cards there will be one card without a pair (la pouilleux). The loser of this game is the one that finishes the game with this card in hand.\n\n");
		while (true) {
			deck = new Standard32Deck(0);
			player = new Player[4];
			i = 0;
			j = 0;
			deck.shuffle();
			deck.removeTop();
			System.out.println("We will now remove all the initial pairs : \n");
			while (i < 4) {
				player[i] = new Player(i);
				j = 0;
				while (j < 8 && !deck.isEmpty()) {
					c = deck.removeTop();
					player[i].deck.addTop(c);
					j++;
				}
				player[i].verif_pairs();
				i++;
			}
			while (player.length > 1) {
				i = 0;
				while (i < player.length && player.length > 1) {
					System.out.println("\nHere is your cards (player number " + (i + 1) + ") : \n");
					player[i].deck.print();
					if (i == 0)
						pioche = player.length - 1;
					else
						pioche = i - 1;
					System.out.println("\nThe player you want to draw cards from has " + player[pioche].deck.NB_CARDS + " cards");
					System.out.print("Type a number from 1 to " + player[pioche].deck.NB_CARDS + " : ");
					type = sc.nextInt();
					if (type > player[pioche].deck.NB_CARDS)
						type = player[pioche].deck.NB_CARDS;
					else if (type < 1)
						type = 1;
					c = player[pioche].deck.removeIndex(type - 1);
					System.out.print("You have taken this card : ");
					c.print();
					player[i].deck.addBottom(c);
					player[i].verif_pairs();
					if (player[i].deck.NB_CARDS <= 0) {
						j = 0;
						Player[] player_f = new Player[player.length - 1];
						while (j < i) {
							player_f[j] = player[j];
							j++;
						}
						j++;
						while (j < player.length) {
							player_f[j - 1] = player[j];
							j++;
						}
						player = player_f;
					}
					else if (player[pioche].deck.NB_CARDS <= 0) {
						j = 0;
						Player[] player_f = new Player[player.length - 1];
                                                while (j < pioche) {
                                                        player_f[j] = player[j];
                                                        j++;
                                                }
                                                j++;
                                                while (j < player.length) {
                                                        player_f[j - 1] = player[j];
                                                        j++;
                                                }
                                                player = player_f;
					}
					i++;
				}
			}
			System.out.println("The player number " + (player[0].getter_num() + 1) + " has lost !");
			System.out.print("Type 1 if you want to continue and 0 to stop : ");
			type = sc.nextInt();
			if (type == 0)
				break;
		}
	}
}
