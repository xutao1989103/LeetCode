package leetcode.array;

import java.util.Stack;

/**
 * Created by Administrator on 2014/10/21.
 */
public class WordSerch {
    public static boolean exist(char[][] board,String word){
        boolean result=false;
        char[] words=word.toCharArray();
        int[][] count=new int[board.length][board[0].length];
        if(board.length==1){
            if(new String(board[0]).indexOf(words[0])>-1){
               for (int i=0;i<board[0].length;i++){
                   if(board[0][i]==words[0]){
                       count[0][i]++;
                       if(find(board[0],i,words,1,count)){
                           return true;
                       }
                   }
               }
            }
        }else {
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==words[0]){
                        if(find(board,i,j,words,1)){
                            return true;
                        }
                    }
                }
            }
        }
        return  result;
    }

    public static  boolean find(char[] board,int i,char[] target,int k,int[][] count){
        if(k==target.length){
            return true;
        }else{
            if(i-1>=0&&board[i-1]==target[k]){
                k++;
                count[0][i-1]++;
                if( count[0][i-1]==2){
                    return false;
                }
                return find(board,i-1,target,k,count);
            }
            if(i+1<board.length&&board[i+1]==target[k]){
                k++;
                count[0][i+1]++;
                if( count[0][i+1]==2){
                    return false;
                }
                return find(board,i,target,k,count);
            }
            return false;
        }
    }

    public static boolean find(char[][] board,int i,int j,char[] target,int k){
        boolean result=false;
        if(k==target.length){
            return true;
        }else {
            if(j-1>=0&&board[i][j-1]==target[k]){
                k=k+1;
                return find(board,i,j-1,target,k);
            }
            if(j+1<board[0].length&&board[i][j+1]==target[k]){
                k=k+1;
                return find(board,i,j+1,target,k);
            }
            if(i-1>=0&&board[i-1][j]==target[k]){
                k=k+1;
                return find(board,i-1,j,target,k);
            }
            if(i+1<board.length&&board[i+1][j]==target[k]){
                k=k+1;
                return find(board,i+1,j,target,k);
            }
            return false;
        }
    }

    public static void main(String args[]){
        char[][] c={{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        String word="see";
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                System.out.print(c[i][j]+",");
            }
            System.out.println();
        }
        System.out.println(word);
        if(exist(c,word)){
            System.out.println("exist");
        }else {
            System.out.println("not exist");
        }
    }
}
