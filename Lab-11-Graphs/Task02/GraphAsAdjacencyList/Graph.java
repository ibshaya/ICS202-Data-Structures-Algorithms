import java.util.LinkedList;

class Graph {
    int numVertices;
    LinkedList<String>[] adjacencyList;
    String[] labels;

    Graph(int numVertices, String[] labels) {
        this.labels = labels;
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];

        for (int i = 0; i < adjacencyList.length; i++)
            adjacencyList[i] = new LinkedList<String>();
    }

    // To add a directed edge to graph
    void addDirectedEdge(int v, int w) {
        adjacencyList[v].add(labels[w]); // Add label of w to v's list.
    }

    // To add undirected edge to graph
    void addUndirectedEdge(int v, int w) {
        adjacencyList[v].add(labels[w]);
        adjacencyList[w].add(labels[v]);
    }

    void displayGraph() {
        for (int i = 0; i < adjacencyList.length; i++) {
            System.out.print(labels[i] + " ----> ");
            for (String vertex : adjacencyList[i]) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

