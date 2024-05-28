package baekjoon;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 
  경로나 가능한 모든 해결책을 찾고자 할 때 -> DFS 주로 사용 
  최단 경로 -> BFS
 
 */


public class DFS {
	
    static boolean[][] graph;   // 노드 간의 연결 상태를 저장하는 2차원 배열
    static boolean[] visited;   // 각 노드의 방문 여부를 저장하는 배열
    static int N, M;            // 노드의 수(N)와 간선의 수(M)
    static int count;           // DFS로 접근한 노드의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());  // 노드의 수 입력
        M = Integer.parseInt(br.readLine());  // 간선의 수 입력

        graph = new boolean[N + 1][N + 1];  // 그래프 초기화 (노드 번호를 1부터 사용)
        visited = new boolean[N + 1];       // 방문 배열 초기화 (노드 번호를 1부터 사용)

        // 간선 정보를 입력받아 그래프에 저장
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;  // 노드 x와 y가 연결됨을 표시
            graph[y][x] = true;  // 무방향 그래프이므로 대칭으로 저장
        }

        dfs(1);  // 1번 노드부터 DFS 시작

        bw.write(String.valueOf(count - 1));  // 1번 노드를 제외한 연결된 노드의 수 출력
        br.close();
        bw.close();
    }

    static void dfs(int start) {
        visited[start] = true;  // 현재 노드를 방문 처리
        count++;  // 방문한 노드의 수 증가

        for (int i = 1; i <= N; i++) {  // 모든 노드에 대해
            // 현재 노드와 연결된 노드를 찾고, 방문하지 않은 경우
            if (!visited[i] && graph[start][i]) {
                dfs(i);  // 해당 노드를 방문
            }
        }
    }
}
