import java.util.*;

public class MST {

    public static List<Edge> buildMST(Graph graph) {
        List<Edge> result = new ArrayList<>();
        Collections.sort(graph.edges);
        UnionFind uf = new UnionFind(graph.vertices);

        for (Edge e : graph.edges) {
            int root1 = uf.find(e.src);
            int root2 = uf.find(e.dest);

            if (root1 != root2) {
                uf.union(root1, root2);
                result.add(e);
            }
        }
        return result;
    }

    public static Edge findReplacementEdge(Graph graph, int compA, int compB, List<Edge> removedMST) {
        Edge best = null;

        for (Edge e : graph.edges) {
            if (removedMST.contains(e)) continue;

            boolean connects =
                    (e.src == compA && e.dest == compB) ||
                            (e.src == compB && e.dest == compA);

            if (connects) {
                if (best == null || e.weight < best.weight) {
                    best = e;
                }
            }
        }
        return best;
    }
}
