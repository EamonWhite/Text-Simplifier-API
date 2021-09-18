package ie.gmit.dip;

import java.util.*;

/**
 * A class that outputs the Text Simplifier GUI and allows the user
 * to input text via a <b>Scanner</b>. The words, parsed and mapped by the <b>WordParser</b>
 * class, are swopped with Google 1000 words synonyms and output to the console.
 * ANSI escape codes from the <b>ConsloleColour</b> enum are used for colouring the text 
 * seen in the terminal window.
 * 
 * @author Eamon White
 * @version 1.0
 * @since 1.8
 *
 */
public class Input {
	private Scanner s;
	private WordParser wp;
	private boolean keepRunning = true;

	/**
	 * Outputs the GUI to the terminal window and allows the user to input text via
	 * a <b>Scanner</b> object <i>s</i> instantiated inside the class. Colours the text using
	 * ANSI escape codes from the <b>ConsloleColour</b> enum. Splits the line of text 
	 * entered into an words delimited ba a space and adds them to an array <i>words</i>.
	 * Loops over the words in the array, calling the <i>getGoogleWords</i> method via a 
	 * WordParser object <i>wp</i> on each word and outputting the result to the terminal.
	 * Ten words only output to the terminal before a new line is printed.
	 * 
	 * @throws Throwable
	 */
	public void start() throws Throwable {
		s = new Scanner(System.in);
		wp = new WordParser();

		while (keepRunning) {
			System.out.println(ConsoleColour.WHITE_BOLD_BRIGHT);
			System.out.println("***************************************************");
			System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
			System.out.println("*                                                 *");
			System.out.println("*          Eamon's Text Simplifier V0.1           *");
			System.out.println("*       (AKA Confusing Language Generator)        *");
			System.out.println("*                                                 *");
			System.out.println("***************************************************");

			System.out.print("Enter Text>");
			System.out.print(ConsoleColour.YELLOW_BOLD_BRIGHT);

			String input = s.nextLine();
			String[] words = input.split(" ");
			System.out.println("");
			System.out.println(ConsoleColour.WHITE_BOLD_BRIGHT);
			System.out.print("Simplified Text>");
			System.out.print(ConsoleColour.YELLOW_BOLD_BRIGHT);
			int count = 0;
			for (int i = 0; i < words.length; i++) {
				words[i] = wp.getGoogleWord(words[i]);
				System.out.print(words[i] + " ");
				count++;
				if (count == 10) {
					System.out.println();
					count = 0;
				}
			}
			System.out.println(ConsoleColour.RESET);
			System.out.println();
		}
	}
}
