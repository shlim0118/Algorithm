import java.io.*;
import java.util.*;

public class Main {

    private static int people, parent, num, chon;
    private static ArrayList<ArrayList<Integer>> list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        people = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int child = Integer.parseInt(st.nextToken());
        parent = Integer.parseInt(st.nextToken());

        num = Integer.parseInt(br.readLine());      // 관계 수
        list = new ArrayList<>();
        for (int i = 0; i <= people; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[people + 1];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(p).add(c);
            list.get(c).add(p);

        }

        chon = -1;
        dfs(child, 0);
        System.out.println(chon);
    }
    private static void dfs(int child, int count) {

        visited[child] = true;

        if (chon != -1) return;
        if (child == parent) {
            chon = count;
            return;
        }
        /**
         * child가 3이면 반복문과 재귀를 통해 연결된 모든 노드들을 탐색
         */
        for (int i : list.get(child)) {
            if (!visited[i]) {
                dfs(i, count + 1);
            }
        }
    }

}
