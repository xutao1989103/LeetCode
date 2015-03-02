package solutions;

import java.util.*;

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
            if (start >= end) return true;
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

    public static int atoi(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] content = str.toCharArray();
        int length = str.length();
        int start = 0;
        int flag = 1;
        int value = 0;
        int max = Integer.MAX_VALUE / 10;
        while (start < length) {
            if (content[start] == ' ') {
                start++;
            } else {
                break;
            }
        }

        if (content[start] == '-') {
            flag = -1;
            start++;
        } else if (content[start] == '+') {
            start++;
        }
        while (start < length) {
            if (content[start] >= '0' && content[start] <= '9') {
                value = value * 10 + content[start] - 48;
            } else {
                break;
            }
            start++;
        }
        return flag * value;
    }

    public static String simplifyPath(String path) {
        String[] paths = path.split("/+");
        Stack<String> stack = new Stack<String>();
        for (String s : paths) {

            if (s.length() > 0) {
                if (s.equals("..")) {
                    if (stack.empty()) {
                        continue;
                    }
                    stack.pop();
                } else if (s.equals(".")) {
                    continue;
                } else {
                    stack.push(s);
                }
            }

        }
        String result = "";
        while (!stack.empty()) {
            result = "/" + stack.pop() + result;
        }
        if (result.length() == 0) {
            result += "/";
        }
        return result;
    }


    public static int romanToInt(String s) {
        HashMap<Character, Integer> value;
        value = new HashMap<Character, Integer>();
        value.put('M', 1000);
        value.put('D', 500);
        value.put('C', 100);
        value.put('L', 50);
        value.put('X', 10);
        value.put('V', 5);
        value.put('I', 1);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && value.get(s.charAt(i)) < value.get(s.charAt(i + 1)))
                sum -= value.get(s.charAt(i));
            else
                sum += value.get(s.charAt(i));
        }
        return sum;
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String[] strings = s.split(" +");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].equals("")) {
                stringBuilder.append(strings[i] + " ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        return result;
    }

    public static void main(String[] args) {

        boolean bResult = isPalindrome(".,");
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
