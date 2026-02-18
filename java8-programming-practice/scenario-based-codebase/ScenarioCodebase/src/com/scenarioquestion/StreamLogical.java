package com.scenarioquestion;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLogical {
	
	public static void main(String[] args) {
		//1.Character Frequency Count
		String input="banana";
		Map<Character,Long>freq=input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		System.out.println(freq);
		
		//2.Word Frequency Count
		String str= "java is java and java is fast";
		Map<String, Long>wordFreq=Stream.of(str.split("\\s+")).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		System.out.println(wordFreq);
		
		//3.First Non-Repeating Character
		String string="stress";
		Character ch=string.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(c->c.getValue()==1).findFirst().get().getKey();
		System.out.println(ch);
	
		//4.All Non-Repeating Characters
		String ip="programming";
		List<Character>nonRepeating=ip.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(c->c.getValue()==1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(nonRepeating);
		
		//5.Remove Duplicate Characters
		String strs="banana";
		String removeDup=strs.chars().distinct().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
		System.out.println(removeDup);
		
		//6.Remove Repeating Characters (Keep Only Unique Once)
		String input1="aabbccdde";
		Character chh=input1.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(c->c.getValue()==1).findFirst().get().getKey();
		System.out.println(chh);		
		
		//7.Remove Non-Alphanumeric Characters
		String str1="ja@va#8!!";
		String result=str1.chars().filter(Character::isLetterOrDigit).mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
		System.out.println(result);
		
		//8.Keep Only Alphabets
		String str2="java8stream2025";
		String output=str2.chars().filter(Character::isLetter).mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
		System.out.println(output);
		
		//9.Keep Only Digits
		String inputs="orderId=AB123XZ9";
		String digit=inputs.chars().filter(Character::isDigit).mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
		System.out.println(digit);
		
	}
}
