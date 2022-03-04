package ru.job4j.tracker.pojo;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ShopTest {
    @Test
    public void whenLastNull() {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int result = Shop.indexOfNull(products);
        assertThat(result, is(3));
    }

    @Test
    public void whenFirstNull() {
        Product[] products = new Product[5];
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int result = Shop.indexOfNull(products);
        assertThat(result, is(0));
    }

    @Test
    public void whenHasNotNull() {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int result = Shop.indexOfNull(products);
        assertThat(result, is(-1));
    }
}