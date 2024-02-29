// 5. write a program to find all pair shortest path from any node to any other node with in a graph.

import java.util.Scanner;

public class AllPairShortestPath {

    static final int INF = 99999;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int n = scanner.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter the adjacency matrix representing the graph (Enter " + INF + " for infinity):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int[][] shortestDistances = findAllPairShortestPaths(graph);

        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < shortestDistances.length; i++) {
            for (int j = 0; j < shortestDistances[i].length; j++) {
                if (shortestDistances[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(shortestDistances[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    static int[][] findAllPairShortestPaths(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        // Initialize distances to INF and the diagonal to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }
}
