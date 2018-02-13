import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kruskal {


    public List<Edge> kruskalAlgorithm(Graph graph) {

        Edge[] edgeArray = graph.getEdgeArray();
        List<Edge> edgeList = Arrays.asList(edgeArray);
        Collections.sort(edgeList);
        edgeArray = (Edge[]) edgeList.toArray();

        int index = 0;
        int size = graph.vertexAmount();
        int SPANNING_TREE_SIZE = size - 1;

        List<Edge> minimalSpanningTree = new ArrayList<>();

        if (isEmpty(size)) return minimalSpanningTree;

        int[] disjointSet = new int[size];
        initialize(disjointSet);

        do {
            Edge edge = edgeArray[index++];
            int firstVertexSet = find(edge.getInitialVertex(), disjointSet);
            int secondVertexSet = find(edge.getFinalVertex(), disjointSet);
            if (vertexSetsAreDifferent(firstVertexSet, secondVertexSet)) {
                union(firstVertexSet, secondVertexSet, disjointSet);
                minimalSpanningTree.add(edge);
            }
        } while (minimalSpanningTree.size() != SPANNING_TREE_SIZE);

        return minimalSpanningTree;
    }

    private boolean isEmpty(int size) {
        return size == 0;
    }

    private void initialize(int[] disjointSet){
        for (int i = 0; i < disjointSet.length; i++)
            disjointSet[i]  = -1;
    }

    private int find(int vertex, int[] disjointSet){
        int aux = vertex;
        while(disjointSet[aux] > -1)
            aux = disjointSet[aux];

        return aux;
    }

    private boolean vertexSetsAreDifferent(int firstVertexSet, int secondVertexSet) {
        return firstVertexSet != secondVertexSet;
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
