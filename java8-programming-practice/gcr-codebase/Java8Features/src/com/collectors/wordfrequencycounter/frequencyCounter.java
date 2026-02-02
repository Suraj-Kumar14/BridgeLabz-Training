package com.collectors.wordfrequencycounter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class frequencyCounter {

	public static void main(String[] args) {
		List<String> list = List.of(
				"Hii Ravi how are you",
				"I am fine babe",
				"Hii Sonu how are you",
				"I am fine babe"				
			);
		
		Map<String,Integer>wordcount=list.stream()
				.flatMap(line->Arrays.stream(line.split(" ")))
				.map(String::toLowerCase)
				.collect(Collectors.toMap(word->word,word->1,Integer::sum));
		
		System.out.println(wordcount);
	}

}
