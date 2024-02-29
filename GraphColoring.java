import java.util.Scanner;

public class GraphColoring {
    
    // Function to color the nodes of the graph
    public static int[] colorGraph(int[][] graph, int numColors) {
        int numNodes = graph.length;
        int[] colors = new int[numNodes];
        if (colorUtil(graph, numColors, colors, 0)) {
            return colors;
        }
        return null; // No valid coloring exists
    }
    
    // Backtracking function to color the nodes
    private static boolean colorUtil(int[][] graph, int numColors, int[] colors, int node) {
        if (node == graph.length)
            return true;
        
        for (int color = 1; color <= numColors; color++) {
            if (isSafe(graph, colors, node, color)) {
                colors[node] = color;
                if (colorUtil(graph, numColors, colors, node + 1))
                    return true;
                colors[node] = 0; // Backtrack
            }
        }
        
        return false;
    }
    
    // Helper function to check if it's safe to color a node with a given color
    private static boolean isSafe(int[][] graph, int[] colors, int node, int color) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1 && colors[i] == color)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Input number of nodes
        System.out.print("Enter the number of nodes in the graph: ");
        int numNodes = input.nextInt();
        
        // Input adjacency matrix of the graph
        int[][] graph = new int[numNodes][numNodes];
        System.out.println("Enter the adjacency matrix of the graph:");
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                graph[i][j] = input.nextInt();
            }
        }
        
        // Input number of colors
        System.out.print("Enter the number of colors available: ");
        int numColors = input.nextInt();
        
        int[] colors = colorGraph(graph, numColors);
        
        if (colors == null)
            System.out.println("No valid coloring exists.");
        else {
            System.out.println("Node Colors:");
            for (int i = 0; i < colors.length; i++) {
                System.out.println("Node " + i + ": Color " + colors[i]);
            }
        }
    }
}
