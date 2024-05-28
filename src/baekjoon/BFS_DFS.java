package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_DFS {
    static ArrayList<Integer>[] graph; // 그래프 인접 리스트
    static boolean[] visited;          // 방문 여부 확인 배열
    static StringBuilder dfsResult;    // DFS 결과 저장
    static StringBuilder bfsResult;    // BFS 결과 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 인접 리스트 정렬 (정점 번호가 작은 것을 먼저 방문하기 위해)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 수행
        visited = new boolean[N + 1];
        dfsResult = new StringBuilder();
        dfs(V);
        dfsResult.append("\n");

        // BFS 수행
        visited = new boolean[N + 1];
        bfsResult = new StringBuilder();
        bfs(V);
        bfsResult.append("\n");

        // 결과 출력
        bw.write(dfsResult.toString());
        bw.write(bfsResult.toString());

        br.close();
        bw.close();
    }

    // DFS 메서드
    static void dfs(int node) {
        visited[node] = true;
        dfsResult.append(node).append(" ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    // BFS 메서드
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsResult.append(node).append(" ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}

