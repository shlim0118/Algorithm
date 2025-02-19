import java.io.*;
import java.util.*;

public class Main {

    private static int n, m, k, start;
    private static ArrayList<ArrayList<Integer>> graph;
    private static Boolean[] visited;
    private static int[] d;
    private static boolean check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());   // 도시의 개수
        m = Integer.parseInt(st.nextToken());   // 도로의 개수
        k = Integer.parseInt(st.nextToken());   // 거리 정보
        start = Integer.parseInt(st.nextToken());   // 출발 도시의 번호

        graph = new ArrayList<>();
        visited = new Boolean[n+1];
        d = new int[n+1];
        /**
         * 출발지에서부터의 거리를 저장하는 배열
         * 출발지 : 0, 방문하지 않은 곳 -1
          */
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }
        d[start] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        bfs();

        for (int i = 0; i <= n; i++) {
            if (d[i] == k) {
                check = true;
                System.out.println(i);
            }
        }
        if (!check) {
            System.out.println(-1);
        }
    }

    private static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int current = q.poll();

            for (int next : graph.get(current)) {
                if (d[next] == -1) {
                    d[next] = d[current] + 1;
                    q.add(next);
                }
            }
        }
    }

}
