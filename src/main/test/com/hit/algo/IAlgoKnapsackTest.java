package com.hit.algo;

import org.junit.jupiter.api.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;

import static org.testng.AssertJUnit.assertNull;

public class IAlgoKnapsackTest {

    com.hit.algo.OneOrZeroKnapsackAlgoImpl oneOrZeroKnapsack = null;
    com.hit.algo.UnboundedKnapsackAlgoImpl unboundedKnapsack = null;

    // setup for oneOrZeroKnapsackTest
    private static ArrayList<Integer> resultArray = new ArrayList<>();

    private static final int[] v = { 60, 100, 120 };
    private static final int [] w = { 10, 20, 30 };
    private static final int n = v.length;

     // setup for unboundedKnapsackTest
     private static ArrayList<Integer> unboundedResultArray = new ArrayList<>();

    private static final int[] values = { 30, 14, 16, 9 };
    private static final int [] weights = { 6, 3, 4, 2 };
    private static final int length = 0;

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
        System.out.println("Running: tearDown");
        oneOrZeroKnapsack = null;
        unboundedKnapsack = null;
        assertNull(oneOrZeroKnapsack);
        assertNull(unboundedKnapsack);

    }

    @Test
    public void  oneOrZeroKnapsackTest() {
        Assert.assertEquals(resultArray, oneOrZeroKnapsackBuildShoppingCart(oneOrZeroKnapsack,v, w, 50, n ));
    }

    @Test
    public void  invalidTotalWeightOneOrZeroKnapsackTest() {
        Assert.assertEquals(new ArrayList<>(), oneOrZeroKnapsackBuildShoppingCart(oneOrZeroKnapsack, v, w,-1, n));
        Assert.assertEquals(new ArrayList<>(), oneOrZeroKnapsackBuildShoppingCart(oneOrZeroKnapsack, v , w,0, n));
    }

    @Test
    public void unboundedKnapsackTest() {
        Assert.assertEquals(unboundedResultArray, unboundedKnapsackBuildShoppingCart(unboundedKnapsack, values, weights, 10, 0 ));
    }

    @Test
    public void  invalidTotalWeightUnboundedKnapsackTest() {
        Assert.assertEquals(new ArrayList<>(), unboundedKnapsackBuildShoppingCart(unboundedKnapsack, values, weights,-1, length));
        Assert.assertEquals(new ArrayList<>(), unboundedKnapsackBuildShoppingCart(unboundedKnapsack, values, weights,0, length));
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
