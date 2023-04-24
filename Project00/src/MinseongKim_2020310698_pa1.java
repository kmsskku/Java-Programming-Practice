
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MinseongKim_2020310698_pa1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int seed = Integer.parseInt(args[0]);

		
		Random random = new Random();
		int is_hit = (int) (random.nextInt(2));

		Deck deck = new Deck();
		deck.shuffle(seed);

		House house = new House();
		player p1 = new player();

		computer[] comp = new computer[Integer.parseInt(args[1]) - 1];

		for (int er = 0; er < comp.length; er++) {
			comp[er] = new computer();
		}

		house.init(deck.dealCard());
		house.init(deck.dealCard());
		house.calsum();
		p1.init(deck.dealCard());
		p1.init(deck.dealCard());
		p1.calsum();

		for (int et = 0; et < comp.length; et++) {
			comp[et].init(deck.dealCard());
			comp[et].init(deck.dealCard());
			comp[et].calsum();
		}

		System.out.println("House: HIDDEN, " + house.hand.get(1).value + house.hand.get(1).suit);
		p1.printDeck();

		for (int ey = 0; ey < comp.length; ey++) {
			System.out.print("Player" + (ey + 2) + ": ");
			comp[ey].printDeck();
		}
		System.out.println();

		if (house.sum == 21) {
			System.out.println("--- Game Result ---");
			house.printDeck();
			System.out.print("[Lose] ");
			p1.printDeck();

			for (int e = 0; e < comp.length; e++) {
				System.out.print("[Lose] ");
				comp[e].printDeck();
			}
		} else {

			System.out.println("--- Player1 turn ---");
			p1.printDeck();
			int i = 0;
			while (i != -1) {
				switch (scan.next()) {
				case "Hit":
					p1.hit(deck.dealCard());
					p1.printDeck();
					if (p1.sum > 21) {
						i = -1;
					}
					break;
				case "Stand":
					i = -1;
					p1.printDeck();
					break;
				default:
					System.out.println("It is invalid input!");
					break;
				}
			}
			System.out.println();

			int[] flag = new int[comp.length];

			for (int eu = 0; eu < comp.length; eu++) {
				flag[eu] = 0;
			}

			for (int ei = 0; ei < comp.length; ei++) {
				System.out.println("--- Player" + (ei + 2) + " turn ---");
				System.out.print("Player" + (ei + 2) + ": ");
				comp[ei].printDeck();

				while (flag[ei] != -1) {
					if (comp[ei].sum <= 21) {
						if (comp[ei].sum < 14) {
							System.out.println("Hit");
							comp[ei].hit(deck.dealCard());
							System.out.print("Player" + (ei + 2) + ": ");
							comp[ei].printDeck();
						} else if (comp[ei].sum > 17) {
							System.out.println("Stand");
							System.out.print("Player" + (ei + 2) + ": ");
							comp[ei].printDeck();
							flag[ei] = -1;
						} else {
							if (is_hit == 1) {
								System.out.println("Hit");
								comp[ei].hit(deck.dealCard());
								System.out.print("Player" + (ei + 2) + ": ");
								comp[ei].printDeck();
							} else {
								System.out.println("Stand");
								System.out.print("Player" + (ei + 2) + ": ");
								comp[ei].printDeck();
								flag[ei] = -1;
							}
						}
					} else
						flag[ei] = -1;
				}
				System.out.println();
			}

			System.out.println("--- House turn ---");
			house.printDeck();
			int hflag = 0;
			while (hflag != -1) {
				if (house.sum <= 21) {
					if (house.sum < 14) {
						System.out.println("Hit");
						house.hit(deck.dealCard());
						house.printDeck();
					} else if (house.sum > 17) {
						System.out.println("Stand");
						house.printDeck();
						hflag = -1;
					} else {
						if (is_hit == 1) {
							System.out.println("Hit");
							house.hit(deck.dealCard());
							house.printDeck();
						} else {
							System.out.println("Stand");
							house.printDeck();
							hflag = -1;
						}
					}
				} else
					hflag = -1;
			}

			int pres;
			int[] res = new int[Integer.parseInt(args[1])];

			if (house.sum <= 21) {
				if (p1.sum > house.sum && p1.sum <= 21)
					pres = 1;
				else if (p1.sum < house.sum || p1.sum > 21)
					pres = -1;
				else
					pres = 0;

				for (int eo = 0; eo < comp.length; eo++) {
					if (comp[eo].sum > house.sum && comp[eo].sum <= 21)
						res[eo] = 1;
					else if (comp[eo].sum < house.sum || comp[eo].sum > 21)
						res[eo] = -1;
					else
						res[eo] = 0;
				}
			} else {
				if (p1.sum <= 21)
					pres = 1;
				else
					pres = -1;

				for (int we = 0; we < comp.length; we++) {
					if (comp[we].sum <= 21)
						res[we] = 1;
					else
						res[we] = -1;
				}
			}

			System.out.println();
			System.out.println("--- Game Result ---");
			house.printDeck();
			if (pres == 1) {
				System.out.print("[Win] ");
				p1.printDeck();
			} else if (pres == -1) {
				System.out.print("[Lose] ");
				p1.printDeck();
			} else {
				System.out.print("[Draw] ");
				p1.printDeck();
			}

			for (int ep = 0; ep < comp.length; ep++) {
				if (res[ep] == 1) {
					System.out.print("[Win] Player" + (ep + 2) + ": ");
					comp[ep].printDeck();
				} else if (res[ep] == -1) {
					System.out.print("[Lose] Player" + (ep + 2) + ": ");
					comp[ep].printDeck();
				} else {
					System.out.print("[Draw] Player" + (ep + 2) + ": ");
					comp[ep].printDeck();
				}
			}

		}
		scan.close();
	}
}

