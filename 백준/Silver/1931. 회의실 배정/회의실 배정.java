import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());            // 회의 개수
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        /**
         * 끝나는 시간이 제일 짧은 순으로 정렬
         */
        Collections.sort(meetings, (m1, m2) -> {
            int result = Integer.compare(m1.end, m2.end);
            if (result == 0) {
                return Integer.compare(m1.start, m2.start);
            }
            return result;
        });

        int cnt = 0;
        int end_time = 0;

        for (Meeting m : meetings) {
            if (m.start >= end_time) {
                end_time = m.end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return  "(" + start +
                ", " + end + ")";
    }
}