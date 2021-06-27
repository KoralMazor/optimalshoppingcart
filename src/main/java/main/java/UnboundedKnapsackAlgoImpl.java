package main.java;

import main.java.com.hit.OneOrZeroKnapsackAlgoImpl;

import java.util.ArrayList;
import java.util.Collection;

//This is an implementation of the Unbounded knapsack problem
//Runtime is O(KC) where K is the number of items and C the maximum weight of the bag
// This is an implementation of the unbounded knapsack problem (every item can be selected an infinite number of times)
// @param v an array of size k representing the values of the different items
// * @param w an array of size k representing the weights of the different items
// * @param c the maximum weight allowed
// * @return a list of ids representing the items selected such that they maximize the value and do not exceed total weight C


public class UnboundedKnapsackAlgoImpl implements OneOrZeroKnapsackAlgoImpl.IAlgoKnapsack {

    @Override
    public Collection<Integer> createShoppingCart(int[] v, int[] w,
                                                  int totalWeight, int n) {
        int[] maxValues = new int[totalWeight + 1]; //stores the optimal values for the weights 0,..,c
        int[] lastSelected = new int[totalWeight + 1];
        lastSelected[0] = -1; //stores the index of the last collected item in the optimal soltuion of weights 0,...,c
        for (int i = 1; i <= totalWeight; i++) {
            //compute the optimal solution for the weight i. For every iteration (new incrementation of weight), we can add any of the items
            int index = lastSelected[i - 1];
            int maxValue = maxValues[i - 1];
            for (int j = 0; j < w.length; j++) { //the optimal solution for the weight i is the maximum between not selecting any item and the item that maximizes the value achieved without exceeding the allowed weight C
                if (w[j] <= i && v[j] + maxValues[i - w[j]] > maxValue) {
                    index = j;
                    maxValue = v[j] + maxValues[i - w[j]];
                }
            }
            maxValues[i] = maxValue;
            lastSelected[i] = index;
        }
        return collectObjects(w, lastSelected);
    }

    private static Collection<Integer> collectObjects(int[] w,
                                                      int[] selectedObjects) {
        ArrayList<Integer> collectedObjects = new ArrayList<>();
        int index = selectedObjects.length - 1;
        while (selectedObjects[index] != -1) {
            collectedObjects.add(selectedObjects[index]);
            index = index - w[selectedObjects[index]];
        }
        return collectedObjects;
    }

}

