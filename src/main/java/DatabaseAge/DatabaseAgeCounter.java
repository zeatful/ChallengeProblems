package DatabaseAge;

import java.util.HashMap;
import java.util.Map;

/**
 * Assume that you have a very large database table of customers.  Each customer row has an age.
 * Parse all rows of data (Assume it is provided as an Array) and get a count of every age.
 *  Note: In the actual scenario you would determine the appropriate data structure.
 */
public class DatabaseAgeCounter {
    public static Map<Integer, Integer> mapOfAgeCounts(int[] ages) {
        HashMap<Integer, Integer> mapOfAgeCounts = new HashMap<>();
        Integer currentCount;

        /*  Use count sort and store data in a HashMap
            for each age look it up in the count map,
            incrementing the value if it exists
            otherwise inserting a new entry of one
         */
        for(int i : ages){
            currentCount = mapOfAgeCounts.get(i);
            mapOfAgeCounts.put(i, currentCount != null ? currentCount+1 : 1);
        }

        return mapOfAgeCounts;
    }
}
