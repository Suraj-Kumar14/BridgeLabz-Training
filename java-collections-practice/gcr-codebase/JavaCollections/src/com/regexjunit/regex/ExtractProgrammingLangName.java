package com.regexjunit.regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractProgrammingLangName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String text="I love Java, Python, and JavaScript, but I haven't tried Go yet.";
		String regex="\\b(Java|Python|JavaScript|Go)\\b";
	
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(text);
		ArrayList<String>lang=new ArrayList<>();
		
		while(matcher.find()) {
			lang.add(matcher.group());
		}
		System.out.println(String.join(", ",lang));
	}

}
