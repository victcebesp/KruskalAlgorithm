import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Sorter sorter = new Sorter();
        Kruskal kruskal = new Kruskal(sorter);
        List<Edge> edgeList = Arrays.asList(new Edge(0, 1, 1),
                                            new Edge(0, 3, 4),
                                            new Edge(0, 4, 6),
                                            new Edge(1, 2, 2),
                                            new Edge(1, 4, 4),
                                            new Edge(2, 4, 4),
                                            new Edge(2, 5, 6),
                                            new Edge(2, 6, 4),
                                            new Edge(3, 4, 3),
                                            new Edge(3, 6, 4),
                                            new Edge(4, 5, 8),
                                            new Edge(4, 6, 7),
                                            new Edge(5, 6, 3));
        Graph graph = new Graph(edgeList, 7);

        for (Edge edge : kruskal.kruskalAlgorithm(graph)) {
            System.out.println(edge);
        }
    }

}
