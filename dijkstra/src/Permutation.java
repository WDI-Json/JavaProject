import java.util.ArrayList;
import java.util.List;

class Permutation {
  public static int factorial(int x) {
    int f = 1;
    while (x > 1) {
      f = f * x;
      x--;
    }
    return f;
  }

  public static List<Node> permute(List<Node> list, int iteration) {
    if (list.size() <= 1) {
      return list;
    }

    int fact = factorial(list.size() - 1);
    int first = iteration / fact;
    List<Node> copy = new ArrayList<Node>(list);
    Node head = copy.remove(first);
    int remainder = iteration % fact;
    List<Node> tail = permute(copy, remainder);
    tail.add(0, head);
    return tail;
  }

  public static ArrayList<List<Node>> all(List<Node> list) {
    var perms = new ArrayList<List<Node>>();
    for (int i = 0; i < factorial(list.size()); i++) {
      perms.add(permute(list, i));
    }
    return perms;
  }
}
