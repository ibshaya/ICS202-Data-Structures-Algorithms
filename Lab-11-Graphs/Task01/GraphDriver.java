  public class GraphDriver {
    public static void main(String[] args) {
        // Create an undirected graph with 4 vertices
        GraphLAB graph = new GraphLAB(4);

        // Add the 5 edges of the graph
        // Edges: 0-1, 0-2, 0-3, 1-2, 1-3, 2-3
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        // Display the graph before deleting edge 2---3
        System.out.println("Before deleting edge 2---3 the graph is: \n");
        graph.displayGraph();

        // Remove the edge 2---3
        graph.removeEdge(2, 3);

        // Display the graph after deleting edge 2---3
        System.out.println("\nAfter deleting edge 2---3 the graph is: \n");
        graph.displayGraph();
    }
  }
