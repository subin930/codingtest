import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str1.nextToken()); //학생 수
        int M = Integer.parseInt(str1.nextToken()); //비교 횟수
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= N; ++i) graph.add(new ArrayList<>());

        boolean[] visited = new boolean[N + 1];
        for(int i = 0; i < M; ++i) {
            StringTokenizer str2 = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(str2.nextToken());
            int v = Integer.parseInt(str2.nextToken());

            graph.get(u).add(v);
        }


        for(int i = 1; i <= N; ++i) {
            if(!visited[i]) dfs(graph, i, visited);
        }

        for(int i = 0; i < N; ++i) bw.write(stack.pop() + " ");

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, int cur, boolean[] visited) {
        visited[cur] = true;

        for(int next : graph.get(cur)) {
            if(!visited[next]) dfs(graph, next, visited);
        }

        stack.add(cur);
    }
}
