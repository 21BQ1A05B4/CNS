import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumOfSubsets {
    
    // Function to find all subsets with given sum
    public static List<List<Integer>> findSubsets(int[] nums, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, targetSum, 0, new ArrayList<>(), result);
        return result;
    }
    
    // Backtracking function
    private static void backtrack(int[] nums, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0 || index >= nums.length)
            return;
        
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, target - nums[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //   Enter the number of elements to be in the list 
        int noOfObjects = input.nextInt();              // no of elements in the array (n = 6) let us suppose

        //  Array declaration 

        int[] nums = new int[noOfObjects];

        //  Enter the Array elements 
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }

        //  Enter the capacity to get the SubSets
        int targetSum = input.nextInt();        // like the mass value  (m = 30) let us suppose
        List<List<Integer>> subsets = findSubsets(nums, targetSum);
        
        if (subsets.isEmpty())
            System.out.println("No solution exists.");
        else {
            System.out.println("Solution(s):");
            for (List<Integer> subset : subsets) {
                System.out.println(subset);
            }
        }
    }
}
