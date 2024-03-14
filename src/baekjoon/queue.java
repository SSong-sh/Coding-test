package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class queue {
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
        	
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>(); // Queue 인터페이스를 사용

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;

            while (!queue.isEmpty()) {
            	
                int[] first = queue.poll();
                boolean isMax = true;

                for (int[] element : queue) {
                	
                    if (first[1] < element[1]) {
                    	
                        queue.offer(first);
                        isMax = false;
                        break;
                    }
                    
                }

                if (!isMax) {
                	continue;
                }

                count++;
                
                if (first[0] == M) {          
                	break;
                }

            }
            
            sb.append(count).append('\n');
        }
        
        System.out.println(sb);
    }
}
