import java.io.*;
import java.util.*;

public class Main {

    static int N, D;
    static List<List<Shortcut>> graph = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[D + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0; // 출발지 값 0

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (end <= D) {     // 도로의 길이 (D)보다 작은 값만 저장
                graph.get(start).add(new Shortcut(end, dist));
            }
        }

        dijkstra();
        System.out.println(distance[D]);
    }

    private static void dijkstra() {
        PriorityQueue<Shortcut> pq = new PriorityQueue<>();
        pq.add(new Shortcut(0, 0));     // 출발지부터 시작하여 최단 경로 탐색
        while (!pq.isEmpty()) {
            Shortcut current = pq.poll();
            if (current.dist > distance[current.end]) continue;

            // 도로의 길이를 넘지 않고, distance에 저장된 값보다 작은 경우
            //  current.end : 현재 위치, current.dist : 현재 위치까지의 이동한 거리
            if (current.end + 1 <= D && current.dist + 1 < distance[current.end + 1]) {
                distance[current.end + 1] = current.dist + 1;
                pq.add(new Shortcut(current.end + 1, current.dist + 1));
            }
            // 현재 위치에서 연결된 지름길들을 찾아 이동하는 거리 짧도록 다음 step으로 이동
            for (Shortcut s : graph.get(current.end)) {
                if (current.dist + s.dist < distance[s.end]) {
                    distance[s.end] = current.dist + s.dist;
                    pq.add(new Shortcut(s.end, current.dist + s.dist));
                }
            }
            
        }
    }

    static class Shortcut implements Comparable<Shortcut> {

        int end, dist;

        public Shortcut(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Shortcut sc) {
            return this.dist - sc.dist;
        }
    }

}
