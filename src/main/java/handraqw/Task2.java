package handraqw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    static class Edge {
        int to, w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w));
        }

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int INF = 1000000000;
        Arrays.fill(dist, INF);
        dist[s] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && dist[v] != INF) {
                    if (u == -1 || dist[v] < dist[u]) {
                        u = v;
                    }
                }
            }

            if (u == -1) break;
            visited[u] = true;

            for (Edge e : adj.get(u)) {
                if (dist[u] + e.w < dist[e.to]) {
                    dist[e.to] = dist[u] + e.w;
                }
            }
        }

        int unreachable = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == INF) {
                dist[i] = -1;
                unreachable++;
            }
            System.out.print(dist[i] + " ");
        }
        System.out.println("unreachable=" + unreachable);
    }
}
