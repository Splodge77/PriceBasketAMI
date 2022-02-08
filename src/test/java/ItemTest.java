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
        double expected = 3.99;
        assertEquals(expected, item.getPrice(), 1e-15);
    }

    @Test
    public void canSetName() {
        item.setName("Bacon");
        assertEquals("Bacon", item.getName());
    }

    @Test
    public void canSetPrice() {
        item.setPrice(1.49);
    }


}
