package MaxDifference;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaxDifferenceTest {
    @Test
    public void findMaxDifference() throws Exception {
        int[] inputArray = {2, 3, 10, 2, 4, 8, 1};
        int result = MaxDifferenceSolver.findMaxDifference(inputArray);
        assertThat(result, is(8));

        int[] inputArray2 = {7, 9, 5, 6, 3, 2};
        result = MaxDifferenceSolver.findMaxDifference(inputArray2);
        assertThat(result, is(2));

        int[] inputArray3 = {10, 9, 8, 7, 7, 2};
        result = MaxDifferenceSolver.findMaxDifference(inputArray3);
        assertThat(result, is(-1));

        int[] inputArray4 = {1,1,1,1,1};
        result = MaxDifferenceSolver.findMaxDifference(inputArray4);
        assertThat(result, is(-1));
    }
}