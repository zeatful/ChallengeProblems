package StringMerge;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringMergerTest {
    @Test
    public void mergeStrings() throws Exception {
        String result = StringMerger.mergeStrings("abc", "def");
        assertThat(result, is("adbecf"));

        result = StringMerger.mergeStrings("ab", "zsd");
        assertThat(result, is("azbsd"));
    }
}