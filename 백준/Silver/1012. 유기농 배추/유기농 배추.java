import java.io.*;
import java.util.*;

public class Main {

    private static int testcase, width, length, kimchi;
    private static int[][] board;
    private static boolean[][] visited;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());

        for (int k = 0; k < testcase; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            kimchi = Integer.parseInt(st.nextToken());

            board = new int[width][length];
            visited = new boolean[width][length];

            for (int i = 0; i < kimchi; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            int bugs = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        bugs++;
                    }
                }
            }
            System.out.println(bugs);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < width && ny >= 0 && ny < length) {
                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }

}
