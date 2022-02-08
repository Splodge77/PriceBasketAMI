package main.java;

import java.util.ArrayList;
import java.util.UUID;

public class Basket {

    UUID id;
    ArrayList<Item> items;
    Integer capacity;

    public Basket(){
        id = UUID.randomUUID();
        items = new ArrayList<>();
        capacity = 100;
    }

    public UUID getId() {
        return id;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItemsArray(){
        return this.items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void deleteItems(){
        this.items.clear();
    }
}
