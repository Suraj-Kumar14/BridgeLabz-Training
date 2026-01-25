package com.regexjunit.regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindRepeatingWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text="This is is a repeated repeated word test.";
		String regex="\\b(\\w+)\\b\\s+\\1\\b";
		
		Pattern pattern =Pattern.compile(regex);
		Matcher matcher=pattern.matcher(text);
		
		ArrayList<String>words=new ArrayList<>();
		while(matcher.find()) {
			System.out.println(matcher.group(1));
		}		
	}

}
