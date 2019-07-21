package com.mediastep.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        //int2Binary();
        //swap();
        //countPairs();
//        countPairs1();
//        findSwapValues();
//        findSwapValues1();
        findCharactersPairs();
    }

    private static void int2Binary() {
        int number = 10;
        System.out.println(Integer.toBinaryString(number));

        StringBuilder builder = new StringBuilder();
        while (number > 0) {
            builder.append(number % 2);
            number /= 2;
        }
        System.out.println(builder.reverse());
    }

    private static void swap() {
        int x = 10, y = 5;
        System.out.println("[BEFORE] x = " + x + ", y = " + y);

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("[AFTER PLUS] x = " + x + ", y = " + y);

        x = 10;
        y = 5;
        x = x * y;
        y = x / y;
        x = x / y;
        System.out.println("[AFTER MULTIPLY] x = " + x + ", y = " + y);

        x = 10;
        y = 5;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("[AFTER XOR] x = " + x + ", y = " + y);
    }

    private static void countPairs() {
        int A[] = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};//{1, 5, 7, -1, 5};//{1, 5, 7, -1};
        int sum = 11;//6;
        int count = 0;

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] == sum) {
                    count++;
                }
            }
        }
        System.out.println("count: " + count);

        count = 0;
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int temp = sum - A[i];
            if (s.contains(temp)) {
                count++;
            }
            s.add(A[i]);
        }
        System.out.println("count by hash: " + count);
    }

    static void countPairs1() {
        int A1[] = {1, 1, 3, 4, 5, 6, 6}, A2[] = {1, 4, 4, 5, 7}, K = 10;
        // Initialize pairs to 0
        int res = 0;

        // create map of elements of array A1
        Map<Integer, Integer> m = new HashMap<>();
        /*for (int i = 0; i < A1.length; ++i)
        {
            if(m.containsKey(A1[i]))
                m.put(A1[i], m.get(A1[i]) + 1);
            else
                m.put(A1[i], 1);
        }*/

        for (int n1 : A1) {
            m.merge(n1, 1, Integer::sum);
        }


        // count total pairs
        for (int i = 0; i < A2.length; ++i) {
            int temp = K - A2[i];

            if (m.containsKey(temp) && m.get(temp) != 0) {
                res++;

                // Every element can be part
                // of at most one pair.
                m.put(temp, m.get(A1[i]) - 1);
            }
        }

        // return total pairs
        System.out.println(res);
    }

    // Function to calculate sum of elements of array
    static int getSum(int X[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += X[i];
        return sum;
    }

    // Function to prints elements to be swapped
    static void findSwapValues() {
        int A[] = {4, 1, 2, 1, 1, 2};
        int B[] = {3, 6, 3, 3};
        int n = A.length, m = B.length;

        // Calculation of sums from both arrays
        int sum1 = getSum(A, n);
        int sum2 = getSum(B, m);

        // Look for val1 and val2, such that
        // sumA - val1 + val2 = sumB - val2 + val1
        int newsum1, newsum2, val1 = 0, val2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newsum1 = sum1 - A[i] + B[j];
                newsum2 = sum2 - B[j] + A[i];
                if (newsum1 == newsum2) {
                    val1 = A[i];
                    val2 = B[j];
                }
            }
        }
        System.out.println(val1 + " " + val2);
    }

    // Function to calculate : a - b = (sumA - sumB) / 2
    static int getTarget(int A[], int n, int B[], int m) {
        // Calculation of sums from both arrays
        int sum1 = getSum(A, n);
        int sum2 = getSum(B, m);

        // because that the target must be an integer
        if ((sum1 - sum2) % 2 != 0)
            return 0;
        return ((sum1 - sum2) / 2);
    }


    static void findSwapValues1() {
        int A[] = {4, 1, 2, 1, 1, 2};
        int B[] = {3, 6, 3, 3};
        int n = A.length, m = B.length;

        HashSet<Integer> s = new HashSet<>();
        for (int a : A) {
            s.add(a);
        }

        int sum1 = getSum(A, n);
        int sum2 = getSum(B, m);

        int diff = (sum1 - sum2) / 2;
        for (int b : B) {
            if (s.contains(b + diff)) {
                System.out.println("with hasing: " + (b + diff) + " " + b);
                break;
            }
        }
    gi
    static void findCharactersPairs() {
        char A[] = {'a', 'a', 'a', 'a', 'b', 'f', 'c', 'f', 'b', 'b', 'c', 'c', 'c'};
//        char A[] = {'e', 'a', 'c', 'd', 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c'};
//  e,a c,d a,b a,b a,b
//        a,e a,c a,d a,b b,c b,c
        Map<Character, Integer> m = new HashMap<>();
        for (char c : A) {
            m.merge(c, 1, Integer::sum);
        }

        m.forEach((k, v) -> {
            System.out.println("k: " + k + "; v: " + v);

        });

        int count = 0;
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            Character c = q.peek();
            if (c != null && c != A[i]) {
                q.remove();
                count++;
            } else {
                q.add(A[i]);
            }
        }
        System.out.println(count);
    }
}
