import java.util.*;

public class OptimalMergePattern {

    public static int optimalMerge(int[] files, int n) {
        //  priority queue initalization

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all file sizes to the priority queue
        for (int file : files) {
            pq.add(file);
        }

        int cost = 0;

        while (pq.size() > 1) {
            // Extract the two smallest files
            int file1 = pq.poll();   // here poll method used to retrieve and remove the head element in the deque interface
            int file2 = pq.poll();

            //  summation of two minimum cost values

            int mergedFileSize = file1 + file2;
            cost += mergedFileSize;

            //  pushing the summation value to the priority for further comparisions
            pq.add(mergedFileSize);
        }

        return cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //  enter the no of the files to be compared to get the min cost 
        int n = sc.nextInt();
        //  array declaration to store file sizes 
        int [] files = new int[n];

        for (int file = 0; file < files.length; file++) {
            files[file] = sc.nextInt();
        }
        int minCost = optimalMerge(files, n);
        System.out.println("Minimum cost of merging is: " + minCost + " Comparisons");
    }
}
