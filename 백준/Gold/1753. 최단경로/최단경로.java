import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int V; //정점 개수
    public static int E; //간선 개수
    public static int K; //시작 정점
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        V = Integer.parseInt(str.nextToken());
        E = Integer.parseInt(str.nextToken());

        K = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]); //dist, node
        int[] dist = new int[V + 1];

        q.offer(new int[] {0, K});

        List<List<int[]>> list = new ArrayList<>();

        for(int i = 0; i <= V; ++i){
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        dist[K] = 0;

        for(int i = 0; i < E; ++i) {
            //u, v, w
            StringTokenizer str2 = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(str2.nextToken());
            int v = Integer.parseInt(str2.nextToken());
            int w = Integer.parseInt(str2.nextToken());

            list.get(u).add(new int[] {v, w});
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll(); //dist, node
            int d = cur[0];
            int n = cur[1];

            if(d > dist[n]) continue;

            for(int[] node : list.get(n)) {
                //node, weight
                if(dist[node[0]] > dist[n] + node[1]) {
                    dist[node[0]] = dist[n] + node[1];
                    q.offer(new int[] {dist[node[0]], node[0]});
                }
            }
        }

        for(int i = 1; i <= V; ++i) {
            bw.write((dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
