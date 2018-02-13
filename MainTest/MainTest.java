import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void return_right_toString_empty_graph(){

        Graph graph = new Graph(new ArrayList<>(), 0);

        String grapString = "Graph{" +
                "vertexAmount=0, representation=[]}";

        assertEquals(grapString, graph.toString());
    }

    @Test
    public void return_right_toString_one_edge_graph(){

        List<Edge> edgeList = Arrays.asList(new Edge(0, 0, 1));

        Graph graph = new Graph(edgeList, 1);
        String grapString = "Graph{vertexAmount=1, representation=[Edge{cost=1, initialVertex=0, finalVertex=0}]}";

        assertEquals(grapString, graph.toString());
    }

    @Test
    public void return_right_toString_two_edges_graph(){

        List<Edge> edgeList = Arrays.asList(new Edge(0, 1, 1),
                                            new Edge(1, 0, 2));

        Graph graph = new Graph(edgeList, 2);
        String grapString = "Graph{vertexAmount=2, representation=[Edge{cost=1, initialVertex=0, finalVertex=1}, Edge{cost=2, initialVertex=1, finalVertex=0}]}";

        assertEquals(grapString, graph.toString());
    }

    @Test
    public void return_right_toString_dense_graph(){

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
        String grapString = "Graph{vertexAmount=7, representation=[Edge{cost=1, initialVertex=0, finalVertex=1}, " +
                "Edge{cost=4, initialVertex=0, finalVertex=3}, Edge{cost=6, initialVertex=0, finalVertex=4}, " +
                "Edge{cost=2, initialVertex=1, finalVertex=2}, Edge{cost=4, initialVertex=1, finalVertex=4}, " +
                "Edge{cost=4, initialVertex=2, finalVertex=4}, Edge{cost=6, initialVertex=2, finalVertex=5}, " +
                "Edge{cost=4, initialVertex=2, finalVertex=6}, Edge{cost=3, initialVertex=3, finalVertex=4}, " +
                "Edge{cost=4, initialVertex=3, finalVertex=6}, Edge{cost=8, initialVertex=4, finalVertex=5}, " +
                "Edge{cost=7, initialVertex=4, finalVertex=6}, Edge{cost=3, initialVertex=5, finalVertex=6}]}";

        assertEquals(grapString, graph.toString());
    }

    @Test
    public void return_empty_spanning_tree_from_empty_graph(){

        Graph graph = new Graph(new ArrayList<>(), 0);

        Kruskal kruskal = new Kruskal();
        List <Edge> spanning_tree = new ArrayList<>();

        assertThat(kruskal.kruskalAlgorithm(graph), is(spanning_tree));

        assertTrue(spanning_tree.size() == 0);
    }

    @Test
    public void return_spanning_tree_from_one_edge_graph(){

        Edge edge = new Edge(0, 0, 1);

        List<Edge> edgeList = Arrays.asList(edge);
        Graph graph = new Graph(edgeList, 1);

        Kruskal kruskal = new Kruskal();
        List <Edge> spanning_tree = new ArrayList<>();

        assertThat(kruskal.kruskalAlgorithm(graph), is(spanning_tree));


    }

    @Test
    public void return_spanning_tree_from_two_edge_graph(){

        Edge edge1 = new Edge(0, 1, 1);
        Edge edge2 = new Edge(0, 2, 2);

        List<Edge> edgeList = Arrays.asList(edge1, edge2);
        Graph graph = new Graph(edgeList, 3);

        Kruskal kruskal = new Kruskal();
        List <Edge> spanning_tree = Arrays.asList(edge1, edge2);

        assertThat(kruskal.kruskalAlgorithm(graph), is(spanning_tree));
    }

    @Test
    public void return_spanning_tree_from_dense_graph(){

        Edge edge1 = new Edge(0, 1, 1);
        Edge edge2 = new Edge(0, 3, 4);
        Edge edge3 = new Edge(0, 4, 6);
        Edge edge4 = new Edge(1, 2, 2);
        Edge edge5 = new Edge(1, 4, 4);
        Edge edge6 = new Edge(2, 4, 4);
        Edge edge7 = new Edge(2, 5, 6);
        Edge edge8 = new Edge(2, 6, 4);
        Edge edge9 = new Edge(3, 4, 3);
        Edge edge10 = new Edge(3, 6, 4);
        Edge edge11 = new Edge(4, 5, 8);
        Edge edge12 = new Edge(4, 6, 7);
        Edge edge13 = new Edge(5, 6, 3);
        List<Edge> edgeList = Arrays.asList(edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9, edge10,
                edge11, edge12, edge13);

        Graph graph = new Graph(edgeList, 7);

        Kruskal kruskal = new Kruskal();
        List <Edge> spanning_tree = Arrays.asList(edge1, edge4, edge9, edge13, edge2, edge8);

        assertThat(kruskal.kruskalAlgorithm(graph), is(spanning_tree));
    }



}
