package gradle.app.algo;

public class Regx {


    public static boolean match(char[] str, char[] pattern) {
        return match(str, 0, pattern, 0);
    }

    public static boolean match(char[] str, int i, char[] pattern, int j) {
        if (str == null || pattern == null) return false;
        if (pattern.length == j) return str.length == i;

        boolean firstMatch = str.length > i && (str[i] == pattern[j] || pattern[j] == '.');

        if (pattern.length - j >= 2 && pattern[j + 1] == '*') {
            return match(str, i, pattern, j + 2) || (firstMatch && match(str, i + 1, pattern, j));
        } else {
            return firstMatch && match(str, i + 1, pattern, j + 1);
        }
    }
}
