package leetcode.array;

import java.util.*;

/**
 * Created by Administrator on 2014/11/24.
 */
public class Solution {
    public static int removeElement(int[] A, int elem) {
        int begin=0;
        for(int i=0;i<A.length;i++){
            if(A[i]!=elem){
                A[begin++]=A[i];
            }
        }
        return begin;
    }

    public static int removeDuplicates(int[] A) {
        if (A == null) {
            return 0;
        }
        if (A.length <= 1) {
            return A.length;
        }
        int insert = 1, index = 1;
        while (index < A.length) {
            if (A[index] != A[insert - 1]) {
                A[insert] = A[index];
                insert++;
            }
            index++;
        }
        return insert;
    }
    public static void remove(int[] a,int i,int j){

    }
    public static void main(String[] args){
        int[] a={3,3,3,4,4,4,5};
        int result=removeDuplicates(a);
        System.out.println(a.length);
    }

}