class Card {
	String value;
	String suit;

	public Card() {
	}

	public Card(int theValue, int theSuit) {
		if (theValue == 1)
			value = "A";
		else if (theValue == 11)
			value = "J";
		else if (theValue == 12)
			value = "Q";
		else if (theValue == 13)
			value = "K";
		else
			value = String.valueOf(theValue);

		if (theSuit == 1)
			suit = "d";
		else if (theSuit == 2)
			suit = "h";
		else if (theSuit == 3)
			suit = "c";
		else if (theSuit == 4)
			suit = "s";

	}
}

class Deck {
	private Card[] deck;
	private int cardUsed;

	public Deck() {
		deck = new Card[52];
		for (int i = 0; i < 52; i++) {
			if (i < 13)
				deck[i] = new Card(i + 1, 1);
			else if (i >= 13 && i < 26)
				deck[i] = new Card(i - 12, 2);
			else if (i >= 26 && i < 39)
				deck[i] = new Card(i - 25, 3);
			else
				deck[i] = new Card(i - 38, 4);
		}
	}

	public Card[] getDeck() {
		return deck;
	}

	public int getCardUsed() {
		return cardUsed;
	}

	public void shuffle(int seed) {
		Random random = new Random(seed);

		for (int i = deck.length - 1; i > 0; i--) {
			int rand = (int) (random.nextInt(i + 1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		cardUsed = 0;
	}

	public Card dealCard() {
		if (cardUsed == deck.length) {
			throw new IllegalStateException("No cards are left in deck.");

		}
		cardUsed++;
		return deck[cardUsed - 1];
	}

}

class Hand {
	ArrayList<Card> hand = new ArrayList<Card>();
}

class computer extends Hand {

	int sum = 0;

	public void printDeck() {
		if (sum > 21) {
			for (int i = 0; i < hand.size(); i++) {
				System.out.print(hand.get(i).value + hand.get(i).suit + " ");
			}
			System.out.println(" (" + sum + ") - Bust!");
		} else {
			for (int i = 0; i < hand.size(); i++) {
				System.out.print(hand.get(i).value + hand.get(i).suit + " ");
			}
			System.out.println("(" + sum + ")");
		}
	}

	public void init(Card c) {
		hand.add(hand.size(), c);
	}

	public void hit(Card c) {
		sum = 0;
		hand.add(hand.size(), c);
		calsum();
	}

	public void calsum() {
		int calf = 0;
		int cnt = 0;

		for (int q = 0; q < hand.size(); q++) {
			if (hand.get(q).value.equals("A")) {
				calf = 1;
				cnt++;
			}
		}

		if (calf == 0) {
			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).value.equals("J") || hand.get(i).value.equals("Q") || hand.get(i).value.equals("K"))
					sum += 10;
				else
					sum += Integer.valueOf(hand.get(i).value);
			}
		} else {
			int s = 0;

			for (int y = 0; y < hand.size(); y++) {
				if (hand.get(y).value.equals("J") || hand.get(y).value.equals("Q") || hand.get(y).value.equals("K"))
					s += 10;
				else if (hand.get(y).value.equals("A"))
					s += 11;
				else
					s += Integer.valueOf(hand.get(y).value);
			}

			while (s > 21 && cnt > 0) {
				s -= 10;
				cnt--;
			}
			sum = s;
		}
	}
}

