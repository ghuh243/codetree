import java.util.*;

public class Main {
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n;
    static int m;
    
    static int bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        
        arr[r][c] = 0;
        q.offer(new int[] {r, c});
        
        
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int row = cur[0];
            int col = cur[1];
            
            if (row == n && col == m)
                return 1;
            
            for (int i = 0; i< 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                
                
                if (arr[nr][nc] == 0)
                    continue;
            
                arr[nr][nc] = 0;
                
                q.offer(new int[] {nr, nc});
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+2][m+2];
        
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                arr[i][j] = sc.nextInt();
        
        
        System.out.println(bfs(1, 1));
    }
}