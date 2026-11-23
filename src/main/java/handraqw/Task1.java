package handraqw;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;

    static void dfs(int v, ArrayList<Integer> comp) {
        visited[v] = true;
        comp.add(v);
        for (int to : adj.get(v)) {
            if (!visited[to]) {
                dfs(to, comp);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        adj.clear();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visited = new boolean[n];
        int[] size = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(i, comp);
                for (int v : comp) {
                    size[v] = comp.size();
                }
            }
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int v = sc.nextInt();
            System.out.println(size[v]);
        }
        System.out.println(count);
    }
}
