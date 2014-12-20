package solutions;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by 431 on 2014/12/20.
 */
public class Strings {
    public static String convert(String s, int nRows) {
        if (s.length() < 1 || nRows <= 1) return s;
        char[] chars = s.toCharArray();
        StringBuilder[] stringBuilders = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) {
            stringBuilders[i] = new StringBuilder("");
        }
        int len = s.length();
        boolean up = true;
        int step = 0;
        for (int i = 0; i < len; i += (nRows - 1)) {
            if (up) {
                for (int j = 0; j < nRows - 1 && step < len; j++) {
                    stringBuilders[j].append(chars[step]);
                    step++;
                }
                up = false;
            } else {
                for (int j = nRows - 1; j >= 1 && step < len; j--) {
                    stringBuilders[j].append(chars[step]);
                    step++;
                }
                up = true;
            }
        }
        StringBuilder result = new StringBuilder("");
        for (StringBuilder stringBuilder : stringBuilders) {
            result.append(stringBuilder);
        }
        return result.toString();
    }

    public static boolean isValid(String s) {
        if (s == null || s.equals("")) return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '{' || temp == '[' || temp == '(') {
                stack.push(temp);
            } else if (temp == '}' || temp == ']' || temp == ')') {
                if (stack.size() == 0) {
                    return false;
                }
                if (temp == '}') {
                    if (stack.pop() != '{') return false;
                }
                if (temp == ')') {
                    if (stack.pop() != '(') return false;
                }
                if (temp == ']') {
                    if (stack.pop() != '[') return false;
                }
            } else {
                return false;
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome(String s) {
        if (s.equals("") || s.length() == 1) return true;
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            while (!isalpha(s.charAt(start)) && start < len - 1) start++;
            while (!isalpha(s.charAt(end)) && end > 0) end--;
            if(start>=end) return true;
            if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isalpha(char c) {
        if (Character.isDigit(c) || Character.isLetter(c)) return true;
        return false;
    }

    public static void main(String[] args) {

        boolean bResult = isPalindrome(".,");

        System.out.println(bResult);
    }
}
