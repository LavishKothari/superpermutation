package superpermutation;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SuperPermutationTest {

    private static SuperPermutation superPermutation;

    @BeforeClass
    public static void setup() {
        superPermutation = new SuperPermutation();
    }

    @Test
    public void testGetWeight() {
        Assert.assertEquals(8, superPermutation.getWeight("abcde", "dexyz"));
        Assert.assertEquals(6, superPermutation.getWeight("abc", "xyz"));
        Assert.assertEquals(2, superPermutation.getWeight("ab", "ab"));
        Assert.assertEquals(5, superPermutation.getWeight("abc", "cba"));
        Assert.assertEquals(6, superPermutation.getWeight("abxy", "xyab"));
        Assert.assertEquals(4, superPermutation.getWeight("acb", "cba"));
        Assert.assertEquals(6, superPermutation.getWeight("acb", "abc"));
    }

    @Test
    public void testGetCondensedStringTest() {
        Assert.assertEquals("abcdxy",
                superPermutation.getCondensedString("abcd", "cdxy"));
        Assert.assertEquals("abcd",
                superPermutation.getCondensedString("abcd", "cd"));
        Assert.assertEquals("abcd",
                superPermutation.getCondensedString("abcd", ""));
        Assert.assertEquals("abcdwxyz",
                superPermutation.getCondensedString("abcd", "wxyz"));
        Assert.assertEquals("abcda",
                superPermutation.getCondensedString("abcd", "cda"));
        Assert.assertEquals("cdacdxyz",
                superPermutation.getCondensedString("cda", "dacdxyz"));
        Assert.assertEquals("cdacdxyz",
                superPermutation.getCondensedString("cda", "cdacdxyz"));
        Assert.assertEquals("abcdefgh",
                superPermutation.getCondensedString("abcd", "abcdefgh"));
    }
}
