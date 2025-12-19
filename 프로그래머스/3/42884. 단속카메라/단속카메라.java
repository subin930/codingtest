import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        for(int i = 0; i < routes.length; ++i) {
            int start = routes[i][0];
            int end = routes[i][1];
            // System.out.println(start + " " + end);
            
            if(start > min) {
                ++answer;
                min = end;
            }
        }
        
        return answer;
    }
}