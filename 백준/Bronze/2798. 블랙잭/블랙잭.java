import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] number = new int[N];
        int i = 0;
        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            number[i++] = Integer.parseInt(st.nextToken());
        }

        // sol (1) 정렬 후 배열의 앞 인덱스부터 3개씩 선택하여 target값과 비교
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < number.length - 2; k++) {
            for (int m = k + 1; m < number.length - 1; m++) {
                for (int j = m + 1; j < number.length; j++) {
                    int tmp = number[k] + number[m] + number[j];
                    if (tmp <= target && tmp > max) {
                        max = tmp;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
