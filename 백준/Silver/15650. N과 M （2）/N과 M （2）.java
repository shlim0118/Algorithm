import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visited;
    private static int[] arr;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];
        dfs(0, 0);
        System.out.println(sb);

    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

}
