// package collections_practice.regex;

import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageNamesExtraction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();

        String regex = "\\b(Java|Python|JavaScript|Go)\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Programming Languages Found:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
	}

}
