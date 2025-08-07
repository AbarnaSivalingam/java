package com.study;
public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double futureValueRecursive(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        return futureValueRecursive(initialValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Optimized recursive method with memoization (to avoid redundant computation)
    public static double futureValueMemo(double initialValue, double growthRate, int years, Double[] memo) {
        if (years == 0) {
            return initialValue;
        }
        if (memo[years] != null) {
            return memo[years];
        }
        memo[years] = futureValueMemo(initialValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;    // Starting amount
        double growthRate = 0.05;        // 5% annual growth
        int years = 10;

        // Simple Recursive Calculation
        double resultRecursive = futureValueRecursive(initialValue, growthRate, years);
        System.out.printf("Future Value (Recursive): %.2f\n", resultRecursive);

        // Optimized Recursive with Memoization
        Double[] memo = new Double[years + 1];
        double resultMemoized = futureValueMemo(initialValue, growthRate, years, memo);
        System.out.printf("Future Value (Memoized): %.2f\n", resultMemoized);
    }
}


