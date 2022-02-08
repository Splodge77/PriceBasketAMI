package main.java;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Main {
    // would potentially re-name this class 'teller' or 'clerk' for more clarity
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean checkout = false;
        // In this case a new basket is created every time, however in the 'production' version they
        // would be persisted or cached
        Basket basket = new Basket();

        // This list of items is ugly and in a later version they would be persisted in a relational db using orm
        Item soup = new Item("Soup", 0.65);
        Item bread = new Item("Bread", 0.80);
        Item milk = new Item("Milk", 1.30);
        Item apples = new Item("Apples", 1.00);

        // currently, the app is designed to 'checkout' automatically after one line of input, however in a later
        // version we might like to control the time at which a customer checks out in case any changes want to be made
        while (!checkout){
            System.out.println("Welcome, please enter your shopping items with one space in-between: ");
            String input = scanner.nextLine();
            String delimiter = " ";
            String[] inputArray = input.split(delimiter);
            for (String itemInput : inputArray){
                switch (itemInput){
                    case "Soup": basket.addItem(soup);
                        break;
                    case "Bread": basket.addItem(bread);
                        break;
                    case "Milk": basket.addItem(milk);
                        break;
                    case "Apples": basket.addItem(apples);
                        break;
                    default:
                        System.out.println("We didn't recognise some items and so they have not been added to your basket.");
                }
            }
            System.out.println("You have ordered: "+ basket.getItemList());
            System.out.println("After discounts, your total is: £"+ basket.getTotalString());
            checkout = true;
        }

    }
}