class player extends Hand {

	int sum = 0;

	public void printDeck() {
		if (sum > 21) {
			System.out.print("Player1: ");
			for (int i = 0; i < hand.size(); i++) {
				System.out.print(hand.get(i).value + hand.get(i).suit + " ");
			}
			System.out.println(" (" + sum + ") - Bust!");
		} else {
			System.out.print("Player1: ");
			for (int i = 0; i < hand.size(); i++) {
				System.out.print(hand.get(i).value + hand.get(i).suit + " ");
			}
			System.out.println("(" + sum + ")");
		}
	}

	public void init(Card c) {
		hand.add(hand.size(), c);
	}

	public void hit(Card c) {
		sum = 0;
		hand.add(hand.size(), c);
		calsum();
	}

	public void calsum() {
		int calf = 0;
		int cnt = 0;

		for (int q = 0; q < hand.size(); q++) {
			if (hand.get(q).value.equals("A")) {
				calf = 1;
				cnt++;
			}
		}

		if (calf == 0) {
			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).value.equals("J") || hand.get(i).value.equals("Q") || hand.get(i).value.equals("K"))
					sum += 10;
				else
					sum += Integer.valueOf(hand.get(i).value);
			}
		} else {
			int s = 0;

			for (int y = 0; y < hand.size(); y++) {
				if (hand.get(y).value.equals("J") || hand.get(y).value.equals("Q") || hand.get(y).value.equals("K"))
					s += 10;
				else if (hand.get(y).value.equals("A"))
					s += 11;
				else
					s += Integer.valueOf(hand.get(y).value);
			}

			while (s > 21 && cnt > 0) {
				s -= 10;
				cnt--;
			}
			sum = s;
		}
	}
}

class House extends Hand {

	int sum = 0;

	public void printDeck() {
		sum = 0;
		calsum();
		if (sum > 21) {
			System.out.print("House: ");
			for (int i = 0; i < hand.size(); i++) {
				System.out.print(hand.get(i).value + hand.get(i).suit + " ");
			}
			System.out.println(" (" + sum + ") - Bust!");
		} else {
			System.out.print("House: ");
			for (int i = 0; i < hand.size(); i++) {
				System.out.print(hand.get(i).value + hand.get(i).suit + " ");
			}
			System.out.println("(" + sum + ")");
		}
	}

	public void init(Card c) {
		hand.add(hand.size(), c);
	}

	public void hit(Card c) {
		sum = 0;
		hand.add(hand.size(), c);
		calsum();
	}

	public void calsum() {
		int calf = 0;
		int cnt = 0;

		for (int q = 0; q < hand.size(); q++) {
			if (hand.get(q).value.equals("A")) {
				calf = 1;
				cnt++;
			}
		}

		if (calf == 0) {
			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).value.equals("J") || hand.get(i).value.equals("Q") || hand.get(i).value.equals("K"))
					sum += 10;
				else
					sum += Integer.valueOf(hand.get(i).value);
			}
		} else {
			int s = 0;

			for (int y = 0; y < hand.size(); y++) {
				if (hand.get(y).value.equals("J") || hand.get(y).value.equals("Q") || hand.get(y).value.equals("K"))
					s += 10;
				else if (hand.get(y).value.equals("A"))
					s += 11;
				else
					s += Integer.valueOf(hand.get(y).value);
			}

			while (s > 21 && cnt > 0) {
				s -= 10;
				cnt--;
			}
			sum = s;
		}
	}
}