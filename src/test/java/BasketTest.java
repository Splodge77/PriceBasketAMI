package test.java;

import main.java.Basket;
import main.java.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BasketTest {

    Basket basket;
    Item item1;
    Item item2;

    @Before
    public void before(){
        basket = new Basket();
        item1 = new Item("Cheese", 3.99);
        item2 = new Item("Bacon", 4.99);
        basket.addItem(item1);
        basket.addItem(item2);
    }

    @Test
    public void hasItems(){
        ArrayList<Item> toCheck = new ArrayList<>();
        toCheck.add(item1);
        toCheck.add(item2);
        assertEquals(toCheck, basket.getItemsArray());
    }

    @Test
    public void canAddItem(){
        Item newItem = new Item("Mushroom", 1.49);
        basket.addItem(newItem);
        ArrayList<Item> emptyArray = new ArrayList<>();
        assertNotEquals(emptyArray, basket.getItemsArray());
    }

    @Test
    public void canRemoveItem(){
        basket.removeItem(item1);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item2);
        assertEquals(expected, basket.getItemsArray());
    }

    @Test
    public void hasId(){
        assertNotNull(basket.getId());
    }

    @Test
    public void hasCapacity(){
        assertEquals(100, basket.getCapacity());
    }

    @Test
    public void canFindItem(){
        String expectedName = "Cheese";
        Item toCheck = basket.getItemByName("Cheese");
        String actualName = toCheck.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void canClearBasket(){
        basket.clearBasket();
        ArrayList<Item> expected = new ArrayList<>();
        ArrayList<Item> actual = basket.getItemsArray();
        assertEquals(expected, actual);
    }

    // setItems would be used if the user deleted all items accidentally. A copy of the Item arraylist could be cached
    // and then used again to fill the basket again with the same items.
    @Test
    public void canSetItems(){
        ArrayList<Item> newArray = new ArrayList<>();
        Item hollandaise = new Item("Hollandaise", 7.99);
        Item eggs = new Item("Eggs", 2.99);
        newArray.add(hollandaise);
        newArray.add(eggs);
        basket.setItems(newArray);
        assertEquals(newArray, basket.getItemsArray());
    }

    @Test
    public void hasTotal(){
        Double expected = 8.98;
        Double actual = basket.getTotal();
        assertEquals(expected, actual);
    }

    @Test
    public void canSetTotal(){
        Double expected = 100.00;
        basket.setTotal(expected);
        Double actual = basket.getTotal();
        assertEquals(expected, actual);
    }

    @Test
    public void getItemListReturnsString(){
        String expected = "Cheese, Bacon";
        String actual = basket.getItemList();
        assertEquals(expected, actual);
    }

    @Test
    public void addingItemIncrementsPrice(){
        Double expected = 9.98;
        Item chocolateBar = new Item("Snickers", 1.00);
        basket.addItem(chocolateBar);
        Double actual = basket.getTotal();
        assertEquals(expected,actual);
    }

//    @Test
//    public void canApplyDiscounts(){
//
//    }

}
