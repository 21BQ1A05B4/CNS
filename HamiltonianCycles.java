import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HamiltonianCycles {
    private int[][] graph;
    private boolean[] visited;
    private List<List<Integer>> allCycles;

    public List<List<Integer>> findHamiltonianCycles(int[][] g) {
        graph = g;
        int n = graph.length;
        visited = new boolean[n];
        allCycles = new ArrayList<>();

        // Start the search from each vertex
        for (int i = 0; i < n; i++) {
            List<Integer> cycle = new ArrayList<>();
            cycle.add(i + 1); // Include the starting vertex in the cycle
            visited[i] = true;
            hamiltonianCycleUtil(i, cycle, 1);
            visited[i] = false; // Reset visited flag
        }

        return allCycles;
    }

    private void hamiltonianCycleUtil(int current, List<Integer> cycle, int count) {
        // If all vertices are visited and the current vertex has an edge to the starting vertex,
        // then it forms a Hamiltonian cycle
        if (count == graph.length && graph[current][cycle.get(0) - 1] == 1) {
            allCycles.add(new ArrayList<>(cycle));
            return;
        }

        for (int i = 0; i < graph.length; i++) {
            if (graph[current][i] == 1 && !visited[i]) {
                cycle.add(i + 1);
                visited[i] = true;
                hamiltonianCycleUtil(i, cycle, count + 1);
                visited[i] = false; // Backtrack
                cycle.remove(cycle.size() - 1); // Remove the current vertex from the cycle
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter the number of vertices in the graph: ");
        int numVertices = in.nextInt();

        // Input adjacency matrix of the graph
        int[][] graph = new int[numVertices][numVertices];
        System.out.println("Enter the adjacency matrix of the graph:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graph[i][j] = in.nextInt();
            }
        }

        HamiltonianCycles hc = new HamiltonianCycles();
        List<List<Integer>> allCycles = hc.findHamiltonianCycles(graph);

        if (allCycles.isEmpty()) {
            System.out.println("No Hamiltonian cycles found.");
        } else {
            System.out.println("Hamiltonian Cycles:");
            for (List<Integer> cycle : allCycles) {
                System.out.println(cycle);
            }
        }
    }
}
