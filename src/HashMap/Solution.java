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
        for(int i=0;i<9;i++){
            HashMap map=new HashMap();
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    int x=27*(i/3)+3*(i%3)+j+9*k;
                    if (board[x/cols][x%cols] != '.') {
                        if (map.get(board[x/cols][x%cols]) != null) {
                            return false;
                        } else {
                            map.put(board[x/cols][x%cols], 1);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static int singleNumber(int[] A) {
        if(A.length==0){
            return -1;
        }
        if(A.length==1){
            return A[0];
        }
        Arrays.sort(A);
        if(A[0]!=A[1]){
            return A[0];
        }
        for(int i=1;i<A.length-1;i++){
            if(A[i]==A[i-1]||A[i]==A[i+1]){
                continue;
            }else {
                return A[i];
            }
        }
        return A[A.length-1];
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap map=new HashMap();
        int len=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            char t=s.charAt(i);
            if(map.get(t)==null){
                len++;
                map.put(t,1);
            }else {
                if(len>max){
                    max=len;
                }
                len=1;
                map.clear();
                map.put(t,1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] input = {};
        int[] in={2,2,1};
        String s="wqeersddfewsdfesfes";
        int iResult=singleNumber(in);
        System.out.println(lengthOfLongestSubstring(s));
    }
}
