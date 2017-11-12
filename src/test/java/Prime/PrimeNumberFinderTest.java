package Prime;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PrimeNumberFinderTest {
    private long methodStartTime;

    @Before
    public void setup() {
        methodStartTime = System.nanoTime();
    }

    @After
    public void tearDown() {
        long duration = ((System.nanoTime() - methodStartTime) / 1000000);
        System.out.println();
        System.out.println("executed in " + duration + " ms");
    }

    @Test
    public void isOnePrime() throws Exception {
        // test some none primes
        assertThat(PrimeNumberFinder.isPrime(1), is(false));
    }

    @Test
    public void isFourPrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(4), is(false));
    }

    @Test
    public void isFiveFortyFourPrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(544), is(false));
    }

    @Test
    public void isTenFiftySevenThirtyFourPrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(105734), is(false));
    }

    @Test
    public void isOneThirtyTenEightTwoPrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(1301082), is(false));
    }

    @Test
    public void isOneSeventyNineFourTwentySixFiveFortyEightPrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(179426548), is(false));
    }

    // primes in increasing size
    @Test
    public void isTwoPrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(2), is(true));
    }

    @Test
    public void isThreePrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(3), is(true));
    }

    @Test
    public void isFivePrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(5), is(true));
    }

    @Test
    public void isFiveFortyOnePrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(541), is(true));
    }

    @Test
    public void isOneOFiveSevenThirtyThreePrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(105733), is(true));
    }

    @Test
    public void isOneThirtyTenEightOnePrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(1301081), is(true));
    }

    @Test
    public void isOneSeventyNineFourTwentySixFiveFortyNinePrime() throws Exception {
        assertThat(PrimeNumberFinder.isPrime(179426549), is(true));
    }
}