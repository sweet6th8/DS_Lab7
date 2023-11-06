package lab7.set_student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "src/data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> list = new ArrayList<>();
		for (String word : words) {

			WordCount wordCount = new WordCount(word, count(word));
			if (!list.contains(wordCount)) {
				list.add(wordCount);
			}
		}

		return list;
	}

	public int count(String w) {
		int count = 0;
		for (String word : words) {
			if (word.equals(w)) {
				count++;
			}
		}
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> set = new HashSet<>();
		for (String word : words) {
			WordCount wordCount = new WordCount(word, count(word));
			if (count(word) == 1) {
				set.add(word);
			}
		}
		return set;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> set = new HashSet<>();
		for (String word : words) {
			WordCount wordCount = new WordCount(word, count(word));
			set.add(word);

		}
		return set;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {

		Set<WordCount> set = new TreeSet<>((o1, o2) -> {
			int byCount = o1.getCount() - o2.getCount();
			int byWord = o1.getWord().compareTo(o2.getWord());
			return byWord == 0 ? byCount : byWord;
		});

		set.addAll(getWordCounts());
		return set;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> set = new TreeSet<>(new Comparator<WordCount>() {

			public int compare(WordCount o1, WordCount o2) {
				int byCount = o2.getCount() - o1.getCount();
				return byCount == 0 ? o1.getWord().compareTo(o2.getWord()) : byCount;
			}
		});

		set.addAll(getWordCounts());

		return set;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> set = new HashSet<>();

		for (String word : words) {
			System.out.println(word.charAt(0));
			if (!(word.charAt(0) + "").equals(pattern)) {
				set.add(word);
			}
		}
		return set;
	}

	public static void main(String[] args) {
		MyWordCount myWordCount = new MyWordCount();
		List<WordCount> list = myWordCount.getWordCounts();
		Set<String> set1 = myWordCount.getUniqueWords();
		Set<String> set2 = myWordCount.getDistinctWords();
		Set<WordCount> set3 = myWordCount.printWordCounts();
		Set<WordCount> set4 = myWordCount.exportWordCountsByOccurence();
		Set<String> set5 = myWordCount.filterWords("L");

//		System.out.println(list);
//		System.out.println(set1);
//		System.out.println(set2);
//		System.out.println(set3);
//		System.out.println(set4);
		System.out.println(set5);

	}

}
