package routeplannerpoc.windesheimdemo.Dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Dijkstra {
  public static void DijkstraRouteOrder(Node nodes[]) {
    Node firstNode = nodes[0];

    ArrayList<Node> nodesList = new ArrayList<>(Arrays.asList(nodes));

    // setup distance matrix (nodeA,nodeB = distance between the two)
    HashMap<Node, HashMap<Node, Double>> distances = new HashMap<>();
    for (Node node : nodes) {
        for (Node otherNode : nodes) {
            // System.out.println(node.name + " -> " + otherNode.name);
            var mapToOtherNodes = distances.getOrDefault(node, new HashMap<>());
            var distanceToOther = node.distance(otherNode);
            mapToOtherNodes.put(otherNode, distanceToOther);
            distances.put(node, mapToOtherNodes);
        }
    }
    // printDistances(distances);

    ArrayList<Node> nodesWithoutStart = (ArrayList<Node>) nodesList.clone();
    nodesWithoutStart.remove(firstNode);

    var possiblePaths = Permutation.all(nodesWithoutStart);
    for (List<Node> path : possiblePaths) {
        path.add(0, firstNode);
        var totalDistance = calcTotalDistance(distances, path);
        System.out.println("total distance for path " + humanPathFromNodeList(path) + " = " + totalDistance);
    }

}

public static <T> Stream<List<T>> sliding(List<T> list, int size) {
    if (size > list.size()) {
        return Stream.empty();
    }
    return IntStream
            .range(0, list.size() - size + 1)
            .mapToObj(start -> list.subList(start, start + size));
}

public static double calcTotalDistance(HashMap<Node, HashMap<Node, Double>> distances, List<Node> path) {
    var total = 0.0;
    for (List<Node> nodes : sliding(path, 2).toList()) {
        Node from = nodes.get(0);
        Node to = nodes.get(1);
        // System.out.println("distance between " + from.name + " -> " + to.name);
        total += distances.get(from).get(to);
    }
    return total;
}

public static String humanPathFromNodeList(List<Node> path) {
    var output = "";
    for (Node n : path) {
        output += n.name;
    }
    return output;
}

public static void printDistances(HashMap<Node, HashMap<Node, Double>> distances) {
    for (HashMap.Entry<Node, HashMap<Node, Double>> entry : distances.entrySet()) {
        Node from = entry.getKey();
        HashMap<Node, Double> dists = entry.getValue();

        System.out.println("FROM " + from.name);
        for (HashMap.Entry<Node, Double> toNodes : dists.entrySet()) {
            Node to = toNodes.getKey();
            Double dist = toNodes.getValue();

            System.out.println("\t" + to.name + "\t" + dist);
        }
    }
}
}
