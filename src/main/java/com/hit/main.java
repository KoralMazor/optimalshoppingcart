package com.hit;

import com.hit.OneOrZeroKnapsackAlgoImpl;
import com.hit.UnboundedKnapsackAlgoImpl;

public class main {

    public static void main(String[] args) {

        // main for UnboundedKnapsackAlgoArrayList
        int[] v = new int[] { 30, 14, 16, 9 };
        int[] w = new int[] { 6, 3, 4, 2 };
        int c = 10;
        int n = 0;

        UnboundedKnapsackAlgoImpl unbounded = new UnboundedKnapsackAlgoImpl();
        System.out.println("UnboundedKnapsackAlgoArrayList- the ids of the selected objects are :"
                + unbounded.createShoppingCart(v, w, c, n));

        // main for OneOrZeroKnapsackAlgoPrint
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;
         n = val.length;
        OneOrZeroKnapsackAlgoImpl algo =  new OneOrZeroKnapsackAlgoImpl();
        System.out.println("OneOrZeroKnapsackAlgoPrint- the ids of the selected objects are :"
                + algo.createShoppingCart(val, wt, W, n)  );
        //System.out.print(wt[i - 1] + "," + val[i-1] + " ");
    }

}
