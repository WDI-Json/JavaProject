package RouteplannerPOC.WindesheimDemo.Dijkstra;

import org.junit.jupiter.api.Test;
import routeplannerpoc.windesheimdemo.Dijkstra.Node;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static routeplannerpoc.windesheimdemo.Dijkstra.Dijkstra.*;

class DijkstraTest {

  @Test
  void testdijkstraRouteOrder() {
    Node nodeA = new Node("Windesheim[1]", 52.49953, 6.07845);
    Node nodeB = new Node("EngelseWerk[2]", 52.4970232, 6.06394);
    Node nodeC = new Node("Scania[3]", 52.5255141, 6.0800041);
    Node nodeD = new Node("McDonaldsNoord[4]", 52.49953, 6.07845);
    List<Node> nodes = new ArrayList<>();
    nodes.add(nodeA);
    nodes.add(nodeB);
    nodes.add(nodeC);
    nodes.add(nodeD);
    //Same amount of nodes in as coming out
    assertEquals(4, DijkstraRouteOrder(nodes).size());
  }

  @Test
  void testcalcTotalDistance() {
    //Simulating optionalPath
    Node nodeA = new Node("Windesheim[1]", 52.49953, 6.07845);
    Node nodeB = new Node("EngelseWerk[2]", 52.4970232, 6.06394);
    Node nodeC = new Node("Scania[3]", 52.5255141, 6.0800041);
    Node nodeD = new Node("McDonaldsNoord[4]", 52.49953, 6.07845);
    List<Node> nodes = new ArrayList<>();
    nodes.add(nodeA);
    nodes.add(nodeB);
    nodes.add(nodeC);
    nodes.add(nodeD);
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
    assertEquals(0.07346307718099626, calcTotalDistance(distances, nodes));
  }

  @Test
  void testhumanPathFromNodeList() {

    //Simulating optionalPath
    Node nodeA = new Node("Windesheim[1]", 52.49953, 6.07845);
    Node nodeB = new Node("EngelseWerk[2]", 52.4970232, 6.06394);
    Node nodeC = new Node("Scania[3]", 52.5255141, 6.0800041);
    Node nodeD = new Node("McDonaldsNoord[4]", 52.49953, 6.07845);
    List<Node> nodes = new ArrayList<>();
    nodes.add(nodeA);
    nodes.add(nodeB);
    nodes.add(nodeC);
    nodes.add(nodeD);
    //given name must be humanreadable and concatted
    assertEquals("Windesheim[1]EngelseWerk[2]Scania[3]McDonaldsNoord[4]", humanPathFromNodeList(nodes));
  }
}
