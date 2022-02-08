package main.java;

import java.util.ArrayList;
import java.util.UUID;

public class Basket {

    UUID id;
    ArrayList<Item> items;
    Integer capacity;
    Double total;

    public Basket(){
        id = UUID.randomUUID();
        items = new ArrayList<>();
        capacity = 100;
        total = 0.00;
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

    public void clearBasket(){
        this.items.clear();
    }

    public Item getItemByName(String name){
        for (Item item : this.items){
            if (item.name.equals(name)){
                return item;
            }
        }
        return null;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total){
        this.total = total;
    }
}
