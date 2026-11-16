package handraqw;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            inDegree[v]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (int to : adj.get(u)) {
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    q.add(to);
                }
            }
        }

        int afterX = 0;
        boolean found = false;
        for (int v : order) {
            if (found) {
                afterX++;
            } else if (v == x) {
                found = true;
            }
        }

        System.out.print("order=");
        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i));
            if (i < order.size() - 1) System.out.print(" ");
        }
        System.out.println(" afterX=" + afterX);
    }
}
