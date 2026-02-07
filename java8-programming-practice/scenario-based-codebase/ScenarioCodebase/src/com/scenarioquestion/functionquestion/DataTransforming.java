package com.scenarioquestion.functionquestion;

import java.util.function.Function;

public class DataTransforming {

	public static void main(String[] args) {
		
	//3.Convert product price into discounted price.
		double price=4000;
		Function<Double,Double>discountPrice=pric->pric*0.1;
		System.out.println("Price: "+price+", DiscountPrice: "+discountPrice.apply(price));
		
		
	//4.Convert employee name into uppercase.
		String name="Sonu";
		Function<String,String>upperCase=n->n.toUpperCase();
		
		System.out.println(name+" in upperCase "+upperCase.apply(name));
		
		
	//5.Convert Celsius temperature into Fahrenheit.
		double celsius=37;
		Function<Double,Double>fahrenheit=cel->cel*1.8+32;
		
		System.out.println("Celcius="+celsius+" Fahrenheit: "+fahrenheit.apply(celsius));

	}

}
