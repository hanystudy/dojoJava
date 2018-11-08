package name.hanyi.stringpattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPattern {
    private StringPattern() {}

    public static List<String> match(String text, String patternString) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        return matchAll(list, matcher);
    }

    public static List<String> match(String text, String patternString, int mode) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(patternString, mode);
        Matcher matcher = pattern.matcher(text);
        return matchAll(list, matcher);
    }

    public static List<String> split(String text, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        String[] strings = pattern.split(text);
        return Arrays.asList(strings);
    }

    public static String replace(String text, String patternString, String replaceText) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(replaceText);
    }

    private static List<String> matchAll(List<String> list, Matcher matcher) {
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
