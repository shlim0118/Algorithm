

import java.io.*;

public class Main {

    private static int N;
    private static int cnt;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(cnt);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (check(depth, i)) {
                arr[depth] = i;     // arr[1] = 1이라면 (1, 1)에 퀸이 위치한 것
                dfs(depth + 1);
            }

        }
    }
    // 상하좌우/대각선에 다른 퀸이 위치하는 지 판단하는 함수
    private static boolean check(int row, int col) {

        for (int i = 0; i < row; i++) {
            //같은 열에 위치하는 지 확인
            if (arr[i] == col) return false;
            // 대각선에 위치하는 지 확인
            if (Math.abs(arr[i] - col) == Math.abs(i - row)) return false;
        }
        return true;
    }
}
