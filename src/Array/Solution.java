package Array;

import java.util.*;

/**
 * Created by 431 on 2014/11/27.
 */
public class Solution {
    public static int removeElement(int A[],int elem){
        int result=0;
        if(A.length==0){
            return 0;
        }
        for(int i=0;i<A.length;i++){
            if(A[i]!=elem){
                A[result++]=A[i];
            }
        }
        return result;
    }

    public static int removeDuplicates(int[] A) {
        int result=0;
        int i;
        if(A.length==0){
            return 0;
        }
        if(A.length==1){
            return 1;
        }
        for(i=1;i<A.length;i++){
            if(A[result]!=A[i]){
                A[++result]=A[i];
            }
        }
        if(i>1&&result==0){
            return 1;
        }
        return result+1;
    }
    public static int[] plusOne(int[] digits) {
        int[] result=new int[digits.length+1];
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                result=digits;
                result[i]++;
                return result;
            }else {
                digits[i]=0;
                if(i==0){
                    result[0]=1;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList();
        List<List<Integer>> resultOne=new ArrayList<List<Integer>>();
        List<Integer> one=new ArrayList<Integer>();
        one.add(1);
        result.add(one);
        resultOne.add(one);
        if(numRows<0){
            return null;
        }
        if(numRows==0){
            return new ArrayList();
        }
        if(numRows==1){

            return resultOne;
        }
        for(int i=1;i<numRows;i++){
            List<Integer> list=new ArrayList<Integer>();
            list.add(0,1);
            list.add(list.size()-1,1);
            for(int j=1;j<i;j++){
                List<Integer> temp=result.get(i-1);
                list.add(j,temp.get(j-1)+temp.get(j));
            }
            result.add(list);

        }
        return result;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<Integer>();
        if(rowIndex==0){
            result.add(1);
            return result;
        }
        if(rowIndex==1){
            result.add(1);
            result.add(1);
            return result;
        }
        result.add(1);
        result.add(1);
        if(rowIndex>1){
            for (int i=1;i<rowIndex;i++){
                result=addOne(result);
            }
        }
        return result;
    }
    public static List<Integer> addOne(List<Integer> result){
        result.add(1);
        for(int i=result.size()-2;i>0;i--){
            result.set(i,result.get(i)+result.get(i-1));
        }
        return  result;
    }

    public static void merge(int A[], int m, int B[], int n) {
        int i=0;
        int j=0;
        if(n==0){
            return;
        }
        if(m==0){
            for(int s=0;s<n;s++){
                A[s]=B[s];
            }
            return;
        }
        while (i<A.length){
            if(A[i]<B[j]){
                i++;
            }else {
                for(int k=A.length-1;k>i;k--){
                    A[k]=A[k-1];
                }
                A[i]=B[j];
                if(j>=n-1){
                    return;
                }
                j++;
            }
        }
        if(j<n){
            for(j=j;j<n;j++){
                A[m+j]=B[j];
            }
        }
    }

    public static boolean exist(char[][] board, String word) {
        boolean result=false;
        if(word.length()<1){
            return false;
        }
        char start=word.charAt(0);
        if(board.length==0){
            return false;
        }
        if(board.length==1){
            String boards=new String(board[0]);
            StringBuilder stringBuilder=new StringBuilder();
            for(int l=board[0].length-1;l>=0;l--){
                stringBuilder.append(board[0][l]);
            }
            String boardsRevese=stringBuilder.toString();
            if(boards.equals(word)||boards.indexOf(word)>=0){
                return true;
            }
            if(boardsRevese.equals(word)||boardsRevese.indexOf(word)>=0){
                return true;
            }
            return false;

        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               if(board[i][j]==start){
                   int[][] used=new int[board.length][board[0].length];
                   if(deepSearch(board,i,j,used,word)){
                       return true;
                   }
               }
            }
        }
        return result;
    }

