import java.util.*;
import java.util.stream.*;


class Solution {
    public int solution(String begin, String target, String[] words) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
        int len = begin.length();
        
        if(!list.contains(target)) return 0;
        
        boolean[] visited = new boolean[words.length];
        Deque<int[]> q = new ArrayDeque<>(); //index, cnt
        q.addLast(new int[] {-1, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int index = cur[0]; int cnt = cur[1];
            
            if(index >= 0 && target.equals(words[index])) return cnt;
            
            String curTarget = (index == -1) ? begin : words[index];
            for(int i = 0; i < words.length; ++i) {
                int cntSame = 0;
                for(int j = 0; j < len; ++j) {
                    if(curTarget.charAt(j) == words[i].charAt(j)) ++cntSame;
                }   
                
                if(cntSame >= len - 1 && visited[i] == false) {
                    visited[i] = true;
                    q.addLast(new int[] {i, cnt + 1});
                }
            }
        }
        return 0;
    }
}