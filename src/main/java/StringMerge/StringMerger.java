package StringMerge;

/*
    Given two strings: a and b, create a string merging the characters of alternating between a and b.
    IE:
        Given: abcd, efgh
        Return: aebfcgdh

        Given: abcdef, xyz
        Return: axbyczdef
 */
public class StringMerger {
    public static String mergeStrings(String a, String b){
        // use String buffer to build new string
        StringBuilder sb = new StringBuilder();

        // convert the strings to character arrays and find the shortest length
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int shortestLength = (a.length() < b.length() ? a.length() : b.length());

        // push until shortest array is exhausted
        for(int i = 0; i < shortestLength; i++){
            sb.append(aChars[i]).append(bChars[i]);
        }

        // if the strings were different lengths, we need to finish with the longer array
        if(a.length() != b.length()){
            // find the longer array
            char[] longestChars = (a.length() > b.length() ? aChars : bChars);
            // start at the last index
            for(int i = shortestLength; i < longestChars.length; i++){
                sb.append(longestChars[i]);
            }
        }

        return sb.toString();
    }
}