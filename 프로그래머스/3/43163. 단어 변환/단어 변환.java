import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

		boolean[] visit = new boolean[words.length];
		Words w = new Words(0, begin, visit);
		Deque<Words> ws = new ArrayDeque<Words>();
		ws.offer(w);
		System.out.println(w.now);

		answer = bfs_43163(begin, target, ws, words);

		return answer;
    }
    
    int bfs_43163(String begin, String target, Deque<Words> ws, String[] words) {
		Words w = ws.poll();
		if (target.equals(w.now)) {
			return w.result;
		}

		int chk = 0;
		// for문 돌면서 가능한 단어 방문
		for (int i = 0; i < w.visit.length; i++) {
			chk = 0;
			if (w.visit[i] == false) {
				for (int j = 0; j < words[i].length(); j++) {
					if (words[i].charAt(j) == w.now.charAt(j)) {
						chk++;
					}
				}
				//1개만 다른 글자 찾았을 때 ws에 넣고 다음 확인
				if (words[i].length() - chk == 1) {
					w.visit[i] = true;
					Words nw = new Words(++w.result, words[i], w.visit);
					ws.offer(nw);
					
				} else {
					continue;
				}
			} 
		}
		
		

		// 모두 탐색완료한 자리거나 불가능한 자리면
		if (ws.size() == 0) {
			return 0;
		} 
		//가능한 조합 모두 넣고 방문하기
		else {
			return bfs_43163(begin, target, ws, words);
		}

	}
    
    
    
    class Words {
		int result;
		String now;
		boolean[] visit;

		public Words(int result, String now, boolean[] visit) {
			this.result = result;
			this.now = now;
			this.visit = visit;
		}
	}
}

