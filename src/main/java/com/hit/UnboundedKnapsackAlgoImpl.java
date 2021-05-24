package main.java.com.hit;


// Java program to find maximum achievable
// value with a knapsack of weight W and
// multiple instances allowed.

public class UnboundedKnapsackAlgoImpl
    {

        // Returns the maximum value with knapsack
        // of W capacity
        private static int unboundedKnapsack(int W, int n, int[] val, int[] wt)
        {
             int w;
            // dp[i] is going to store maximum value
            // with knapsack capacity i.
            int dp[] = new int[W + 1];

            // Fill dp[] using above recursive formula
            for(int i = 0; i <= W; i++){
                for(int j = 0; j < n; j++){
                    if(wt[j] <= i){
                        dp[i] = Math.max(dp[i], dp[i - wt[j]] +
                                val[j]);
                    }
                }
            }
//            // dp[val.length+1][sackWeight+1] is the matrix for caching.
//            // val[] is the array that stores the values of the objects
//            // and wt[] is the array that stores the weight of the corresponding objects.
//            int x = val.length, y = W;
//            while (x > 0 && y > 0) {
//                if (dp[x][y] == dp[x - 1][y])
//                    x--;
//                else if (dp[x - 1][y] >= dp[x][y - wt[x - 1]] + val[x - 1])
//                    x--;
//                else {
//                    System.out.println("including wt " + wt[x - 1] + " with value " + val[x - 1]);
//                    y -= wt[x - 1];
//                }
//            }
            return dp[W];
        }

        // Driver program
        public static void main(String[] args)
        {
            int W = 100;
            int val[] = {10, 30, 20};
            int wt[] = {5, 10, 15};
            int n = val.length;
            System.out.println(unboundedKnapsack(W, n, val, wt));
        }
    }

