import java.util.*;

public class Main {

    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(0,1,4);
        g.addEdge(0,2,3);
        g.addEdge(1,2,1);
        g.addEdge(1,3,2);
        g.addEdge(2,3,4);
        g.addEdge(3,4,2);
        g.addEdge(4,5,6);


        List<Edge> mst = MST.buildMST(g);
        System.out.println("MST before removal:");
        mst.forEach(System.out::println);


        Edge removed = mst.get(2);
        mst.remove(removed);

        System.out.println("\nRemoved edge: " + removed);


        System.out.println("\nComponents after removal:");
        UnionFind uf = new UnionFind(g.vertices);
        for (Edge e : mst)
            uf.union(e.src, e.dest);

        Map<Integer, List<Integer>> comp = new HashMap<>();
        for (int i = 0; i < g.vertices; i++) {
            int root = uf.find(i);
            comp.putIfAbsent(root, new ArrayList<>());
            comp.get(root).add(i);
        }

        comp.forEach((k, v) -> System.out.println("Component: " + v));


        Edge replacement = null;
        for (Edge e : g.edges) {
            if (uf.find(e.src) != uf.find(e.dest)) {
                if (replacement == null || e.weight < replacement.weight)
                    replacement = e;
            }
        }

        System.out.println("\nReplacement edge: " + replacement);


        mst.add(replacement);
        System.out.println("\nNew MST:");
        mst.forEach(System.out::println);
    }
}
