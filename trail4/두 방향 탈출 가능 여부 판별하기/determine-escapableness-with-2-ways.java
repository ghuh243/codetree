import java.util.*;
public class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    static int n;
    static int m;
    static int answer;
    
    public static void dfs(int row, int col) {
        if (row == n && col == m) {
            answer = 1;
            return;
        }
        //방향
        for (int i = 0; i<2; i++) {
            int nr = dr[i]+row;
            int nc = dc[i]+col;
            
            if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc);
                                
                if (answer == 1)
                    return;
            }
        }
        
        return;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer = 0;
        grid = new int[n+2][m+2];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                grid[i][j] = sc.nextInt();
        
        visited = new boolean[n+2][m+2];
        visited[1][1] = true;
        
        dfs(1, 1);
        System.out.println(answer);
    }
}