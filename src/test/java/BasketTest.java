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
        item1 = new Item("Cheese");
        item2 = new Item("Bacon");
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
        Item newItem = new Item("Mushroom");
        basket.addItem(newItem);
        ArrayList<Item> emptyArray = new ArrayList<>();
        assertNotEquals(emptyArray, basket.getItemsArray());
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

}