    public static boolean deepSearch(char[][] board,int x,int y,int[][] used,String word){
        used[x][y]=1;
        word=word.substring(1,word.length());
        if(word.equals("")){
            return true;
        }
        if(x-1>=0&&used[x-1][y]==0&&board[x-1][y]==word.charAt(0)){
            if(!deepSearch(board,x-1,y,used,word)){
                used[x-1][y]=0;
            }else {
                return true;
            }
        }
        if(y+1<board[0].length&&used[x][y+1]==0&&board[x][y+1]==word.charAt(0)){
            if(!deepSearch(board, x, y+1, used, word)){
                used[x][y+1]=0;
            }else {
                return true;
            }
        }
        if(x+1<board.length&&used[x+1][y]==0&&board[x+1][y]==word.charAt(0)){
            if(!deepSearch(board,x+1,y,used,word)){
                used[x+1][y]=0;
            }else {
                return true;
            }
        }
        if(y-1>=0&&used[x][y-1]==0&&board[x][y-1]==word.charAt(0)){
            if(!deepSearch(board, x, y-1, used, word)){
                used[x][y-1]=0;
            }else {
                return true;
            }
        }

        return false;
    }

    public static int uniquePaths(int m, int n) {
//        if(m<=0||n<=0){
//            return 0;
//        }
//        if(m==1||n==1){
//            return 1;
//        }
//        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = Combination(N, N - k)
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int)res;

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int N=n+m-2;
        int K=m-1;
        if(m<=0||n<=0){
            return 0;
        }
        if(m==1&&n==1){
            if(obstacleGrid[0][0]==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(m==1){
            for(int i=0;i<obstacleGrid[0].length;i++){
                if(obstacleGrid[0][i]==1){
                    return 0;
                }
            }
            return 1;
        }
        if(n==1){
            for(int j=0;j<obstacleGrid.length;j++){
                if(obstacleGrid[j][0]==1){
                    return 0;
                }
            }
            return 1;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    if(i==0){
                        N--;
                    }
                    if(j==0){
                        N--;
                        K--;
                    }
                    if(i!=0&&j!=0){
                        N-=2;
                        K--;
                    }

                }
            }
        }
        double res=1;
        for (int i = 1; i <= K; i++)
            res = res * (N - K + i) / i;
        return (int)res;
    }

    public static int[] twoSumTimeout(int[] numbers, int target) {
        int[] result=new int[2];
        int counts=numbers.length;
        if(counts<2){
            return null;
        }
        for(int i=0;i<counts;i++){
            for(int j=0;j<counts;j++){
                if(numbers[j]+numbers[i]==target){
                    result[0]=i+1;
                    result[1]=j+1;
                    return result;
                }
            }
        }
        return result;
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        int counts=numbers.length;
        if(counts<2){
            return null;
        }
        HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
        for(int i=0;i<counts;i++){
            hashMap.put(numbers[i],i);
        }
        for(int i=0;i<counts;i++){
            int rest=target-numbers[i];
           if(hashMap.get(rest)!=null&&hashMap.get(rest)>i){
               result[0]=i+1;
               result[1]=hashMap.get(rest)+1;
           }
        }

        return result;
    }

    private static int binarySerch(int[] numbers, int target){
        int result=-1;
        int left=0;
        int right=numbers.length-1;
        int mid=(left+right)/2;
        while(left<=right){
            if(numbers[mid]==target){
                return mid;
            }else if(numbers[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return result;
    }

    public static int minimumTotalDp(List<List<Integer>> triangle){
        if(triangle.size()==0){
            return 0;
        }
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        for(int i=triangle.size()-2;i>=0;i--){
            List<Integer> nextRow=triangle.get(i+1);
            for(int j=0;j<i+1;j++){
                int sum=Math.min(nextRow.get(j),nextRow.get(j+1))+triangle.get(i).get(j);
                triangle.get(i).set(j,sum);
            }
        }
        return triangle.get(0).get(0);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0){
            return 0;
        }
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int left=minimumTotal(subLists(triangle,true));
        int right=minimumTotal(subLists(triangle,false));
        return triangle.get(0).get(0)+left<right?left:right;
    }
    public static List<List<Integer>> subLists(List<List<Integer>> lists,boolean left){
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for(int i=1;i<lists.size();i++){
            List list=lists.get(i);
            if(left){
                list.remove(list.size()-1);
            }else {
                list.remove(0);
            }
            result.add(list);
        }
        return result;
    }

    public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> empty=new ArrayList<Integer>();
        result.add(empty);
        int length=S.length;
        if(length==0){
            return result;
        }
        for(int i=0;i<length;i++){
            insertOneNotDuplicate(result, S[i]);
        }
        return result;
    }
    public static void insertOne(List<List<Integer>> lists,int value){
        List<List<Integer>> temp=new ArrayList<List<Integer>>();
        for(int i=0;i<lists.size();i++){
            List<Integer> tempList=new ArrayList<Integer>();
            for(int j=0;j<lists.get(i).size();j++){
               tempList.add(lists.get(i).get(j));
            }
            temp.add(tempList);
        }
        for(List<Integer> intList:temp){

            intList.add(value);
            Collections.sort(intList);
        }
        lists.addAll(temp);
    }

    public static void insertOneNotDuplicate(List<List<Integer>> lists,int value){
        List<List<Integer>> temp=new ArrayList<List<Integer>>();
        for(int i=0;i<lists.size();i++){
            List<Integer> tempList=new ArrayList<Integer>();
            for(int j=0;j<lists.get(i).size();j++){
                tempList.add(lists.get(i).get(j));
            }
            temp.add(tempList);
        }
        for(List<Integer> intList:temp){
            intList.add(value);
            Collections.sort(intList);
        }
        for(List<Integer> list:temp){
            if(!lists.contains(list)){
                lists.add(list);
            }
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();
        if(matrix.length==0){
            return result;
        }
        if(matrix.length==1){
            for(int j=0;j<matrix[0].length;j++){
                result.add(matrix[0][j]);
            }
            return result;
        }
        if(matrix[0].length==1){
            for(int j=0;j<matrix.length;j++){
                result.add(matrix[j][0]);
            }
            return result;
        }
        for(int i=0;i<(Math.min(matrix.length,matrix[0].length)+1)/2;i++){
            result.addAll(oneRound(i,i,matrix));
        }
        return result;
    }
    public static List<Integer> oneRound(int x,int y,int[][] matrix){
        int gap=x;
        List<Integer> result= new ArrayList<Integer>();
        int length=matrix.length;
        int height=matrix[0].length;
        if((matrix.length-1)/2==x){
            result.add(matrix[x][x]);
            return result;
        }
        while (y<height-1-gap){
            result.add(matrix[x][y]);
            y++;
        }
        while (x<length-1-gap){
            result.add(matrix[x][y]);
            x++;
        }
        while (y>gap){
            result.add(matrix[x][y]);
            y--;
        }
        while (x>gap){
            result.add(matrix[x][y]);
            x--;
        }
        return result;
    }

    public static  boolean searchMatrix(int[][] matrix,int target){
        return false;
    }

    public static void rotateNotClockWise(int[][] matrix){
        if(matrix.length==0){
            return;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=i;j<col;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    public static void exchange(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][col-1-j];
                matrix[i][col-1-j]=temp;
            }
        }
    }

    public static void rotate(int[][] matrix){
        if(matrix.length==0){
            return;
        }
        rotateNotClockWise(matrix);
        exchange(matrix);
    }

    public static void main(String[] args){

        int[][] input={{1,2,3},{4,5,6},{7,8,9}};
        boolean rotate=searchMatrix(input,5);
        rotate(input);
        System.out.println(Arrays.toString(input[0]));
        System.out.println(Arrays.toString(input[1]));
        System.out.println(Arrays.toString(input[2]));

    }
}
