package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // would potentially re-name this class 'teller' or 'clerk' for more clarity
        Scanner scanner = new Scanner(System.in);

        String name = "";

        boolean checkout = false;

        Basket basket = new Basket();

        while (name.equals("")){
            System.out.println("What's your name?");
            name = scanner.next();
            System.out.println("Welcome " + name + "! What can i get for you?");
        }

        while (!checkout){
            System.out.println("Enter items: ");
            Item newItem =  new Item("", 0.00);
            newItem.name = scanner.next();
            basket.items.add(newItem);

            for (Item item : basket.items){
                System.out.println(item.name);
            }
            System.out.println("Anything else for you?");
            if (scanner.next().equals("No")){
                checkout = true;
            }
        }

    }
}
