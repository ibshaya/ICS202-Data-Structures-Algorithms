public class GraphLAB {
      private boolean adjacencyMatrix[][];
      private int numberOfVertices;

      public GraphLAB(int numberOfVertices) {
            this.numberOfVertices = numberOfVertices;
            adjacencyMatrix = new boolean[numberOfVertices][numberOfVertices];
      }

      public void addEdge(int i, int j) {
            // Add edge from i to j
            adjacencyMatrix[i][j] = true;
            // Since it's an undirected graph, also add edge from j to i
            adjacencyMatrix[j][i] = true;
        }
        

      public void removeEdge(int i, int j) {
            // Remove edge from i to j
            adjacencyMatrix[i][j] = false;
            // Also remove edge from j to i
            adjacencyMatrix[j][i] = false;
      }
        
      public boolean isEdge(int i, int j) {
            // Check if there is an edge from i to j and from j to i
            return adjacencyMatrix[i][j] && adjacencyMatrix[j][i];
      }
        
      
      public void displayGraph(){
        System.out.printf("%10s", " ");
        for(int i = 0; i < numberOfVertices; i++)
          System.out.printf("%10s", i);
          System.out.println();
        for(int i = 0; i < numberOfVertices; i++){
          System.out.printf("%10s", i);
          for(int j = 0; j < numberOfVertices; j++){
            System.out.printf("%10s", adjacencyMatrix[i][j]);
           }
           System.out.println();
       }
       
   }
 }
