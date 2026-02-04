// package java8_features_practice.LambdaExpressions;

import java.util.*;

public class CustomSortingInECommerce {
	static class Product {
        String name;
        double price;
        double rating;
        int discount;

        public Product(String name, double price, double rating, int discount) {
            this.name = name;
            this.price = price;
            this.rating = rating;
            this.discount = discount;
        }

        public String toString() {
            return name + " | Price: " + price + " | Rating: " + rating + " | Discount: " + discount + "%";
        }
    }
	
	public static void printProducts(List<Product> products) {
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("-------------");
    }
	
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 60000, 4.5, 10));
        products.add(new Product("Mobile", 25000, 4.8, 20));
        products.add(new Product("Headphones", 3000, 4.2, 30));
        products.add(new Product("Smart Watch", 8000, 4.6, 15));

        System.out.println("Original List");
        printProducts(products);

        System.out.println("Budget Sale → Sort by Price");
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        printProducts(products);
        
        System.out.println("Top Rated → Sort by Rating");
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        printProducts(products);

        System.out.println("Mega Discount → Sort by Discount");
        products.sort((p1, p2) -> p2.discount - p1.discount);
        printProducts(products);
	}
}
