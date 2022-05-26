package routeplannerpoc.windesheimdemo.Dijkstra;


public class Node {
  public String name;
  public double x;
  public double y;

  public Node(String name, double x, double y) {
      this.name = name;
      this.x = x;
      this.y = y;
  }

  public double distance(Node otherNode) {
      double ac = Math.abs(otherNode.y - this.y);
      double cb = Math.abs(otherNode.x - this.x);
      return Math.hypot(ac, cb);
  }

  public double getX() {
      return x;
  }

  public double getY() {
      return y;
  }

  @Override
    public String toString() {
        return name;
    }
}

