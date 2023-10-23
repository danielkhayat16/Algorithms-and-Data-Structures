package Recursion;

public class recursion {

    public static void main(String[] args) {

        int[] arr1 = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Test Problem #3: " + (productOfArray(arr1) == (6 * 5 * 4 * 3 * 2) ? "Check" : "Wrong"));
        System.out.println("Test Problem #4: " + (fib(10) == 55 ? "Check" : "Wrong"));
        System.out.println("Test problem #5: " + (reverse("daniel").equals("leinad") ? "Check" : "Wrong"));

    }

    // Problem #1
    // Write a function called power which accepts a base and an exponent. The
    // function should return the power of the base to the exponent.
    public static int power(int base, int exponent) {
        if (exponent == 0)
            return 1;

        return base * power(base, exponent - 1);
    }

    // Problem #2
    // Write a function factorial which accepts a number and returns the factorial
    // of that number.

    public static int factorial(int num) {
        if (num == 0)
            return 1;
        return num * factorial(num - 1);
    }

    // Problem #3
    // Write a function called productOfArray which takes in an array of numbers and
    // returns the product of them all.

    public static int productOfArray(int[] arr) {
        return productOfArray(arr, 0);

    }

    // Helper for problem #3
    private static int productOfArray(int[] arr, int i) {
        if (i == arr.length)
            return 1;
        return arr[i] * productOfArray(arr, i + 1);
    }

    // Problem #4
    // Write a function called recursiveRange which accepts a number and adds up all
    // the numbers from 0 to the number passed to the function

    public static int recursiveRange(int num) {
        if (num == 1)
            return 1;
        return num * recursiveRange(num - 1);
    }

    public static int fib(int num) {
        if (num == 1 || num == 2)
            return 1;
        return fib(num - 1) + fib(num - 2);
    }

    // Problem # 5
    // Write a recursive function called reverse which accepts a string and returns
    // a new string in reverse.

    public static String reverse(String str) {
        if (str.length() == 1)
            return str;
        return str.substring(str.length() - 1, str.length()) + reverse(str.substring(0, str.length() - 1));
    }

}
