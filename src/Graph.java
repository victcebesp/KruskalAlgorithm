import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int vertexAmount;
    private List<List<Edge>> representation;
    private Edge[] edgesArray;
    private Edge[] edges;

    public Graph(List<List<Edge>> representation) {
        this.representation = representation;
        this.vertexAmount = representation.size();
        edgesArray = obtainEdges();
    }

    public void addVertex(int origin, int target, int cost){
        representation.get(origin).add(new Edge(cost, target));
    }

    public Edge[] getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertexAmount=" + vertexAmount +
                ", representation=" + representation +
                '}';
    }

    private Edge[] obtainEdges() {
        List<Edge> edgeList = new ArrayList<>();
        for (List<Edge> each : representation) {
            for (Edge edge : each) {
                edgeList.add(edge);
            }
        }
        return (Edge[]) edgeList.toArray();
    }
}
