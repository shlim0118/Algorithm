import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] time = new int[N];
        int sum = 0;
        int pre = 0;
        int k = 0;

        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            time[k++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);
        for (int i = 0; i < N; i++) {
            pre += time[i];
            sum += pre;
        }

        System.out.println(sum);

    }
}
