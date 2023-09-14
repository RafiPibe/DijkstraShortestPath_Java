import java.util.*;

public class Dijkstra {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // Create graph
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> nodeA = new HashMap<>();
        nodeA.put("B", 1);
        nodeA.put("C", 3);
        nodeA.put("D", 5);
        graph.put("A", nodeA);
        Map<String, Integer> nodeB = new HashMap<>();
        nodeB.put("A", 1);
        nodeB.put("F", 4);
        nodeB.put("E", 7);
        graph.put("B", nodeB);
        Map<String, Integer> nodeC = new HashMap<>();
        nodeC.put("A", 3);
        nodeC.put("F", 1);
        graph.put("C", nodeC);
        Map<String, Integer> nodeD = new HashMap<>();
        nodeD.put("A", 5);
        nodeD.put("G", 2);
        graph.put("D", nodeD);
        Map<String, Integer> nodeE = new HashMap<>();
        nodeE.put("B", 7);
        nodeE.put("G", 1);
        nodeE.put("I", 6);
        graph.put("E", nodeE);
        Map<String, Integer> nodeF = new HashMap<>();
        nodeF.put("B", 4);
        nodeF.put("C", 1);
        nodeF.put("G", 2);
        nodeF.put("H", 6);
        graph.put("F", nodeF);
        Map<String, Integer> nodeG = new HashMap<>();
        nodeG.put("D", 2);
        nodeG.put("F", 2);
        nodeG.put("H", 4);
        nodeG.put("L", 1);
        graph.put("G", nodeG);
        Map<String, Integer> nodeH = new HashMap<>();
        nodeH.put("F", 6);
        nodeH.put("J", 1);
        graph.put("H", nodeH);
        Map<String, Integer> nodeI = new HashMap<>();
        nodeI.put("E", 6);
        nodeI.put("J", 2);
        nodeI.put("M", 4);
        graph.put("I", nodeI);
        Map<String, Integer> nodeJ = new HashMap<>();
        nodeJ.put("H", 1);
        nodeJ.put("I", 2);
        nodeJ.put("K", 1);
        nodeJ.put("M", 7);
        graph.put("J", nodeJ);
        Map<String, Integer> nodeK = new HashMap<>();
        nodeK.put("J", 1);
        nodeK.put("L", 4);
        graph.put("K", nodeK);
        Map<String, Integer> nodeL = new HashMap<>();
        nodeL.put("G", 1);
        nodeL.put("K", 4);
        nodeL.put("M", 3);
        graph.put("L", nodeL);
        Map<String, Integer> nodeM = new HashMap<>();
        nodeM.put("I", 4);
        nodeM.put("L", 3);
        graph.put("M", nodeM);

        // Calculate shortest path
        Map<String, Integer> shortestDistances = calculateShortestDistances(graph, "A");

        // Print shortest distance
        int shortestDistance = shortestDistances.get("M");
        if (shortestDistance == INFINITY) {
            System.out.println("There is no path from A to M");
        } else {
            System.out.println("Shortest distance from A to M: " + shortestDistance);

            // Print shortest path
            System.out.print("Shortest path from A to M: ");
            String currentNode = "M";
            List<String> path = new ArrayList<>();
            while (!currentNode.equals("A")) {
                path.add(currentNode);
                for (String node : graph.keySet()) {
                    if (graph.get(node).containsKey(currentNode) && shortestDistances.get(node) + graph.get(node).get(currentNode) == shortestDistances.get(currentNode)) {
                        currentNode = node;
                        break;
                    }
                }
            }
            path.add("A");
            Collections.reverse(path);
            System.out.println(String.join(" -> ", path));
        }
    }

    private static Map<String, Integer> calculateShortestDistances(Map<String, Map<String, Integer>> graph, String startNode) {
        Map<String, Integer> distances = new HashMap<>();
        for (String node : graph.keySet()) {
            distances.put(node, INFINITY);
        }
        distances.put(startNode, 0);

        Set<String> visitedNodes = new HashSet<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        priorityQueue.add(startNode);

        while (!priorityQueue.isEmpty()) {
            String currentNode = priorityQueue.poll();
            visitedNodes.add(currentNode);

            Map<String, Integer> neighbors = graph.get(currentNode);
            if (neighbors != null) {
                for (String neighbor : neighbors.keySet()) {
                    int distance = distances.get(currentNode) + neighbors.get(neighbor);
                    if (distance < distances.get(neighbor)) {
                        distances.put(neighbor, distance);
                        priorityQueue.add(neighbor);
                    }
                }
            }
        }

        return distances;
    }
}
