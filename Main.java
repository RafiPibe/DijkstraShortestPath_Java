
public class Main {

    public static void main(String[] args) {

        // Create nodes
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");
        Node nodeJ = new Node("J");
        Node nodeK = new Node("K");
        Node nodeL = new Node("L");
        Node nodeM = new Node("M");

        // Create edges
        Edge edgeAB = new Edge(nodeA, nodeB, 1);
        Edge edgeAC = new Edge(nodeA, nodeC, 3);
        Edge edgeAD = new Edge(nodeA, nodeD, 5);

        Edge edgeBA = new Edge(nodeB, nodeA, 1);
        Edge edgeBE = new Edge(nodeB, nodeE, 7);
        Edge edgeBF = new Edge(nodeB, nodeF, 4);

        Edge edgeCA = new Edge(nodeC, nodeA, 3);
        Edge edgeCF = new Edge(nodeC, nodeF, 1);

        Edge edgeDA = new Edge(nodeD, nodeA, 5);
        Edge edgeDG = new Edge(nodeD, nodeG, 2);

        Edge edgeEB = new Edge(nodeE, nodeB, 7);
        Edge edgeEG = new Edge(nodeE, nodeG, 1);
        Edge edgeEI = new Edge(nodeE, nodeI, 6);

        Edge edgeFB = new Edge(nodeF, nodeB, 4);
        Edge edgeFC = new Edge(nodeF, nodeC, 1);
        Edge edgeFG = new Edge(nodeF, nodeG, 2);
        Edge edgeFH = new Edge(nodeF, nodeH, 6);

        Edge edgeGD = new Edge(nodeG, nodeD, 2);
        Edge edgeGF = new Edge(nodeG, nodeF, 2);
        Edge edgeGH = new Edge(nodeG, nodeH, 4);
        Edge edgeGL = new Edge(nodeG, nodeL, 1);

        Edge edgeHF = new Edge(nodeH, nodeF, 6);
        Edge edgeHJ = new Edge(nodeH, nodeJ, 1);
        Edge edgeHG = new Edge(nodeH, nodeG, 4);

        Edge edgeIE = new Edge(nodeI, nodeE, 6);
        Edge edgeIJ = new Edge(nodeI, nodeJ, 2);
        Edge edgeIM = new Edge(nodeI, nodeM, 4);

        Edge edgeJH = new Edge(nodeJ, nodeH, 1);
        Edge edgeJI = new Edge(nodeJ, nodeI, 2);
        Edge edgeJK = new Edge(nodeJ, nodeK, 1);
        Edge edgeJM = new Edge(nodeJ, nodeM, 7);

        Edge edgeKJ = new Edge(nodeK, nodeJ, 1);
        Edge edgeKL = new Edge(nodeK, nodeL, 4);

        Edge edgeLG = new Edge(nodeL, nodeG, 1);
        Edge edgeLK = new Edge(nodeL, nodeK, 4);
        Edge edgeLM = new Edge(nodeL, nodeM, 3);

        Edge edgeMI = new Edge(nodeM, nodeI, 4);
        Edge edgeML = new Edge(nodeM, nodeL, 3);

        // Create graph
        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);

        graph.addEdge(edgeAB);
        graph.addEdge(edgeAC);
        graph.addEdge(edgeAD);

        graph.addEdge(edgeBA);
        graph.addEdge(edgeBE);
        graph.addEdge(edgeBF);

        graph.addEdge(edgeCA);
        graph.addEdge(edgeCF);

        graph.addEdge(edgeDA);
        graph.addEdge(edgeDG);

        graph.addEdge(edgeEB);
        graph.addEdge(edgeEG);
        graph.addEdge(edgeEI);

        graph.addEdge(edgeFB);
        graph.addEdge(edgeFC);
        graph.addEdge(edgeFG);
        graph.addEdge(edgeFH);

        graph.addEdge(edgeGD);
        graph.addEdge(edgeGF);
        graph.addEdge(edgeGH);
        graph.addEdge(edgeGL);

        graph.addEdge(edgeHF);
        graph.addEdge(edgeHJ);
        graph.addEdge(edgeHG);

        graph.addEdge(edgeIE);
        graph.addEdge(edgeIJ);
        graph.addEdge(edgeIM);

        graph.addEdge(edgeJH);
        graph.addEdge(edgeJI);
        graph.addEdge(edgeJK);
        graph.addEdge(edgeJM);

        graph.addEdge(edgeKJ);
        graph.addEdge(edgeKL);

        graph.addEdge(edgeLG);
        graph.addEdge(edgeLK);
        graph.addEdge(edgeLM);
        
        graph.addEdge(edgeMI);
        graph.addEdge(edgeML);

        // Execute Dijkstra's algorithm
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodeA);

        // Print shortest path from A to M
        System.out.println("Shortest path from A to M: " + dijkstra.getPath(nodeM));
        System.out.println("Total weight of the shortest path from A to M: " + dijkstra.getPathWeight(nodeM));
    }
}
