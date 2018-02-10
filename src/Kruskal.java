import java.util.ArrayList;
import java.util.List;

public class Kruskal {

    private final Sorter sorter;

    public Kruskal(Sorter sorter) {
        this.sorter = sorter;
    }

    public List<Edge> kruskalAlgorithm(Graph graph) {
        Edge[] edgeArray = graph.getEdgeArray();
        sorter.sort(edgeArray);

        int index = 0;
        int size = graph.vertexAmount();

        List<Edge> minimalExpansionTree = new ArrayList<>();

        if (size == 0) return minimalExpansionTree;

        int[] disjointSet = new int[size];
        initialize(disjointSet);

        do {
            Edge edge = edgeArray[index];
            index++;
            int firstVertexSet = find(edge.getInitialVertex(), disjointSet);
            int secondVertexSet = find(edge.getFinalVertex(), disjointSet);
            if (firstVertexSet != secondVertexSet) {
                union(firstVertexSet, secondVertexSet, disjointSet);
                minimalExpansionTree.add(edge);
            }
        } while (minimalExpansionTree.size() != size-1);

        return minimalExpansionTree;
    }

    private void initialize(int[] disjointSet){
        for (int i = 0; i < disjointSet.length; i++)
            disjointSet[i]  = 0;
    }

    private int find(int vertex, int[] disjointSet){
        int aux = vertex;
        while(disjointSet[aux] > 0)
            aux = disjointSet[aux];

        return aux;
    }

    private void union(int firstVertex, int secondVertex, int[] disjointSet){
        if (disjointSet[firstVertex] == disjointSet[secondVertex]){
            disjointSet[firstVertex] = disjointSet[firstVertex] - 1;
            disjointSet[secondVertex] = firstVertex;
        } else {
            if (disjointSet[firstVertex] < disjointSet[secondVertex])
                disjointSet[secondVertex] = firstVertex;
            else
                disjointSet[firstVertex] = secondVertex;
        }
    }
}
