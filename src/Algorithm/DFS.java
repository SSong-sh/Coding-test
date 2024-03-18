package Algorithm;

import java.io.*;
import java.util.*;

public class DFS{
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());           
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N];
        DFS(0);
        System.out.println(sb);
    
    }
    public static void DFS(int depth){
        if(depth==M){
            for(int val: arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i]=true;
                arr[depth]=i+1;
                DFS(depth+1);
                visited[i]=false;
            }
            
        }
    }
}