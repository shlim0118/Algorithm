import java.util.*;
import java.io.*;

public class Main {

    private static ArrayList<ArrayList<Integer>> computer = new ArrayList();    // 2차원 리스트 선언
    private static boolean[] visited;
    private static int number;
    private static int connected;
    private static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        number = Integer.parseInt(br.readLine());
        connected = Integer.parseInt(br.readLine());
        visited = new boolean[number + 1];

        for (int i = 0; i <= number; i++) {      // 그래프 초기화 (0 ~ number+1)
            computer.add(new ArrayList<>());
        }

        for (int i = 0; i < connected; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computer.get(a).add(b);
            computer.get(b).add(a);     // 양뱡향 연결
        }

        dfs(1);
        System.out.println(cnt - 1);
    }
    private static void dfs(int node) {
        /**
         * 반복문을 이용하여 해당 노드와 연결된 컴퓨터 탐색
         * 재귀
         */
        visited[node] = true;
        cnt++;
        for (int next_node : computer.get(node)) {
            if (!visited[next_node]) {
                dfs(next_node);
            }
        }
    }

}

