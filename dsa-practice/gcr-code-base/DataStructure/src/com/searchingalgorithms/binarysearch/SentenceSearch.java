package com.searchingalgorithms.binarysearch;

public class SentenceSearch {

	
	public static String findSentenceWithWord(String[] sentences,String word) {
		
		for(String sentence: sentences) {
			if(sentence.contains(word)) {
				return sentence;
			}
		}
		return "not found";
	}
	
	
	public static void main(String[] args) {
		String sentences[]= {"Java is a powerful programming language",
							"Linear search is simple and effective",
							"Data structures are important"
		};
		
		String wordToSearch="search";
		String result=findSentenceWithWord(sentences,wordToSearch);
		
		System.out.println(result);
	}

}
