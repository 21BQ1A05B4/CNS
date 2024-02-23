import java.util.*;
public class BinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        System.out.println(search(arr, 0, arr.length-1, target));
    }
    static int search(int [] arr, int start, int end, int target) {
        if(start == end) {
            if(arr[start] == target) {
                return start;
            } else {
                return -1;
            }
        } else {
            int mid = start + (end-start)/2;
            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                return search(arr, start, mid-1, target);
            } else {
                return search(arr, mid+1, end, target);
            }
        }
    }
}