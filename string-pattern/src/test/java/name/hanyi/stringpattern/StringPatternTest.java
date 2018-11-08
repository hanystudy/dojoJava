package name.hanyi.stringpattern;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class StringPatternTest {

    @Test
    public void testCharacterClass() {
        String pattern = "[bcr]at";
        assertThat(StringPattern.match("bat", pattern), hasItem("bat"));
        assertThat(StringPattern.match("cat", pattern), hasItem("cat"));
        assertThat(StringPattern.match("rat", pattern), hasItem("rat"));
        assertTrue(StringPattern.match("hat", pattern).isEmpty());
    }

    @Test
    public void testNegation() {
        String pattern = "[^bcr]at";
        assertTrue(StringPattern.match("bat", pattern).isEmpty());
        assertTrue(StringPattern.match("cat", pattern).isEmpty());
        assertTrue(StringPattern.match("rat", pattern).isEmpty());
        assertThat(StringPattern.match("hat", pattern), hasItem("hat"));
    }

    @Test
    public void testRanges() {
        String pattern = "[a-c]";
        assertThat(StringPattern.match("a", pattern), hasItem("a"));
        assertThat(StringPattern.match("b", pattern), hasItem("b"));
        assertThat(StringPattern.match("c", pattern), hasItem("c"));
        assertTrue(StringPattern.match("d", pattern).isEmpty());
        pattern = "foo[1-5]";
        assertThat(StringPattern.match("foo1", pattern), hasItem("foo1"));
        assertThat(StringPattern.match("foo5", pattern), hasItem("foo5"));
        assertTrue(StringPattern.match("foo6", pattern).isEmpty());
        pattern = "foo[^1-5]";
        assertTrue(StringPattern.match("foo1", pattern).isEmpty());
        assertThat(StringPattern.match("foo6", pattern), hasItem("foo6"));
    }

    @Test
    public void testUnions() {
        String pattern = "[0-4[6-8]]";
        assertThat(StringPattern.match("0", pattern), hasItem("0"));
        assertTrue(StringPattern.match("5", pattern).isEmpty());
        assertThat(StringPattern.match("6", pattern), hasItem("6"));
        assertThat(StringPattern.match("8", pattern), hasItem("8"));
        assertTrue(StringPattern.match("9", pattern).isEmpty());
    }

    @Test
    public void testIntersections() {
        String pattern = "[0-9&&[345]]";
        assertThat(StringPattern.match("3", pattern), hasItem("3"));
        assertThat(StringPattern.match("4", pattern), hasItem("4"));
        assertThat(StringPattern.match("5", pattern), hasItem("5"));
        assertTrue(StringPattern.match("2", pattern).isEmpty());
        assertTrue(StringPattern.match("6", pattern).isEmpty());
        pattern = "[2-8&&[4-6]]";
        assertTrue(StringPattern.match("3", pattern).isEmpty());
        assertThat(StringPattern.match("4", pattern), hasItem("4"));
        assertThat(StringPattern.match("5", pattern), hasItem("5"));
        assertThat(StringPattern.match("6", pattern), hasItem("6"));
        assertTrue(StringPattern.match("7", pattern).isEmpty());
    }

    @Test
    public void testSubstraction() {
        String pattern = "[0-9&&[^345]]";
        assertThat(StringPattern.match("2", pattern), hasItem("2"));
        assertTrue(StringPattern.match("3", pattern).isEmpty());
        assertTrue(StringPattern.match("4", pattern).isEmpty());
        assertTrue(StringPattern.match("5", pattern).isEmpty());
        assertThat(StringPattern.match("6", pattern), hasItem("6"));
        assertThat(StringPattern.match("9", pattern), hasItem("9"));
    }

    @Test
    public void testPredefinedCharacterClass() {
        String pattern = ".";
        assertThat(StringPattern.match("@", pattern), hasItem("@"));
        assertThat(StringPattern.match("1", pattern), hasItem("1"));
        assertThat(StringPattern.match("a", pattern), hasItem("a"));
        pattern = "\\d";
        assertThat(StringPattern.match("1", pattern), hasItem("1"));
        assertTrue(StringPattern.match("a", pattern).isEmpty());
        pattern = "\\D";
        assertThat(StringPattern.match("a", pattern), hasItem("a"));
        assertTrue(StringPattern.match("1", pattern).isEmpty());
        pattern = "\\s";
        assertThat(StringPattern.match(" ", pattern), hasItem(" "));
        assertTrue(StringPattern.match("a", pattern).isEmpty());
        pattern = "\\S";
        assertThat(StringPattern.match("a", pattern), hasItem("a"));
        assertTrue(StringPattern.match(" ", pattern).isEmpty());
        pattern = "\\w";
        assertThat(StringPattern.match("a", pattern), hasItem("a"));
        assertTrue(StringPattern.match("!", pattern).isEmpty());
        pattern = "\\W";
        assertThat(StringPattern.match("!", pattern), hasItem("!"));
        assertTrue(StringPattern.match("a", pattern).isEmpty());
    }

    @Test
    public void testQuantifiers() {
        String pattern = "a?";
        assertThat(StringPattern.match("", pattern), hasItem(""));
        pattern = "a*";
        assertThat(StringPattern.match("", pattern), hasItem(""));
        pattern = "a+";
        assertTrue(StringPattern.match("", pattern).isEmpty());
    }

    @Test
    public void testZeroLength() {
        String pattern = "a?";
        assertThat(StringPattern.match("aaaa", pattern), is(equalTo(Arrays.asList("a","a","a","a", ""))));
        assertThat(StringPattern.match("ababaaaab", pattern), is(equalTo(Arrays.asList("a","","a","", "a", "a", "a", "a", "", ""))));
        pattern = "a*";
        assertThat(StringPattern.match("aaaa", pattern), is(equalTo(Arrays.asList("aaaa", ""))));
        assertThat(StringPattern.match("ababaaaab", pattern), is(equalTo(Arrays.asList("a","","a","", "aaaa", "", ""))));
        pattern = "a+";
        assertThat(StringPattern.match("aaaa", pattern), is(equalTo(Arrays.asList("aaaa"))));
        assertThat(StringPattern.match("ababaaaab", pattern), is(equalTo(Arrays.asList("a","a","aaaa"))));
        pattern = "a{3}";
        assertTrue(StringPattern.match("aa", pattern).isEmpty());
        assertThat(StringPattern.match("aaa", pattern), is(equalTo(Arrays.asList("aaa"))));
        assertThat(StringPattern.match("aaaa", pattern), is(equalTo(Arrays.asList("aaa"))));
        assertThat(StringPattern.match("aaaaaaaaa", pattern), is(equalTo(Arrays.asList("aaa", "aaa", "aaa"))));
        pattern = "a{3,}";
        assertThat(StringPattern.match("aaaaaaaaa", pattern), is(equalTo(Arrays.asList("aaaaaaaaa"))));
        pattern = "a{3,6}";
        assertThat(StringPattern.match("aaaaaaaaa", pattern), is(equalTo(Arrays.asList("aaaaaa", "aaa"))));
    }

    @Test
    public void testCapturingGroupsAndCharacterClassesWithQuantifiers() {
        String pattern = "(dog){3}";
        assertThat(StringPattern.match("dogdogdogdogdogdog", pattern), is(equalTo(Arrays.asList("dogdogdog", "dogdogdog"))));
        pattern = "dog{3}";
        assertTrue(StringPattern.match("dogdogdogdogdogdog", pattern).isEmpty());
        pattern = "[abc]{3}";
        assertThat(StringPattern.match("abccabaaaccbbbc", pattern), is(equalTo(Arrays.asList("abc", "cab", "aaa", "ccb", "bbc"))));
        pattern = "abc{3}";
        assertTrue(StringPattern.match("abccabaaaccbbbc", pattern).isEmpty());
    }

    @Test
    public void testGreedyReluctantPossessiveQuantifiers() {
        String pattern = ".*foo";
        assertThat(StringPattern.match("xfooxxxxxxfoo", pattern), is(equalTo(Arrays.asList("xfooxxxxxxfoo"))));
        pattern = ".*?foo";
        assertThat(StringPattern.match("xfooxxxxxxfoo", pattern), is(equalTo(Arrays.asList("xfoo", "xxxxxxfoo"))));
        pattern = ".*+foo";
        assertTrue(StringPattern.match("xfooxxxxxxfoo", pattern).isEmpty());
    }

    @Test
    public void testCapturingGroups() {
        String pattern = "(\\d\\d)\\1";
        assertThat(StringPattern.match("1212", pattern), is(equalTo(Arrays.asList("1212"))));
        assertTrue(StringPattern.match("1234", pattern).isEmpty());
    }

    @Test
    public void testBoundary() {
        String pattern = "^dog$";
        assertThat(StringPattern.match("dog", pattern), is(equalTo(Arrays.asList("dog"))));
        pattern = "^dog$";
        assertTrue(StringPattern.match("   dog", pattern).isEmpty());
        pattern = "\\s*dog$";
        assertThat(StringPattern.match("   dog", pattern), is(equalTo(Arrays.asList("   dog"))));
        pattern = "^dog\\w*";
        assertThat(StringPattern.match("dogblahblah", pattern), is(equalTo(Arrays.asList("dogblahblah"))));
        pattern = "\\bdog\\b";
        assertThat(StringPattern.match("The dog plays in the yard", pattern), is(equalTo(Arrays.asList("dog"))));
        assertTrue(StringPattern.match("The doggie plays in the yard", pattern).isEmpty());
        pattern = "\\bdog\\B";
        assertThat(StringPattern.match("The doggie plays in the yard", pattern), is(equalTo(Arrays.asList("dog"))));
        assertTrue(StringPattern.match("The dog plays in the yard", pattern).isEmpty());
        pattern = "\\Gdog";
        assertThat(StringPattern.match("dog dog", pattern), is(equalTo(Arrays.asList("dog"))));
    }

    @Test
    public void testPatternWithFlags() {
        String pattern = "dog";
        assertTrue(StringPattern.match("DoGDOg", pattern).isEmpty());
        assertThat(StringPattern.match("DoGDOg", pattern, Pattern.CASE_INSENSITIVE), is(equalTo(Arrays.asList("DoG", "DOg"))));
        pattern = "(?i)dog";
        assertThat(StringPattern.match("DoGDOg", pattern, Pattern.CASE_INSENSITIVE), is(equalTo(Arrays.asList("DoG", "DOg"))));
    }

    @Test
    public void testSplit() {
        String pattern = ":";
        assertThat(StringPattern.split("one:two:three:four:five", pattern), is(equalTo(Arrays.asList("one", "two", "three", "four", "five"))));
    }

    @Test
    public void testReplace() {
        String pattern = "(?i)dog";
        assertThat(StringPattern.replace("DoGDOg", pattern, "cat"), is(equalTo("catcat")));
    }
}
