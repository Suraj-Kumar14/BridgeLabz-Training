package com.regexjunit.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text="Visit https://www.google.com and http://example.org for more info.";
		String regex="https?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
		
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(text);
		
		List<String>sites=new ArrayList<>();
		while(matcher.find()) {
			sites.add(matcher.group());
		}
		
		System.out.println(String.join(", ",sites));
	}

}
