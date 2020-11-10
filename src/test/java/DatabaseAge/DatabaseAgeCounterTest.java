package DatabaseAge;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DatabaseAgeCounterTest {
    private int[] generateArray() {
        int[] ages = new int[100000];
        for (int i = 0; i < 100000; i++) {
            ages[i] = ThreadLocalRandom.current().nextInt(1, 120);
        }
        return ages;
    }

    // verify the time performance using the generateArray set
    @Test
    public void testLargeDataSet() throws Exception {
        long methodStartTime = System.nanoTime();
        int[] ages = generateArray();
        Map<Integer,Integer> map = DatabaseAgeCounter.mapOfAgeCounts(ages);
        long duration = ((System.nanoTime() - methodStartTime) / 1000000);
        System.out.println("DataSet of " + ages.length + " took " + duration + " ms to execute");
        assertTrue(duration < 300);

        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    // verify an map we create
    @Test
    public void testSimpleAges() throws Exception {
        int[] ages = {1, 1, 2, 58, 102, 38, 10, 10, 20, 22, 23, 24, 102, 120, 15, 12, 8, 3, 33, 36, 20, 18, 4};
        Map<Integer, Integer> results = DatabaseAgeCounter.mapOfAgeCounts(ages);
        assertThat(results.get(1), is(2));
        assertThat(results.get(2), is(1));
        assertThat(results.get(58), is(1));
        assertThat(results.get(2), is(1));
        assertThat(results.get(10), is(2));
    }
}