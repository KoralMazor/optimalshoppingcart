package main.test;

import main.java.com.hit.OneOrZeroKnapsackAlgoImpl;
import main.java.com.hit.UnboundedKnapsackAlgoImpl;
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
        Assert.assertEquals(null, getOrPut(mfu, 7));
        Assert.assertEquals(null, getOrPut(mfu, 0));
        Assert.assertEquals(null, getOrPut(mfu, 1));
        Assert.assertEquals(new Integer(0), getOrPut(mfu, 0));
        Assert.assertEquals(new Integer(0), getOrPut(mfu, 8));
        Assert.assertEquals(new Integer(8), getOrPut(mfu, 8));
        Assert.assertEquals(new Integer(8), getOrPut(mfu, 9));
        Assert.assertEquals(new Integer(1), getOrPut(mfu, 1));
        Assert.assertEquals(new Integer(1), getOrPut(mfu, 1));
        Assert.assertEquals(new Integer(1), getOrPut(mfu, 3));
    }

    private Integer getOrPut(MFUAlgoImpl<Integer, Integer> mfu, Integer key) {
        Integer element = mfu.getElement(key);
        if(element != null)
            return element;
        return mfu.putElement(key, key);
    }

}
