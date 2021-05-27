package main.test;

import main.java.IAlgoKnapsack;
import main.java.OneOrZeroKnapsackAlgoImpl;
import main.java.UnboundedKnapsackAlgoImpl;
import org.junit.jupiter.api.*;

public class IAlgoKnapsackTest {

    OneOrZeroKnapsackAlgoImpl oneOrZeroKnapsack = null;
    UnboundedKnapsackAlgoImpl unboundedKnapsack = null;

    @BeforeAll
    public static void beforeAllTest() {
        System.out.println("Runs once at the beginning of the test");
    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("Runs once at the end of the test");
    }

    @BeforeEach
    public void beforeTest() {
        oneOrZeroKnapsack = new OneOrZeroKnapsackAlgoImpl();
        unboundedKnapsack = new UnboundedKnapsackAlgoImpl();
    }

    @AfterEach
    public void tearDown() {
        oneOrZeroKnapsack.clear();
        unboundedKnapsack.clear();
    }

    @Test
    public void mfuTest() {

        //7 0 1 0 8 8 9 1 1 3
        Assertions.assertEquals(null, createShoppingCart(, 7));
        Assertions.assertEquals(null, createShoppingCart(mfu, 0));
        Assertions.assertEquals(null, createShoppingCart(mfu, 1));
        Assertions.assertEquals(new Integer(0), createShoppingCart(mfu, 0));
        Assertions.assertEquals(new Integer(0), createShoppingCart(mfu, 8));
        Assertions.assertEquals(new Integer(8), createShoppingCart(mfu, 8));
        Assertions.assertEquals(new Integer(8), createShoppingCart(mfu, 9));
        Assertions.assertEquals(new Integer(1), createShoppingCart(mfu, 1));
        Assertions.assertEquals(new Integer(1), createShoppingCart(mfu, 1));
        Assertions.assertEquals(new Integer(1), createShoppingCart(mfu, 3));
    }

    private Integer createShoppingCart(IAlgoKnapsack<Integer, Integer> mfu, Integer key) {
        Integer element = mfu.getElement(key);
        if(element != null)
            return element;
        return mfu.putElement(key, key);
    }

}
