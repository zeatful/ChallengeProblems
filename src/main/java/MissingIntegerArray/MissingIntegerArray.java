package MissingIntegerArray;

public class MissingIntegerArray {
    /*
    * You are passed an array of sequential numbers start at 1, but one number is missing in the sequence.
    * How can you determine the missing number?
    * */
    public static int checkForMissingValue(int[] arrayToCheck){
        // check the last index to see if it is the same as the index -1
        int lastIndex = arrayToCheck.length-1;
        int lastElement = arrayToCheck[lastIndex];

        // return 0 if no number is missing
        if(lastElement == arrayToCheck.length) {
            return 0;
        } else {
            // track previous index
            int previousIndex = lastIndex;

            // iterate backwards checking array values to their index
            for(int i = lastIndex; i >= 0; i--) {
                if (i != arrayToCheck[i]-1){
                    previousIndex = i;
                }
            }

            return previousIndex + 1;
        }
    }
}
