import java.util.*;
import java.io.*;

class Solution {
    
    static ArrayList<Integer> answer;
    static boolean[][] visited;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static boolean chk;
    
    public ArrayList solution(String[][] places) {
        answer = new ArrayList<>();
        
        for(String[] place:places){
            // p 배열에 한 대기실씩 넣기
            char[][] p = new char[5][5];
            for(int i=0;i<5;i++){
                String tables = place[i];
                for(int j=0;j<5;j++){
                    char table = tables.charAt(j);
                    p[i][j] = table;
                }
            }
            
            // 거리두기 미준수한 애가 한명이라도 있는지 체크
            chk = false;
            // P마다 맨해탄 거리 2인 table 체크
            G: for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(p[i][j] == 'P'){
                        visited = new boolean[5][5];
                        dfs(p, 0, i, j);
                    }
                    // chk가 true면 이미 거리두기 미준수
                    if(chk)
                        break G;
                }
            }
            // 거리두기 미준수한 애가 있으면
            if(chk)
                answer.add(0);
            //없으면
            else
                answer.add(1);
        }
        
        return answer;
    }
    
    public void dfs(char[][] place, int depth, int r, int c){
        // 방문처리
        visited[r][c] = true;     
        // 맨해튼거리 3 볼 필요 없고
        if(depth==3)
            return;
        // (r,c)가 파티션도 없는데 앉아있으면 거리두기 미준수
        if(depth != 0 && place[r][c] == 'P'){
            chk = true;
            return;
        }
        // 미준수한 사람 없으면 이동
        for(int d=0;d<4;d++){
            // 이동
            int nr = r+dr[d];
            int nc = c+dc[d];
            // 배열 범위 초과
            if(nr<0||nc<0||nr>=5||nc>=5)
                continue;
            // 방문여부, 이동하는 곳이 파티션이면
            if(visited[nr][nc] || place[nr][nc] == 'X')
                continue;
            // 보내!
            dfs(place, depth+1, nr, nc);
            visited[nr][nc]=false;
        }
        
    }
}