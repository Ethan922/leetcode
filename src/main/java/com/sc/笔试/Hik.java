package com.sc.笔试;

import java.util.ArrayList;
import java.util.function.IntBinaryOperator;

public class Hik {

    enum Solution {
        /**
         * 加
         */
        ADD("+", null),
        /**
         * 减
         */
        SUB("-", null),
        /**
         * 乘
         */
        MUL("*", null),
        /**
         * 除
         */
        DIV("/", null);

        private final String symbol;
        private final IntBinaryOperator op;

        Solution(String symbol, IntBinaryOperator op) {
            this.symbol = symbol;
            this.op = op;
        }

        public int apply(int a, int b) {
            switch (this.symbol) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    return a / b;
            }
            return 0;
        }
    }

    public int getPosition(int m, int k, ArrayList<Integer> number) {
        int n = number.size();
        int[] arr = new int[n];
        arr[0] = number.get(0);
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + number.get(i);
        }
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % m == k) {
                ans = i;
            }
        }
        return ans;
    }

}
