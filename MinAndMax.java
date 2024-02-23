import java.util.*;

public class MinAndMax {
    public static void main(String[] args) {
        int[] arr = {100, -100, 99, 50, 100};
        int[] res = findMinAndMax(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(res));
    }

    static int[] findMinAndMax(int[] arr, int start, int end) {
        int[] result = new int[2];

        // Base Case
        if (start == end) {
            result[0] = result[1] = arr[start];
        }
        // Second Base Case
        else if (start == end - 1) {
            if (arr[start] < arr[end]) {
                result[0] = arr[end];
                result[1] = arr[start];
            } else {
                result[0] = arr[start];
                result[1] = arr[end];
            }
        }
        // Divide and Conquer here ..
        else {
            int mid = start + (end - start) / 2;

            int[] leftResult = findMinAndMax(arr, start, mid);
            int[] rightResult = findMinAndMax(arr, mid + 1, end);

            int max1 = leftResult[0];
            int min1 = leftResult[1];
            int max2 = rightResult[0];
            int min2 = rightResult[1];

            result[0] = Math.max(max1, max2);
            result[1] = Math.min(min1, min2);
        }

        return result;
    }
}
