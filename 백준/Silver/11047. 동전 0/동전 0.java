import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        int idx = 0;            // 배열의 인덱스
        int cnt = 0;            // 동전의 개수

        while (N > 0) {
            coins[idx++] = Integer.parseInt(br.readLine());
            N--;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            if (K / coins[i] >= 1) {
                cnt += K / coins[i];
                K %= coins[i];
            }
            if (K == 0) {
                break;
            }

        }
        System.out.println(cnt);
    }

}
