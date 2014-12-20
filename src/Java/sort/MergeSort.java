package Java.sort;

import java.util.Arrays;

/**
 * Created by 431 on 2014/12/14.
 */
public class MergeSort {
    public static void mergeSort(int[] in) {
        sort(in, 0, in.length - 1);
    }

    public static void sort(int[] in, int left, int right) {
        if (left >= right) return;
        int center = (left + right) / 2;
        sort(in, left, center);
        sort(in, center + 1, right);
        merge(in, left, center, right);
    }

    public static void merge(int[] data, int left, int center, int right) {
        int[] tmpArr = new int[data.length];
        int mid = center + 1;
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }


    public static void sort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    private static void quickSort(int[] input, int begin, int end) {
        if (begin >= end) return;
        int mid = partition(input, begin, end);
        quickSort(input, begin, mid-1);
        quickSort(input, mid+1, end);
    }

    private static int partition(int[] input, int begin, int end) {
        int x = input[begin];
        int smallIndex = begin, bigIndex = begin;
        while(++bigIndex <= end) {
            if (input[bigIndex] >= x) continue;
            else {
                smallIndex++;
                swap(input, smallIndex, bigIndex);
            }
        }
        swap(input, begin, smallIndex);
        return smallIndex;
    }

    private static void swap(int[] input, int lhs, int rhs) {
        int temp = input[lhs];
        input[lhs] = input[rhs];
        input[rhs] = temp;
    }

    public static void main(String[] args) {
        int[] input = {3, 4, 7, 2, 5, 1, 9, 8, 6};
        sort(input);
        System.out.println(Arrays.toString(input));

    }
}
