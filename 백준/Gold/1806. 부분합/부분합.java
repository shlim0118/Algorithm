import java.io.*;
import java.util.*;

public class Main {

    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == s) {
                System.out.println(1);
                return;
            }
        }

        int left = 0;
        int target = s;
        long sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            while (sum >= target) {
                ans = Math.min(ans, i - left + 1);
                sum -= arr[left];
                left++;
            }
        }

        System.out.println((ans == Integer.MAX_VALUE) ? 0 : ans);
    }
}