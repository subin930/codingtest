import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(br.readLine().split(" ")).forEach(x -> {set.add(Integer.parseInt(x));});

        int M = Integer.parseInt(br.readLine());

        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < M; ++i) {
            if(set.contains(target[i])) bw.write("1\n");
            else bw.write("0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
