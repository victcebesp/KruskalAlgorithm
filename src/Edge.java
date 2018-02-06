public class Edge {
    private final int cost;
    private final int vertex;

    public Edge(int cost, int vertex) {
        this.cost = cost;
        this.vertex = vertex;
    }

    public int getCost() {
        return cost;
    }

    public int getVertex() {
        return vertex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "cost=" + cost +
                ", vertex=" + vertex +
                '}';
    }
}
