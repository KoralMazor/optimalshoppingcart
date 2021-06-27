package main.test;

import main.java.OneOrZeroKnapsackAlgoImpl;
import main.java.UnboundedKnapsackAlgoImpl;
import org.junit.jupiter.api.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;

public class IAlgoKnapsackTest {

    OneOrZeroKnapsackAlgoImpl oneOrZeroKnapsack = null;
    UnboundedKnapsackAlgoImpl unboundedKnapsack = null;

    // setup for oneOrZeroKnapsackTest
    private static final int[] v = { 60, 100, 120 };
    private static final int [] W = { 10, 20, 30 };
    private static final int n = v.length;
    private static final int totalWeight = 50;

    private static ArrayList<Integer> resultArray = new ArrayList<>();

     // setup for unboundedKnapsackTest
    private static final int[] values = { 30, 14, 16, 9 };
    private static final int [] weights = { 6, 3, 4, 2 };
    private static final int length = 0;
    private static final int unboundedTotalWeight = 10;

    private static ArrayList<Integer> unboundedResultArray = new ArrayList<>();

    @BeforeAll
    public static void beforeAllTest() {
        System.out.println("Runs once at the beginning of the test");

        // setup for oneOrZeroKnapsackTest
        resultArray.add(2);
        resultArray.add(1);

        // setup for unboundedKnapsackTest
        unboundedResultArray.add(0);
        unboundedResultArray.add(3);
        unboundedResultArray.add(3);
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

    }

    @Test
    public void  oneOrZeroKnapsackTest() {
        Assert.assertEquals(resultArray, oneOrZeroKnapsackBuildShoppingCart(oneOrZeroKnapsack,v, W, totalWeight, n ));
    }

    @Test
    public void  invalidTotalWeightOneOrZeroKnapsackTest() {
        Assert.assertEquals(new ArrayList<>(), oneOrZeroKnapsackBuildShoppingCart(oneOrZeroKnapsack, new int[]{60, 100, 120},new int[]{10, 20, 30 },-1,n));
        Assert.assertEquals(new ArrayList<>(), oneOrZeroKnapsackBuildShoppingCart(oneOrZeroKnapsack, new int[]{60, 100, 120},new int[]{10, 20, 30 },0,n));
    }

    @Test
    public void unboundedKnapsackTest() {
        Assert.assertEquals(unboundedResultArray, unboundedKnapsackBuildShoppingCart(unboundedKnapsack,values, weights, unboundedTotalWeight, length ));
    }

    @Test
    public void  invalidTotalWeightUnboundedKnapsackTest() {
        Assert.assertEquals(new ArrayList<>(), oneOrZeroKnapsackBuildShoppingCart(oneOrZeroKnapsack, new int[]{30, 14, 16, 9 },new int[]{6, 3, 4, 2 },-1,length));
        Assert.assertEquals(new ArrayList<>(), oneOrZeroKnapsackBuildShoppingCart(oneOrZeroKnapsack, new int[]{30, 14, 16, 9 },new int[]{6, 3, 4, 2  },0,length));
    }


    private Collection<Integer> oneOrZeroKnapsackBuildShoppingCart(OneOrZeroKnapsackAlgoImpl oneOrZeroKnapsack ,int[] v, int[] w,
                                                   int totalWeight, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        (oneOrZeroKnapsack.buildShoppingCart(v, w, totalWeight, n)).forEach(index->result.add(index));
        return result;
    }

    private Collection<Integer> unboundedKnapsackBuildShoppingCart(UnboundedKnapsackAlgoImpl unboundedKnapsack ,int[] v, int[] w,
                                                                   int totalWeight, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        (unboundedKnapsack.buildShoppingCart(v, w, totalWeight, n)).forEach(index->result.add(index));
        return result;
    }


}
