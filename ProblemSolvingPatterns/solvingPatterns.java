package ProblemSolvingPatterns;

import java.util.HashMap;

public class solvingPatterns {

    public static void main(String[] args) {

        int[] arr1 = { 1, 2, 2, 3, 3, 3, 1 };
        int[] arr2 = { 1, 1, 4, 4, 9, 9, 9 };
        int[] arr3 = { -4, 4, 5, 6, 10, 11, 14 };
        System.out.println("Test problem #1: " + (same(arr1, arr2) ? "Check" : "X"));

        String str1 = "Daniel";
        String str2 = "lienaD";
        System.out.println("Test problem #2: " + (validAnagram(str1, str2) == true ? "Check" : "X"));

        int[] sum = sumZero(arr3);
        System.out.println("Test problem #3: " + (sum[0] + sum[1] == 0 ? "Check" : "Wrong"));

        int num = countUniqueValues(arr1);
        System.out.println("Test problem #4: " + (3 == num ? "Check" : "Wrong"));
        System.out.println("Test problem #5: " + (maxSubarraySum(arr3, 3) == 35 ? "Check" : "Wrong"));
        System.out.println(
                "Test problem #6: " + (sameFrequency(282, 822) && (sameFrequency(3456, 6543)) ? "Check" : "Wrong"));

        System.out.println(
                "Test problem #7: " + (areThereDuplicateOne(3, 4, 5, 4, 3, "str", "sft", "str") ? "Check" : "Wrong"));

    }

    // Frequency counter problem #1.
    // Write a function called same, which accepts two arrays.
    // The function should return true if every value ine the array has
    // it's corresponding value squared in the second array.
    // The frequency of values must be the same.

    public static boolean same(int[] array1, int[] array2) {

        HashMap<Integer, Integer> frequencyCounter = new HashMap<>();
        HashMap<Integer, Integer> squaredFrequencyCounter = new HashMap<>();

        frequencyCounter = countFreqArray(array1);
        squaredFrequencyCounter = countFreqArray(array2);

        for (Integer i : frequencyCounter.keySet()) {
            if (frequencyCounter.get(i) != squaredFrequencyCounter.get((int) Math.pow(i, 2))) {
                return false;
            }
        }

        return true;
    }

    // This function helps us to solve the upper problem:
    // It iterates over the array and maps the values in the array with their
    // frequencies.
    // @return HashMap

    private static HashMap<Integer, Integer> countFreqArray(int array[]) {

        HashMap<Integer, Integer> generalFreqCount = new HashMap<>();
        for (int i = 0; i < array.length; i++) {

            if (generalFreqCount.get(array[i]) != null) {
                generalFreqCount.put(array[i], generalFreqCount.get(array[i]) + 1);
            } else {
                generalFreqCount.put(array[i], 1);
            }
        }
        return generalFreqCount;
    }

    // Frequency Counter problem #2
    // Given two strings, write a function to determine if the
    // second string is an anagram of the first.

    public static boolean validAnagram(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;
        HashMap<Character, Integer> firstStringFrequencies = new HashMap<>();
        HashMap<Character, Integer> secondStringFrequencies = new HashMap<>();
        firstStringFrequencies = countFreqString(str1);
        secondStringFrequencies = countFreqString(str2);
        if (firstStringFrequencies.size() != secondStringFrequencies.size())
            return false;
        for (Character s : firstStringFrequencies.keySet()) {
            if (firstStringFrequencies.get(s) != secondStringFrequencies.get(s))
                return false;
        }
        return true;
    }

    // This function helps to iterate over Strings and return a Hashmap of the
    // frequencies.

    private static HashMap<Character, Integer> countFreqString(String str) {

        HashMap<Character, Integer> stringFrequencies = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            if (stringFrequencies.get(str.charAt(i)) == null)
                stringFrequencies.put(str.charAt(i), 1);
            else
                stringFrequencies.put(str.charAt(i), 1);
        }

