package com.algorithms;

import java.util.HashMap;

public class FibonnaciDP {

    private static HashMap<Integer,Integer> fibDicionoary =  new HashMap<>();

    public static void main(String[] args) {

        System.out.println(bottomUpDP(5));
    }

    private static int naiveRecursiveAlgo(int n) {
        if(n == 1 || n ==2) return  1;
        else if (n==0) return 0;
        else return naiveRecursiveAlgo(n-1) + naiveRecursiveAlgo(n-2);
    }

    private static int memonicationAlog(int n) {
        if(fibDicionoary.containsKey(n)) return fibDicionoary.get(n);
        else if(n == 1 || n ==2) return  1;
        else if (n==0) return 0;
        else {
            int sum = memonicationAlog(n - 1) + memonicationAlog(n - 2);
            fibDicionoary.put(n,sum);
            return sum;
        }

    }

    private static int bottomUpDP(int n){
        for (int i=0; i <= n; i++) {
            if(i==0) {
                int val = 0;
                fibDicionoary.put(i,val);
            } else if(i==1 || i==2) {
                int  val = 1;
                fibDicionoary.put(i,val);
            } else {
                int val = fibDicionoary.get(i-1) + fibDicionoary.get(i-2);
                fibDicionoary.put(i, val);
            }
        }
        return fibDicionoary.get(n);
    }


}
