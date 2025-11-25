import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b); //강의실 큐

        for(int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }

        //정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < N; ++i) {
            int start = arr[i][0];
            int end = arr[i][1];

            if(q.isEmpty() || q.peek() > start) {
                q.add(end);
            } else {
                q.poll();
                q.add(end);
            }
        }

        bw.write(String.valueOf(q.size()));
        bw.flush();

        br.close();
        bw.close();
    }
}
