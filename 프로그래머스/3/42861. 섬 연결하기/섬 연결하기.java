import java.util.*;

class Solution {
    public static List<List<Integer>> list;
    public static int[][] cost;
    
    public int solution(int n, int[][] costs) {
        int answer = Integer.MAX_VALUE;
        
        //초기화 
        list = new ArrayList<>();
        cost = new int[n][n];
        
        for(int i = 0; i < n; ++i) {
            list.add(new ArrayList<>());
            Arrays.fill(cost[i], -1);
        }
        
        for(int i = 0; i < costs.length; ++i) {
            int[] tmp = costs[i];
            int n1 = tmp[0];
            int n2 = tmp[1];
            
            list.get(n1).add(n2);
            list.get(n2).add(n1);
            
            cost[n1][n2] = tmp[2];
            cost[n2][n1] = tmp[2];
        }
        
        for(int i = 0; i < n; ++i) {
            // System.out.println("start " + i);
            boolean[] visited = new boolean[n];
            visited[i] = true;
            int cur = visit(visited, i, 1, n, 0);
            
            if(cur > 0 && answer > cur) answer = cur;

        }
            
        return answer;
    }
    static int visit(boolean[] visited, int next, int cnt, int n, int sum) {
        if(cnt == n) {
            // System.out.println("sum " + sum);
            return sum;
        }
        
        int minIdx = -1;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < visited.length; ++i) {
            if(!visited[i]) continue;
            
            List<Integer> tmp = list.get(i);
            
            for(int num : tmp) {
                int curCost = cost[i][num];
                if(!visited[num] && curCost >= 0 && curCost < min) {
                    min = curCost;
                    minIdx = num;
                }
            }
        }

        
        if(minIdx < 0) return -1;
        
        visited[minIdx] = true;
        return visit(visited, minIdx, cnt + 1, n, sum + min);
    }
}