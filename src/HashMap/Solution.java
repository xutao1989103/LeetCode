package HashMap;

import java.util.*;

/**
 * Created by 431 on 2014/12/7.
 */
public class Solution {
    public static boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        //row
        for (int i = 0; i < rows; i++) {
            HashMap map = new HashMap();
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != '.') {
                    if (map.get(board[i][j]) != null) {
                        return false;
                    } else {
                        map.put(board[i][j], 1);
                    }
                }
            }
        }
        //col
        for (int i = 0; i < cols; i++) {
            HashMap map = new HashMap();
            for (int j = 0; j < rows; j++) {
                if (board[i][j] != '.') {
                    if (map.get(board[j][i]) != null) {
                        return false;
                    } else {
                        map.put(board[j][i], 1);
                    }
                }
            }
        }
        //small
        for (int i = 0; i < 9; i++) {
            HashMap map = new HashMap();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int x = 27 * (i / 3) + 3 * (i % 3) + j + 9 * k;
                    if (board[x / cols][x % cols] != '.') {
                        if (map.get(board[x / cols][x % cols]) != null) {
                            return false;
                        } else {
                            map.put(board[x / cols][x % cols], 1);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static int singleNumber(int[] A) {
        if (A.length == 0) {
            return -1;
        }
        if (A.length == 1) {
            return A[0];
        }
        Arrays.sort(A);
        if (A[0] != A[1]) {
            return A[0];
        }
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] == A[i - 1] || A[i] == A[i + 1]) {
                continue;
            } else {
                return A[i];
            }
        }
        return A[A.length - 1];
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int curLen = 0;
        int maxLen = 0;
        int curStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            Integer offset = map.get(t);
            if (offset == null) {
                curLen++;
            } else if (offset >= curStart) {
                curStart = offset + 1;
                curLen = i - offset;
            } else {
                curLen++;
            }
            map.put(t, i);
            maxLen = curLen > maxLen ? curLen : maxLen;
        }
        return maxLen;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorderAdd(root, result);
        return result;
    }

    public static void inorderAdd(TreeNode root, List result) {
        if (root != null) {
            inorderAdd(root.left, result);
            result.add(root.val);
            inorderAdd(root.right, result);
        }
    }

    public static void inorderSearch(TreeNode root) {
        if (root != null) {
            inorderSearch(root.left);
            System.out.println(root.val);
            inorderSearch(root.right);
        }
    }

    public static List<String> anagrams(String[] strs) {
        List<String> result=new ArrayList<String>();
        if(strs.length==0){
            return result;
        }
        HashMap<Character,Integer> map=new HashMap();
        for(String s:strs){
           if(isAllEqual(s,map)){
               for(int i=1;i<s.length();i++){
                   map.put(s.charAt(i),map.get(s.charAt(i))==null?1:map.get(s.charAt(i))+1);
               }
               result.add(s);

           }
        }
        return result;
    }

    public static boolean isAllEqual(String string,HashMap map){
        int len=string.length();
        if(len==1){
            return true;
        }
        for(int i=1;i<len;i++){
            if(map.get(string.charAt(i-1))!=map.get(string.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] input = {};
        int[] in = {2, 2, 1};
        String s = "ss";
        int iResult = singleNumber(in);
        String[] strings={"eat","tea","aet","aes","sss"};
        System.out.println( anagrams(strings));
    }
}
