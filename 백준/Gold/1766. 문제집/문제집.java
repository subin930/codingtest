import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static int N; //문제 수
    public static int M; //정보 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        int[] check = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, N + 1).forEach(x -> arr.add(new ArrayList<>()));

        for(int i = 0; i < M; ++i) {
            StringTokenizer str2 = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(str2.nextToken());
            int v = Integer.parseInt(str2.nextToken());

            check[v]++;
            arr.get(u).add(v);
        }

        Queue<Integer> result = new LinkedList<>();
        for(int i = 0; i < N; ++i) {
            //최솟값 찾기
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= N; ++j) {
                if(min > j && check[j] == 0 && !visited[j]){
                    min = j;
                    break;
                }
            }

            visited[min] = true;
            for(int num : arr.get(min)) {
                check[num]--;
            }
            result.offer(min);
        }

        for(int i = 0; i < N; ++i) {
            bw.write(result.poll() + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
