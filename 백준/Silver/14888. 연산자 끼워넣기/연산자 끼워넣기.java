

import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    private static int[] op = new int[4];
    private static int N;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int num, int index) {

        if (index == N) {
            max = Math.max(max, num);    // 두 인자 중 큰 값을 리턴
            min = Math.min(min, num);    // 두 인자 중 작은 값을 리턴
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch(i) {
                    case 0: dfs(num + arr[index], index+1); break;
                    case 1: dfs(num - arr[index], index+1); break;
                    case 2: dfs(num * arr[index], index+1); break;
                    case 3: dfs(num / arr[index], index+1); break;
                }
                op[i]++;
            }
        }
    }

}
