import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;




public class App {
    public static void main(String[] args) throws Exception {
        // [{"title": "Hogeschool Windesheim", "location": { "lat": 52.49953, "lng":
        // 6.07845 }},
        // {"title": "Engelse werk","location": { "lat": 52.4970232, "lng": 6.06394 }},
        // {"title": "Scania","location": { "lat": 52.5255141, "lng": 6.0800041 }},
        // {"title": "McDonalds Noord", "location": { "lat": 52.5224281, "lng":
        // 6.1145818 }},
        // {"title": "Hogeschool Windesheim", "location": { "lat": 52.49953, "lng":
        // 6.07845 }}]
        ArrayList<String> stringArray = new ArrayList<String>();
        String nodelist= """
            [{"id":1,"value":"ORDER:1, CUSTOMER: 1, ISRETOUR: false, ADDRESS: campus 2 8017CA Zwolle","location":{"lat":52.49953,"lng":6.07845}},
            {"id":2,"value":"ORDER:2, CUSTOMER: 2, ISRETOUR: false, ADDRESS:    Barendrecht","location":{"lat":51.853,"lng":4.4539}},
            {"id":3,"value":"ORDER:3, CUSTOMER: 3, ISRETOUR: false, ADDRESS:    Zwolle","location":{"lat":52.5255141,"lng":6.0800041}},
            {"id":4,"value":"ORDER:4, CUSTOMER: 4, ISRETOUR: true, ADDRESS: campus 2 8017CA Zoetermeer","location":{"lat":52.0621451,"lng":4.4165747}}]
                """;


        Node nodeA = new Node("Windesheim[1]", 52.49953, 6.07845);
        Node nodeB = new Node("EngelseWerk[2]", 52.4970232, 6.06394);
        Node nodeC = new Node("Scania[3]", 52.5255141, 6.0800041);
        Node nodeD = new Node("McDonaldsNoord[4]", 52.49953, 6.07845);
        Node[] oldnodes = { nodeA, nodeB, nodeC, nodeD };
        List<Node> nodes= new ArrayList<>();
        nodes.add(nodeA);
        nodes.add(nodeB);
        nodes.add(nodeC);
        nodes.add(nodeD);

        DijkstraRouteOrder(nodes);
    }

    public static List<Node> DijkstraRouteOrder(List<Node> nodes) {
        Node firstNode = nodes.get(0);

        ArrayList<Node> nodesList = new ArrayList<>(nodes);
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
        var previousDistance = 0.00;
        List<Node> optimalPath = new ArrayList<Node>();
        var possiblePaths = Permutation.all(nodesWithoutStart);
        for (List<Node> path : possiblePaths) {
            path.add(0, firstNode);
            var totalDistance = calcTotalDistance(distances, path);
            System.out.println("total distance for path " + humanPathFromNodeList(path) + " = " + totalDistance);
            if (previousDistance == 0.00 || previousDistance > totalDistance) {
                // System.out.println("Current Score " + previousDistance);
                optimalPath = path;
                previousDistance = totalDistance;
            } else if (previousDistance < totalDistance) {
                // System.out.println(previousDistance + "vs totalDistance: " + totalDistance);
                previousDistance = totalDistance;
            }

        }
        System.out.println("The optimal route with a score of " + calcTotalDistance(distances, optimalPath) + "");
        for (Node name : optimalPath) {
            System.out.print(name);
        }
        return optimalPath;
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
