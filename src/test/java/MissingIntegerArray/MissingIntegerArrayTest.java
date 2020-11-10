package MissingIntegerArray;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MissingIntegerArrayTest {

    @Test
    public void testNoMissingIntegerOne() {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int missingNumber = MissingIntegerArray.checkForMissingValue(numbers);
        assertThat(missingNumber, is(0));
    }

    @Test
    public void testMiddleNumberMissing() {
        int[] numbers = {1,2,3,4,5,7,8,9,10,11};
        int missingNumber = MissingIntegerArray.checkForMissingValue(numbers);
        assertThat(missingNumber, is(6));
    }

    @Test
    public void testMissingSecondToLastInteger() {
        int[] numbers = {1,2,3,4,5,6,7,8,9,11};
        int missingNumber = MissingIntegerArray.checkForMissingValue(numbers);
        assertThat(missingNumber, is(10));
    }

    @Test
    public void testMissingSecondInteger() {
        int[] numbers = {1,3,4,5,6,7,8,9,10};
        int missingNumber = MissingIntegerArray.checkForMissingValue(numbers);
        assertThat(missingNumber, is(2));
    }

}