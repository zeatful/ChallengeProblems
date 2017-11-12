package Anagram;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramDetectorTest {
    @Test
    public void areAnagrams() throws Exception {
        assertTrue(AnagramDetector.areAnagrams("CAT", "CTA"));
        assertFalse(AnagramDetector.areAnagrams("CAT", "ABC"));
    }
}