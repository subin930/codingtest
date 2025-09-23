import java.util.*;

class Solution {
    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dx = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        //큐에 넣는 객체 (현재 위치, count (int[3]))
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] visited = new int[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        
        q.addLast(new int[] {0, 0, 1});
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.pollFirst();
            
            int y = cur[0]; int x = cur[1]; int cnt = cur[2];
            if(y == n - 1 && x == m - 1) return cnt;
            
            for(int i = 0; i < 4; ++i) {
                int cy = y + dy[i];
                int cx = x + dx[i];
                if(cy >= 0 && cy < n && cx >= 0 && cx < m && visited[cy][cx] == 0 && maps[cy][cx] == 1) {
                    visited[cy][cx] = 1;
                    q.addLast(new int[] {cy, cx, cnt + 1});
                }
            }
        }
        
        return -1;
    }
}