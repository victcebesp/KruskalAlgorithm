import java.util.List;

public class Graph {

    private final Edge[] edgeArray;
    private int vertexAmount;
    private List<Edge> representation;

    public Graph(List<Edge> representation, int vertexAmount) {
        this.representation = representation;
        this.vertexAmount = vertexAmount;
        this.edgeArray = representationToArray();
    }

    public int vertexAmount() {
        return vertexAmount;
    }

    public Edge[] getEdgeArray() {
        return edgeArray;
    }

    private Edge[] representationToArray() {

        Edge[] edgeArray = new Edge[representation.size()];
        for (int i = 0; i < representation.size(); i++) edgeArray[i]  = representation.get(i);
        return edgeArray;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertexAmount=" + vertexAmount +
                ", representation=" + representation +
                '}';
    }

}
