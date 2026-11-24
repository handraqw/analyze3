package handraqw;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static int[] p;

    static int find(int v) {
        if (p[v] == v) return v;
        return p[v] = find(p[v]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            p[a] = b;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long budget = sc.nextLong();

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        edges.sort((e1, e2) -> e1.w - e2.w);

        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        long totalCost = 0;
        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                totalCost += e.w;
            }
        }

        if (totalCost <= budget) {
            System.out.println("YES " + totalCost);
        } else {
            System.out.println("NO " + totalCost);
        }
    }
}
