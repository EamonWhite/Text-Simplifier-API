package ie.gmit.dip;

import java.util.*;
import java.io.*;

/**
 * A class that implements the APIWordParser interface
 * 
 * See APIWordParser
 * 
 * @author Eamon White
 * @version 1.0
 * @since 1.8
 */
public class WordParser implements APIWordParser {
	private Map<String, String> wordMap = new TreeMap<String, String>();
	private Set<String> wordSet = new TreeSet<String>();
	private static final String google1000WF = "./google-1000.txt";
	private static final String mobyThesaurus = "./MobyThesaurus2.txt";
	
	/**
	 * Uses a <b>BufferedReader</b> to read lines from a file containing a list of
	 * Google's 1000 most commonly used words in English, maps these 1000 words
	 * as key/value pairs in a TreeMap <i>wordMap</i>, converts them to lower case, adds them
	 * to a TreeSet <i>wordSet</i> then calls the <i>mapThesaurus</i> method.
	 * 
	 * @throws IOException
	 */
	public void mapGoogleWord() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(google1000WF))));

		String word = null;

		while ((word = br.readLine()) != null) {
			wordMap.put(word.toLowerCase(), word.toLowerCase());// O(log n)
			wordSet.add(word.toLowerCase());// O(log n)
		}
		br.close();
		mapThesaurus();
	}

	/**
	 * Uses a <b>BufferedReader</b> to read lines from a file containing a thesaurus,
	 * where each line contains a set of words delimited by commas, and creates a 
	 * String array of words <i>words</i> for each line. The array is looped over 
	 * and if <i>wordSet</i> doesn't already contain the word, it is assigned to
	 * a String variable <i>googleWord</i>, then the <i>addAll</i> method is called,
	 * using <i>words</i> and <i>googleWord</i> as parameters.
	 * 
	 * @throws IOException
	 */
	public void mapThesaurus() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(mobyThesaurus))));

		String line = null;

		while ((line = br.readLine()) != null) {
			String[] words = line.split(",");
			String googleWord = null;

			for (String word : words) {
				if (wordSet.contains(word)) {
					googleWord = word.toLowerCase();
					break;
				}
			}

			if (googleWord != null) {
				addAll(words, googleWord);
			}
		}
		br.close();
	}

	/**
	 * Loops over the array and maps each key word to the value passed in by
	 * the paramater <i>googleWord</i> and adds them to the TreeMap <i>wordMap</i>
	 * 
	 * @param words the array to loop over to get key 
	 * @param googleWord the String value to map to the key
	 */
	public void addAll(String[] words, String googleWord) {
		for (String word : words) {
			wordMap.put(word, googleWord);
		}
	}

	/**
	 * Returns the String value mapped to the key word passed in as a parameter, if
	 * <i>wordMap</i> contains the key, otherwise it returns the word to lower
	 * case
	 * 
	 * @param word inputted by the user via a Scanner in the Input class
	 * @return returns value mapped to word
	 * @throws Throwable
	 */
	public String getGoogleWord(String word) throws Throwable {
		mapGoogleWord();
		if (wordMap.containsKey(word)) {
			return wordMap.get(word);
		} else {
			return word.toLowerCase();
		}
	}
}
