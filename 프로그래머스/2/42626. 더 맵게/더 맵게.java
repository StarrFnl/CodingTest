import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

		PriorityQueue<Integer> pq_scov = new PriorityQueue<Integer>();

		for (int scov : scoville) {
			pq_scov.add(scov);
		}


		while (pq_scov.peek() < K) {
			if(pq_scov.size() == 1) {
				return -1;
			}
			answer++;
			// 업쳐서 넣기
			pq_scov.add(pq_scov.poll() + pq_scov.poll() * 2);

		}


		return answer;

    }
}