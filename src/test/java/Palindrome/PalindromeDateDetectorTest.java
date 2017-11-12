package Palindrome;

import org.junit.*;

import java.time.LocalDate;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PalindromeDateDetectorTest {
    private long methodStartTime;
    private Set<LocalDate> results;
    private String start;
    private String end;
    private static final LocalDate OCTOBER_SECOND_TWO_THOUSAND_AND_ONE = LocalDate.of(2001, 10, 2);

    @Before
    public void setup() {
        methodStartTime = System.nanoTime();
    }

    @After
    public void tearDown() {
        long duration = ((System.nanoTime() - methodStartTime) / 1000000);
        System.out.println();
        System.out.println(start + " to " + end + " took " + duration + " ms to execute");
        System.out.println("    found " + results.size() + " palindromes");
    }

    @Test
    public void testStartDateBeforeEndDateAfterSameYear() throws Exception {
        // start date before palindrome, end date after palindrome both the same year
        start = "09/09/2001";
        end = "11/11/2001";
        results = PalindromeDateDetector.findPalindromeDates(start, end);
        assertThat(results.isEmpty(), is(false));
        assertThat(results.contains(OCTOBER_SECOND_TWO_THOUSAND_AND_ONE), is(true));
    }

    @Test
    public void testStartDateAfterEndDateAfterSameYear() throws Exception {
        // start date after palindrome, end date after palindrome both the same year
        start = "10/03/2001";
        end = "11/11/2001";
        results = PalindromeDateDetector.findPalindromeDates(start, end);
        assertThat(results.isEmpty(), is(true));
        assertThat(results.contains(OCTOBER_SECOND_TWO_THOUSAND_AND_ONE), is(false));
    }

    @Test
    public void testStartDateBeforeEndDateBeforeSameYear() throws Exception {
        // start date before palindrome, end date before palindrome both the same year
        start = "09/09/2001";
        end = "10/01/2001";
        results = PalindromeDateDetector.findPalindromeDates(start, end);
        assertThat(results.isEmpty(), is(true));
        assertThat(results.contains(OCTOBER_SECOND_TWO_THOUSAND_AND_ONE), is(false));
    }

    @Test
    public void testStartDateBeforeEndDateAfterDifferentYear() throws Exception {
        // start date before palindrome, end date after palindrome both different years
        start = "09/09/0001";
        end = "11/11/3001";
        results = PalindromeDateDetector.findPalindromeDates(start, end);
        assertThat(results.isEmpty(), is(false));
        assertThat(results.contains(OCTOBER_SECOND_TWO_THOUSAND_AND_ONE), is(true));
    }

    @Test
    public void testFromJesusToBuck() throws Exception {
        start = "01/01/0001";
        end = "12/31/9999";
        results = PalindromeDateDetector.findPalindromeDates(start, end);
        assertThat(results.isEmpty(), is(false));
    }
}