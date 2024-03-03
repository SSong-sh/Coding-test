package test;
import java.util.*;


public class queue01 {
	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	        Queue<int[]> queue = new LinkedList<>();

	        for (int i = 0; i < priorities.length; i++) {
	            pq.offer(priorities[i]);
	            queue.offer(new int[]{i, priorities[i]});
	        }

	        while (!queue.isEmpty()) {
	            int[] first = queue.poll();

	            if (first[1] == pq.peek()) {
	                pq.poll();
	                answer++;

	                if (first[0] == location)
	                    break;
	            } else {
	                queue.offer(first);
	            }
	        }

	        return answer;
	    }
	

}