        return stringFrequencies;

    }

    // Problem #3: This function check if there are two numbers int the given array
    // that sums to 0.
    // It uses the multiple pointers pattern to solve the problem in a O(n) time
    // complexity.
    // @return array of the two numbers.
    public static int[] sumZero(int[] arr) {
        int[] zeroSum = { 0, 0 };
        int high, low;
        if (arr.length != 0) {
            low = 0;
            high = arr.length - 1;
        } else
            return null;

        while (low <= high) {
            if ((arr[low] + arr[high]) == 0) {
                zeroSum[0] = arr[low];
                zeroSum[1] = arr[high];
                return zeroSum;
            } else if ((arr[low] + arr[high]) < 0)
                low++;
            else
                high--;
        }
        return null;
    }

    // Problem #4: This function iterates over the given array and return the number
    // of unique values in the array.
    // It uses the multiple pointers pattern to solve it with O(n) time complexity.
    // @return count - The number of unique values in the array.

    public static int countUniqueValues(int[] arr) {

        if (arr.length == 0)
            return 0;

        int count = 1;
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] == arr[j])
                j++;
            else {
                i = j;
                count++;
            }

        }
        return count;
    }

    // Problem #5: Write a function called maxSubarraySum which
    // accepts an array of integers and a number n.
    // The function should calculate the maximum sum of n consecutive
    // elements in the array.
    // It makes use of the sliding window pattern
    // @return The maximum sum of n consecutive elements.

    public static int maxSubarraySum(int[] arr, int n) {
        int temp = 0;
        if (arr.length == 0)
            return 0;

        for (int i = 0; i < n; i++) {
            temp += arr[i];
        }
        int max = temp;
        for (int j = 0; j < arr.length - n; j++) {
            temp = temp - arr[j] + arr[n + j];
            if (max < temp) {
                max = temp;
            }

        }
        return max;
    }

    /*
     * Problem #6
     * Write a function called sameFrequency.
     * Given two positive integers, find out if the two numbers have the same
     * frequency of digits.
     * Time Complexity : O(n)
     * 
     * @return Boolean value
     */
    public static boolean sameFrequency(int num1, int num2) {
        HashMap<Integer, Integer> firstNumDigitsFreq = digitMap(num1);
        HashMap<Integer, Integer> scdNumDigitsFreq = digitMap(num2);
        for (int i : firstNumDigitsFreq.keySet()) {
            if (firstNumDigitsFreq.get(i) != scdNumDigitsFreq.get(i))
                return false;
        }
        return true;
    }

    /*
     * Private function that maps the digit of a given number.
     * 
     * @return HashMap <Integer, Integer>
     */

    private static HashMap<Integer, Integer> digitMap(int num) {
        HashMap<Integer, Integer> digitFrequencies = new HashMap<>();
        int dividedNum = num;
        int currDigit = 0;
        while (dividedNum > 0) {
            currDigit = dividedNum % 10;
            if (digitFrequencies.get(currDigit) != null) {
                digitFrequencies.put(currDigit, digitFrequencies.get(currDigit) + 1);
            } else {
                digitFrequencies.put(currDigit, 1);
            }
            dividedNum = dividedNum / 10;
        }
        return digitFrequencies;
    }

    public static boolean areThereDuplicateOne(Object... args) {

        HashMap<Object, Integer> argumentsMap = mapArray(args);
        for (Object obj : args) {
            if (argumentsMap.get(obj) != 1)
                return true;
        }

        return false;

    }

    private static HashMap<Object, Integer> mapArray(Object[] args) {

        HashMap<Object, Integer> map = new HashMap<>();

        for (Object object : args) {

            if (map.get(object) == null)
                map.put(object, 1);
            else
                map.put(object, (map.get(object) + 1));
        }
        return map;
    }

}

// 0585588464 - יציק ספרי זןהר