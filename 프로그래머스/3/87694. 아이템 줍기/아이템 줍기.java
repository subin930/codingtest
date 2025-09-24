import java.util.*;
import java.util.stream.*;

class Solution {
    private static final int[] dx = {1, 0, -1, 0}; //i
    private static final int[] dy = {0, 1, 0, -1}; //j
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] pos = new int[101][101]; //길이 2배 -> 가로/세로 길이 1인 사각형 고려
        boolean[][] visited = new boolean[101][101];
        
        itemX *= 2;
        itemY *= 2;
        characterX *= 2;
        characterY *= 2;
        
        //바깥쪽 1 / 안쪽 -1로 색칠
        for(int[] l : rectangle) {
            int x1 = l[0] * 2; int x2 = l[2] * 2; int y1 = l[1] * 2; int y2 = l[3] * 2;
            
            for(int y = y1; y <= y2; ++y) {
                for(int x = x1; x <= x2; ++x) {
                    if((x == x1 || x == x2 || y == y1 || y == y2) && pos[y][x] != -1) {
                        pos[y][x] = 1;
                    } else {
                        pos[y][x] = -1;
                    }
                }
            }
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[] {characterY, characterX, 0});
        visited[characterY][characterX] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int y = cur[0]; int x = cur[1]; int distance = cur[2];
            
            if(y == itemY && x == itemX) return distance / 2;
            
            for(int i = 0; i < 4; ++i) {
                int cy = y + dy[i]; int cx = x + dx[i];
                
                if(cy > 100 || cy < 0 || cx > 100 || cx < 0) continue;
                if(pos[cy][cx] == 1 && !visited[cy][cx]) {
                    q.addLast(new int[] {cy, cx, distance + 1});
                    visited[cy][cx] = true;
                }
            }
        }
        
        return 0;
    }
}