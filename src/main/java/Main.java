package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // would potentially re-name this class 'teller' or 'clerk' for more clarity
        Scanner scanner = new Scanner(System.in);

        String name = "";

        Basket basket = new Basket();

        while (name.equals("")){
            System.out.println("What's your name?");
            name = scanner.next();
            System.out.println("Welcome " + name + "! What can i get for you?");
        }

        while (basket.items.isEmpty()){
            System.out.println("Enter items: ");
            Item newItem =  new Item();
            newItem.name = scanner.next();
            basket.items.add(newItem);

            for (Item item : basket.items){
                System.out.println(item.name);
            }
            // will only print one item at this point
        }

    }
}
