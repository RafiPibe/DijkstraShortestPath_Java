import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Node> nodes = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
        edge.getSource().addEdge(edge);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Node getNodeById(String id) {
        for (Node node : nodes) {
            if (node.getId().equals(id)) {
                return node;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
