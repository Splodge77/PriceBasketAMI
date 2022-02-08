package test.java;

import main.java.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    Item item;

    @Before
    public void before(){
        item = new Item("Cheese", 3.99);
    }

    @Test
    public void hasName(){
        assertEquals("Cheese", item.getName());
    }

    @Test
    public void hasPrice(){
        Double expected = 3.99;
        Double actual = item.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    public void canSetName() {
        item.setName("Bacon");
        assertEquals("Bacon", item.getName());
    }

    @Test
    public void canSetPrice() {
        Double expected = 1.49;
        item.setPrice(expected);
        Double actual = item.getPrice();
        assertEquals(expected, actual);
    }


}
