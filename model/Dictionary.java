package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The Dictionary class models getting a random word from a list of words.
 * @author Mark Jones
 */
public class Dictionary {
	
	/** Create a dictionary.  Default constructor uses a default (internal) dictionary. */
	public Dictionary() {
		dictionary = new String[] {
				"algorithm",
				"application",
				"bus",
				"byte",
				"computer",
				"database",
				"hard disk",
				"keyboard",
				"memory",
				"modem",
				"monitor",
				"mouse",
				"network",
				"operating system",
				"program",
				"software",
				"hardware"
		};
	}
	
	/**
	 * Create a dictionary from a file containing a list of words.
	 * @param filename   filename of the file containing the dictionary
	 */
	public Dictionary(String filename) {
		try {
			File file = new File(filename)
					;
		    @SuppressWarnings("resource")
			Scanner sc = new Scanner(file);
		    
			ArrayList<String> dictionaryList = new ArrayList<String>();
		    
		    while (sc.hasNextLine()) {
		        String word = sc.nextLine();
		        dictionaryList.add(word);
		    }
		    
		    
		    dictionary = new String[dictionaryList.size()];
		    // move to an array for faster access
		    dictionary = dictionaryList.toArray(dictionary);
		    
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary file not found:" + e);
	    }
	}
	
	
	/**
	 * Create a dictionary from the given file containing a list of words.
	 * If maxWords >= 0, then limit the size of the dictionary. 
	 * If isRandom is true then select the words randomly from the entire dictionary.
	 * @param filename   filename of the file containing the dictionary
	 */
	public Dictionary(String filename, int maxWords, boolean isRandom) {
		try {
			File file = new File(filename);
		    @SuppressWarnings("resource")
			Scanner sc = new Scanner(file);
			ArrayList<String> dictionaryList = new ArrayList<String>();
		    int numWords = 0;
		    
		    while (sc.hasNextLine() && (isRandom || numWords < maxWords || maxWords<0)) {
		        String word = sc.nextLine();
		        dictionaryList.add(word);
		        System.out.println(word);
				numWords++;
		    }
		    
		    // randomize if necessary
		    if (isRandom && numWords < maxWords) {
		    	Collections.shuffle(dictionaryList);
		    }
		    
		    // select a subset of the words if necessary
		    if (numWords < maxWords) {
		    	dictionaryList = (ArrayList<String>) dictionaryList.subList(0, maxWords-1);
		    }
		    
		    // sort the words
		    Collections.sort(dictionaryList);
		    
		    // move to an array for faster access
		    dictionary = (String[]) dictionaryList.toArray();
		    
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary file not found:" + e);
	    }
	}

	/**
	 * Gets the current number of words in the dictionary.
	 * @return    the number of words in the dictionary
	 */
	public int size() {
		return dictionary.length;
	}

	/** Prints the entire dictionary. */
	public void printDictionary() {
		printDictionary(size());
	}
	
	/**
	 * Print the first or last entries in the dictionary.
	 *   if numEntries >= 0 then print the first numEntries
	 *   if numEntries < 0  then print the last numEntries
	 * @param numEntries    number of entries to print
	 */
	public void printDictionary(int numEntries) {
		int begin, end;
		if (numEntries >= 0) {
			begin = 0;
			end = Math.min(size(), numEntries);
		} else {  // numEntries < 0
			begin = Math.max(0, numEntries + size());
			end = size();
		}
			for (int i=begin; i<end; i++) {
				System.out.println(i + ".\t" + dictionary[i]);
		}
	}

	/**
	 * Prints front words from the front of the dictionary and
	 *        back words from the back of the dictionary.
	 * @param front
	 * @param back
	 */
	public void printDictionary(int front, int back) {
		front = Math.min(front,size());
		back = Math.min(back, size()-front);
		printDictionary(front);
		System.out.println(". . .");
		printDictionary(-back);
	}
	
	/**
	 * Returns the ith word in the dictionary.
	 * @param i
	 * @return the ith word
	 */
	public String getWord(int i) {
		if (0 <= i && i < dictionary.length)
			return dictionary[i];
		else
			return null;
	}
	
	/**
	 * Returns a random word in the dictionary.
	 * @return a random word
	 */
	public String getRandomWord() {
		return getWord(random.nextInt(dictionary.length));
	}
	
	/* class constants */
	private static final Random random = new Random();
	
	/* instance variables */
	private String[] dictionary;
}