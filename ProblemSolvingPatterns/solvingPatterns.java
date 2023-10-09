package ProblemSolvingPatterns;

import java.util.HashMap;


public class solvingPatterns {

    
    public static void main (String[] args){

        int[] arr1 = {1,2,2,3,3,3, 3};
        int [] arr2 = {1, 4, 4, 9, 9, 9};
        System.out.println(same(arr1, arr2));
    }

    // Frequency counter problem #1.
    // Write a function called same, which accepts two arrays.
    // The function should return true if every value ine the array has
    // it's corresponding value squared in the second array.
    // The frequency of values must be the same.

    

    public static boolean same (int [] array1, int [] array2){

        HashMap <Integer, Integer> frequencyCounter = new HashMap<>();
        HashMap <Integer, Integer> squaredFrequencyCounter = new HashMap<>();


        frequencyCounter = countFreqArray(array1);
        squaredFrequencyCounter = countFreqArray(array2);
        System.out.println(frequencyCounter);
        System.out.println(squaredFrequencyCounter);

        for(Integer i : frequencyCounter.keySet()){
            if(frequencyCounter.get(i) != squaredFrequencyCounter.get((int) Math.pow(i,2))){
                return false;
            }
        }
            
        return true;
    }

    // This function helps us to solve the upper problem: 
    // It iterates over the array and maps the values in the array with their frequencies.
    // Returns a HashMap 

    private static HashMap<Integer,Integer> countFreqArray (int array []) {

        HashMap <Integer, Integer> generalFreqCount = new HashMap<>();
        for(int i = 0 ; i < array.length ; i++){

            if(generalFreqCount.get(array[i]) != null)
            {
                generalFreqCount.put(array[i], generalFreqCount.get(array[i]) + 1);
            }
            else
            {
                generalFreqCount.put(array[i], 1);
            }
        }
        return generalFreqCount;
    }

    // Frequency Counter problem #2
    // Given two strings, write a function to determine if the 
    //second string is an anagram of the first. 

    public static boolean validAnagram( String str1, String str2){



        return true;
    }
}
