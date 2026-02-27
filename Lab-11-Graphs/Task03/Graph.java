import java.util.List;
import java.util.ArrayList;

public class Graph {
    private List<List<Integer>> adjList;
    private int numVertices;

    public Graph(List<Edge> edges, int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.dest;
            adjList.get(src).add(dest);
        }
    }

    public boolean isReachable(int src, int dest) {
        boolean[] visited = new boolean[numVertices];
        return isReachable(src, dest, visited);
    }

    private boolean isReachable(int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;
        for (int neighbor : adjList.get(src)) {
            if (!visited[neighbor]) {
                if (isReachable(neighbor, dest, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}

