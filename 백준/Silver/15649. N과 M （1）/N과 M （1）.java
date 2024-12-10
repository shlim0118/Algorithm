import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visit;
    private static int[] arr;
    private static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        arr = new int[m];
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {           // 길이가 M인 수열 출력
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            // 해당 노드를 방문하지 않았다면
            if (!visit[i]) {
                visit[i] = true; // 해당 노드 방문상태 변경
                arr[depth] = i + 1; // 수열에 추가
                dfs(depth + 1);// 재귀를 호출하며 다음 깊이 탐색
                visit[i] = false; // 방문 상태 변경 (백트래킹)
            }
        }
    }
}