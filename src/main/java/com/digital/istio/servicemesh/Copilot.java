package com.digital.istio.servicemesh;

public class Copilot {
    //calculate fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    // find even numbers
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }


}
