// package collections_practice.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyValuesExtraction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        String regex = "[$₹]\\d+(\\.\\d{1,2})?";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while(matcher.find()) {
        	System.out.println(matcher.group());
        }
	}

}
