import java.util.*;
public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};
    
    static void bfs (int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] {r, c});
        arr[r][c] = 1;
        
        while (!q.isEmpty()) {
            int[]cur = q.poll();
            
            int row = cur[0];
            int col = cur[1];
            
            visited[row][col] = true;
            
            for (int i = 0; i<4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                
                if (arr[nr][nc] == 1)
                    continue;
                
                arr[nr][nc] = 1;
                
                q.offer(new int[] {nr, nc});
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[n+2][n+2];
        visited = new boolean[n+2][n+2];
        
        for (int i = 0; i< n+2; i++) {
            arr[i][0] = 1;
            arr[i][n+1] = 1;
            arr[0][i] = 1;
            arr[n+1][i] = 1;
        }
        
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                arr[i][j] = sc.nextInt();
        
        
        int[][] starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt();
            starts[i][1] = sc.nextInt();
            bfs(starts[i][0], starts[i][1]);
        }

        int cnt = 0;
        
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=n; j++) {
                if (visited[i][j] == true)
                    cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}