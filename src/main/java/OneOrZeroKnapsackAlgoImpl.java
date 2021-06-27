package main.java;

import java.util.ArrayList;
import java.util.Collection;

public class OneOrZeroKnapsackAlgoImpl implements IAlgoKnapsack {
        // the items which are put
        // in a knapsack of capacity W

    @Override
        public Collection<Integer>  buildShoppingCart(int[] v, int[] w, int totalWeight , int n)
        {
            ArrayList<Integer> collectedObjects = new ArrayList<>();
            try
            {
                int i, wi;
                int K[][] = new int[n + 1][totalWeight + 1];
                if (totalWeight <= 0)
                {
                    throw new Exception();
                }
                // Build table K[][] in bottom up manner
                for (i = 0; i <= n; i++) {
                    for (wi = 0; wi <= totalWeight; wi++) {
                        if (i == 0 || wi == 0)
                            K[i][wi] = 0;
                        else if (w[i - 1] <= wi)
                            K[i][wi] = Math.max(v[i - 1] +
                                    K[i - 1][wi - w[i - 1]], K[i - 1][wi]);
                        else
                            K[i][wi] = K[i - 1][wi];
                    }
                }
                // stores the result of Knapsack
                int res = K[n][totalWeight];
                wi = totalWeight;
                for (i = n; i > 0 && res > 0; i--) {

                    // either the result comes from the top
                    // (K[i-1][w]) or from (val[i-1] + K[i-1]
                    // [w-wt[i-1]]) as in Knapsack table. If
                    // it comes from the latter one/ it means
                    // the item is included.
                    if (res == K[i - 1][wi])
                        continue;
                    else {

                        // This item is included.
                        collectedObjects.add(i - 1);
                        // Since this weight is included its
                        // value is deducted
                        res = res - v[i - 1];
                        wi = wi - w[i - 1];
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Can't run the algo with total weight less or equal to zero.");
            }

            return collectedObjects;
        }
    }


