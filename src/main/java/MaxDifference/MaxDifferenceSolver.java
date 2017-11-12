package MaxDifference;

/**
 * Find the maximum difference between elements in an array.  The max difference is the largest element minus the smallest element that proceeds it in the array.
 * If no such number exists, then return -1;
 */
public class MaxDifferenceSolver {
    public static int findMaxDifference(int[] a) {
        // grab the end index
        int end = a.length - 1;
        // default largest and smallest to the last element
        int largestValue = a[end];
        int smallestValue = a[end-1];

        // track the largest index since the smallest value must occur before the largest
        int largestIndex = end;

        // iterate in the reverse
        for(int i = end-1; i >= 0; i--){
            // if the element is larger, then track the largest value and index
            if(a[i] > largestValue){
                largestValue = a[i];
                largestIndex = i;
                // if the first element is the largest, we should return -1
                if(i == 0){
                    return -1;
                }

                // otherwise shift to a new default smaller value (since it must occur prior to the largest)
                smallestValue = a[i-1];
            }

            // if the element occurs before the largest and is smaller, update the smallest value
            if(i < largestIndex && a[i] < smallestValue){
                smallestValue = a[i];
            }
        }

        // return the difference of the final smallest and largest if they are not the same value
        return largestValue != smallestValue ? (largestValue - smallestValue) : -1;
    }
}
