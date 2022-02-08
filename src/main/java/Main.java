package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // would potentially re-name this class 'teller' or 'clerk' for more clarity
        Scanner scanner = new Scanner(System.in);

        boolean checkout = false;
        Basket basket = new Basket();

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
