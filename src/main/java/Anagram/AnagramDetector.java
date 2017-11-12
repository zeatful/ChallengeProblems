package Anagram;

import java.util.HashMap;

/*
    Two strings: a and b, are called anagrams if they contain all the same characters in the same frequencies.
    For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.
    Create a function to determine if two strings are case-insensitive anagrams
    return true if they are otherwise return false
*/
public class AnagramDetector {
    public static boolean areAnagrams(String a, String b) {
        // if strings are not same size, they are not anagrams
        if (a.length() != b.length()) {
            return false;
        }

        // store a HashMap for each string with the count of characters
        HashMap<Character, Integer> characterCountOfA = new HashMap<>();
        HashMap<Character, Integer> characterCountOfB = new HashMap<>();

        // convert each string ot a character array
        char[] characterArrayA = a.toCharArray();
        char[] characterArrayB = b.toCharArray();

        // values that will be used to iterate
        Integer currentCount;
        char currentChar;

        // iterate over the length of one string since they must be the same length
        for (int i = 0; i < a.length(); i++) {
            // get the current character, check if it has a count and update it and insert a new entry of 1 if it does not already exist
            currentChar = characterArrayA[i];
            currentCount = characterCountOfA.get(currentChar);
            characterCountOfA.put(currentChar, currentCount == null ? 1 : currentCount + 1);

            currentChar = characterArrayB[i];
            currentCount = characterCountOfB.get(currentChar);
            characterCountOfB.put(currentChar, currentCount == null ? 1 : currentCount + 1);
        }

        // the HashMaps should be exactly the same if they are anagrams
        return characterCountOfA.equals(characterCountOfB);
    }
}
