import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N; //도시의 개수
    public static int M; //버스의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //버스 정보 저장(출발 도시 번호, 도착 도시 번호, 버스 비용) -> 버스가 간선
        List<List<int[]>> list = new ArrayList<>(); //도착, 가중치
        int[] dist = new int[N + 1];

        for(int i = 0; i <= N; ++i) {
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }


        for(int i = 0; i < M; ++i) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            int w = Integer.parseInt(str.nextToken());

            list.get(u).add(new int[] {v, w});
        }

        //출발 도시 번호, 도착 도시 번호4
        StringTokenizer str3 = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(str3.nextToken());
        int end = Integer.parseInt(str3.nextToken());

        dist[start] = 0;

        //로직
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]); //dist, node
        q.offer(new int[] {dist[start], start});

        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int d = arr[0]; int n = arr[1];

            if(d > dist[n]) continue;

            for(int[] node : list.get(n)) {
                //end, weight
                if(dist[node[0]] > dist[n] + node[1]) {
                    dist[node[0]] = dist[n] + node[1];
                    q.offer(new int[] {dist[node[0]], node[0]});
                }
            }
        }

        bw.write(dist[end] + "");
        bw.flush();
        bw.close(); br.close();
    }

}
