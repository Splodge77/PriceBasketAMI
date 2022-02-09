package main.java;

import java.text.DecimalFormat;
import java.text.NumberFormat;
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
        this.total += item.price;
    }

    public void removeItem(Item item){
        this.items.remove(item);
        this.total -= item.price;
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

    public String getTotalString() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(this.total);
    }

    public void setTotal(Double total){
        this.total = total;
    }

    public String getItemList(){
        ArrayList<String> itemList = new ArrayList<>();
        for (Item item: this.items){
            itemList.add(item.getName());
        }
        return itemList.toString().replace("[", "").replace("]","");
    }

    public void applyDiscountToProducts(String itemToDiscount, Double percentDiscount){
        NumberFormat formatter = new DecimalFormat("#0.00");
        for (Item item : this.items) {
            if (item.getName().equals(itemToDiscount)) {
                Double newPrice = item.price -= (item.price * (percentDiscount / 100));
                String newFormatString = formatter.format(newPrice);
                Double forMattedPrice = Double.parseDouble(newFormatString);
                item.setPrice(forMattedPrice);
            }
        }
        this.updateTotal();
    }

    private void updateTotal() {
        Double newTotal = 0.00;
        this.setTotal(0.00);
        for (Item item: this.items){
            newTotal += item.price;
        }
        this.setTotal(newTotal);
    }
}
