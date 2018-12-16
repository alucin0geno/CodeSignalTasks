package codesignal.tasks.dahanschuster;

import java.util.ArrayList;

public class DailyChallenges {

	/**
	 * 
	 * 
	 * The Si Stebbins stack is a way to stack playing cards such that each card
	 * alternates suit in the repeating order [Clubs, Hearts, Spades, Diamonds] (not
	 * necessarily starting with Clubs), and has a numerical value three greater
	 * than the preceding card.
	 * 
	 * For non-numerical cards, Aces are represented by 1, Jacks are represented by
	 * 11, Queens are represented by 12, and Kings are represented by 13.
	 * 
	 * For numerical values greater than 13, start back at 1. For instance, in a
	 * deck in Si Stebbins order, the 10 of Diamonds is followed by the King of
	 * Clubs, which is followed by the 3 of Hearts.
	 * 
	 * Given a deck (52 cards or less), your task is to determine whether or not the
	 * cards are in Si Stebbins order.
	 * 
	 * We will represent the deck as a string deck, where the individual cards are
	 * separated by spaces. For instance, the string "10D KC 3H" represents the
	 * deck: 10 of Diamonds, King of Clubs, 3 of Hearts (which, as we have seen, is
	 * in Si Stebbins order).
	 * 
	 * Return 1 if deck is in Si Stebbins order. If deck is not in Si Stebbins
	 * order, return an integer (2 to 51) representing the card at which the deck
	 * stops being in Si Stebbins order (1-based).
	 * 
	 * Note: deck is always a valid deck of cards. It is not necessary to check for
	 * duplicate or impossible cards.
	 * 
	 * @Example
	 * 
	 * 			For deck = "10D KC 3H", the output should be isSiStebbinsStack(deck)
	 *          = 1.
	 * 
	 *          This is in Si Stebbins order.
	 * 
	 *          For deck = "9C QH 4S 7D 10H", the output should be
	 *          isSiStebbinsStack(deck) = 3.
	 * 
	 *          The 4 of Spades (card number 3) breaks the order, since its value is
	 *          more than 3 greater than the previous card.
	 * 
	 *          Note that additionally, card number 5 is the wrong suit, but since
	 *          the order was broken already by card number 3, the output should be
	 *          3.
	 * 
	 *          For deck = "10D KC 3H AH", the output should be
	 *          isSiStebbinsStack(deck) = 4.
	 * 
	 *          The fourth card (the Ace of Hearts) breaks the Si Stebbins order
	 *          because it's the wrong suit and the wrong number. To maintain the
	 *          order, this card should be the 6 of spades.
	 * 
	 *          For deck = "10D", the output should be isSiStebbinsStack(deck) = 1.
	 * 
	 *          Since any deck consisting of only one card is technically in Si
	 *          Stebbins order.
	 * 
	 * @InputOutput
	 * 
	 * 				[execution time limit] 3 seconds (java)
	 * 
	 * @input string deck
	 * 
	 *        A string representing a deck of cards, where each card is of the form
	 *        [value][suit], separated by spaces.
	 * 
	 *        Guaranteed constraints: 2 ≤ deck.length ≤ 159 deck[i] ∈ {"0" - "9",
	 *        "A", "J", "Q", "K", "C", "H", "S", "D", space}
	 * 
	 * @output integer
	 * 
	 *         Return 1 if deck is in Si Stebbins order, otherwise return 2 to 51,
	 *         representing the card at which the deck stops being in Si Stebbins
	 *         order (1-based).
	 * 
	 * @TaskAuthor hb20007
	 * @CodeSignalProfile https://app.codesignal.com/profile/hb20007
	 */
	public static int isSiStebbinsStack(String deck) {

		deck = deck.replaceAll("A", "1");
		deck = deck.replaceAll("J", "11");
		deck = deck.replaceAll("Q", "12");
		deck = deck.replaceAll("K", "13");

		String suits = "CHSDC";

		String[] d = deck.split(" ");
		int breakPoint = 1;

		for (int i = 1; i < d.length; i++) {
			int k = Integer.parseInt(d[i].substring(0, d[i].length() - 1))
					- Integer.parseInt(d[i - 1].substring(0, d[i - 1].length() - 1));

			if ((k != 3 && k != -10) || (d[i].charAt(d[i].length() - 1) != suits
					.charAt(suits.indexOf(d[i - 1].charAt(d[i - 1].length() - 1)) + 1))) {
				breakPoint = i + 1;
				break;
			}
		}

		return breakPoint;
	}

	/**
	 * While visiting the exquisite sacred forest Atsuta Jingu, you stumble upon a
	 * large stone under which you find a manuscript with some matrices. Since the
	 * matrices seem to resemble a Soroban (Japanese abacus), you suspect that these
	 * matrices may represent decimal numbers!
	 * 
	 * Given matrix as an 8-element array of arrays of strings, your task is to
	 * write a program which returns a decimal number as a result.
	 * 
	 * @Example
	 * 
	 * 			For
	 * 
	 *          matrix = [["o", "o", "o", "|", "|", "o"], ["|", "|", "|", "o", "o",
	 *          "|"], ["-", "-", ".", "-", "-", "-"], ["|", "|", "o", "o", "o",
	 *          "o"], ["o", "o", "|", "o", "|", "o"], ["o", "o", "o", "o", "o",
	 *          "o"], ["o", "o", "o", "o", "o", "|"], ["o", "o", "o", "|", "o",
	 *          "o"]] the output should be matrixToDecimal = 1.963.
	 * 
	 *          For
	 * 
	 *          matrix = [["o", "o", "o", "|", "|"], ["|", "|", "|", "o", "o"],
	 *          ["-", "-", ".", "-", "-"], ["o", "|", "|", "o", "|"], ["o", "o",
	 *          "o", "|", "o"], ["o", "o", "o", "o", "o"], ["|", "o", "o", "o",
	 *          "o"], ["o", "o", "o", "o", "o"]] the output should be
	 *          matrixToDecimal = 300.65.
	 * 
	 * @InputOutput
	 * 
	 * 				[execution time limit] 3 seconds (java)
	 * 
	 * @input array.array.string matrix
	 * 
	 *        A 2-dimensional matrix of single-character strings representing some
	 *        kind of abacus.
	 * 
	 *        Guaranteed constraints: matrix.length = 8 0 ≤ matrix[i].length ≤ 10
	 *        matrix[2][j] ∈ {"-", "."} matrix[i][j] ∈ {"o", "|"} (for i ≠ 2)
	 * 
	 * @output float
	 * 
	 *         The floating point number represented by the configuration of the
	 *         abacus.
	 * 
	 * @TaskAuthor the_mole
	 * @CodeSignalProfile https://app.codesignal.com/profile/the_mole
	 */
	public static double matrixToDecimal(String[][] matrix) {
		double output = 0.0;
		double value = 0;
		int commaIndex = 0;
		

		for (int h = 0; h < matrix[0].length; h++) {
			if (matrix[2][h].equals(".")) {
				commaIndex = h;
			}
		}
		
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i].equals("|")) {
				value += 5;
			}
			
			for (int j = 3; j < matrix.length; j++) {
				if (matrix[j][i].equals("|")) {
					value += j - 3;
				}
			}
			
			value = (value * (Math.pow(10, (commaIndex - i))));
			
			output += value;
			value = 0;
		}
		return output;
	}

}











