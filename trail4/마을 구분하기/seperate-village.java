import java.util.*;

public class Main {
static int n;
    static int[][]arr;
    static boolean[][] visit;
    static ArrayList<Integer> list;
    static int cnt;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static void dfs(int r, int c) {

        visit[r][c] = true;
        cnt++;
        
        
        for (int k = 0; k<4; k++) {
            int nr = r+dr[k];
            int nc = c+dc[k];
            
            if (arr[nr][nc] == 1 && !visit[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        arr = new int[n+2][n+2];
        visit = new boolean[n+2][n+2];
        list = new ArrayList<>();        
        
        for (int i = 0; i<n+2; i++) {
            visit[n+1][i] = true;
            visit[0][i] = true;
            visit[i][n+1] = true;
            visit[i][0] = true;
        }
        
        for (int i =1; i<=n; i++) {
            for (int j = 1; j<=n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 0) {
                    visit[i][j] = true;
                }
            }
        }
        
        for (int i =1; i<=n; i++) {
            for (int j = 1; j<=n; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }
        
        list.sort(null);
        
        System.out.println(list.size());
        for (int li : list) {
            System.out.println(li);
            
        }
    }
}