// package collections_practice.regex;

import java.util.*;
import java.util.regex.*;

public class CreditCardNumberValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter Card Number: ");
        String cardNumber = sc.nextLine();

        String regex = "^(4\\d{15}|5\\d{15})$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);

        if (matcher.matches()) {
            System.out.println("Valid Card Number");
        } else {
            System.out.println("Invalid Card Number");
        }
	}

}
