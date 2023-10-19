package ProblemSolvingPatterns;

import java.util.HashMap;


public class solvingPatterns {

    
    public static void main (String[] args){

        int[] arr1 = {1,2,2,3,3,3, 3};
        int [] arr2 = {1,1, 4, 4, 9, 9, 9};
        int [] arr3 = {-4,4,5,6,10,11,14};
        System.out.println(same(arr1, arr2));

        String str1 = "Daniel";
        String str2 = "lienaD";
        System.out.println(validAnagram(str1, str2));
        
        int [] sum = sumZero(arr3);
        System.out.println("[" + sum[0] + "," + sum[1] + "]");

        int num = countUniqueValues(arr1);
        System.out.println(num);
        
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


        if(str1.length() != str2.length()) return false;
        
        HashMap <Character, Integer> firstStringFrequencies = new HashMap<>();
        HashMap <Character, Integer> secondStringFrequencies = new HashMap<>();
        firstStringFrequencies = countFreqString(str1);
        secondStringFrequencies = countFreqString(str2);
        
        if(firstStringFrequencies.size() != secondStringFrequencies.size()) return false;

        for (Character s : firstStringFrequencies.keySet()){
            if(firstStringFrequencies.get(s) != secondStringFrequencies.get(s)) return false;
        }

        return true;
    }
    

    // This function helps to iterate over Strings and return a Hashmap of the frequencies.
    private static HashMap <Character, Integer> countFreqString (String str){

        HashMap <Character, Integer> stringFrequencies = new HashMap<>();

        for (int i = 0; i < str.length(); i++){

            if(stringFrequencies.get(str.charAt(i)) == null) stringFrequencies.put(str.charAt(i), 1);
            else stringFrequencies.put(str.charAt(i), 1);
        }

        return stringFrequencies;

    }

    public static int[] sumZero (int [] arr){
        int [] zeroSum = {0,0};
        int high, low;
        if(arr.length != 0){
            low = 0;
            high = arr.length - 1;
        }
        else return null;

        while(low <= high)
        {
            if((arr[low] + arr[high]) == 0)    
                {
                    zeroSum[0] = arr[low];
                    zeroSum[1] = arr[high];
                    return zeroSum;
                }
            else if((arr[low] + arr[high]) < 0)
                low ++;
            else
                high --;
        }
    

        return  null;
    }

    public static int countUniqueValues (int [] arr){

        if(arr.length == 0) return 0;
        
        int count = 1;
        int i = 0;
        for(int j = 1; j < arr.length; j ++){
            if(arr[i] == arr[j]) j ++;
            else {
                i = j;
                count++;
            }
        
        }


        return count;
    }
}
