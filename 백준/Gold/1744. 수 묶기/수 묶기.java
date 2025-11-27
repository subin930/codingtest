import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //배열 크기

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int ones = 0;
        int zeros = 0;

        for(int i = 0; i < N; ++i) {
            int n = Integer.parseInt(br.readLine());

            if(n == 1) ones++;
            else if(n == 0) zeros++;
            else if(n > 0) pos.add(n);
            else neg.add(n);
        }

        pos.sort(Comparator.reverseOrder());
        neg.sort(Comparator.naturalOrder());

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < pos.size(); i += 2) {
            if(i + 1 < pos.size()) {
                result.add(pos.get(i) * pos.get(i + 1));
            }
            else {
                result.add(pos.get(i));
            }
        }

        for(int i = 0; i < neg.size(); i += 2) {
            if(i + 1 < neg.size()) {
                result.add(neg.get(i) * neg.get(i + 1));
            }
            else {
                if(zeros == 0) {result.add(neg.get(i));}
            }
        }


        bw.write((result.stream().mapToInt(Integer::intValue).sum() + ones) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
