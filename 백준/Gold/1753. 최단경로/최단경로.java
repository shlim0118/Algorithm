import java.util.*;
import java.io.*;

public class Main {

    static int V, E;
    static int[] distance;
    static boolean[] visited;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());   // 정점
        E = Integer.parseInt(st.nextToken());   // 간선
        distance = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }
        int start = Integer.parseInt(br.readLine());   // 출발지
        distance[start] = 0;


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());   // 시작점
            int v = Integer.parseInt(st.nextToken());   // 도착점
            int w = Integer.parseInt(st.nextToken());   // 가중치
            graph.get(u).add(new Node(v, w));
        }

        dijkstra(start);
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }

    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.v]) continue;
            visited[node.v] = true;
            for (Node n : graph.get(node.v)) {
                if (distance[node.v] + n.w < distance[n.v]) {
                    distance[n.v] = distance[node.v] + n.w;
                    pq.add(new Node(n.v, distance[n.v]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v, w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

}
