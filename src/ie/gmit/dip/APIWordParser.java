package ie.gmit.dip;

import java.io.IOException;

/**
 * The interface APIWordParser is an abstraction of a word parser that is
 * used to map keys to values for use with a text simplifier application. It is 
 * completely declarative and specifies what an implementing class should do,
 * but not how it's done. Any class implementing the interface must 
 * implement all its methods
 * 
 * See WordParser
 * 
 * @author Eamon White
 * @version 1.0
 * @since 1.8
 */
public interface APIWordParser {
	
	/**
	 * Uses a BufferedReader to read lines from a file containing a list of
	 * Google's 1000 most commonly used words in English, maps these 1000 words
	 * as key/value pairs in a TreeMap <i>wordMap</i>, converts them to lower case, adds them
	 * to a TreeSet <i>wordSet</i> then calls the <i>mapThesaurus</i> method.
	 * 
	 * @throws IOException
	 */
	public void mapGoogleWord() throws IOException;
	
	/**
	 * Uses a BufferedReader to read lines from a file containing a thesaurus,
	 * where each line contains a set of words delimited by commas, and creates a 
	 * String array of words <i>words</i> for each line. The array is looped over 
	 * and if <i>wordSet</i> doesn't already contain the word, it is assigned to
	 * a String variable <i>googleWord</i>, then the <i>addAll</i> method is called,
	 * using <i>words</i> and <i>googleWord</i> as parameters.
	 * 
	 * @throws IOException
	 */
	public void mapThesaurus() throws IOException;
	
	/**
	 * Loops over the array and maps each key word to the value passed in by
	 * the paramater <i>googleWord</i> and adds them to the TreeMap <i>wordMap</i>
	 * 
	 * @param words the array to loop over to get key 
	 * @param googleWord the String value to map to the key
	 */
	public void addAll(String[] words, String googleWord);
	
	/**
	 * Returns the String value mapped to the key word passed in as a parameter, if
	 * <i>wordMap</i> contains the key, otherwise it returns the word to lower
	 * case
	 * 
	 * @param word inputted by the user via a Scanner in the Input class
	 * @return returns value mapped to word
	 * @throws Throwable
	 */
	public String getGoogleWord(String word) throws Throwable;
}
