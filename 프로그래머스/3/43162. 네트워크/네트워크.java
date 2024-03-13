import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        //배열 초기화 시키기
        Arrays.fill(visited, false);
        
        for(int i=0; i<computers.length; i++) {
        	if(visited[i]==false) {
        		answer += bfs_43162(i, visited, computers);
        	}
        }
        
        return answer;
    }
    
    int bfs_43162(int comNum, boolean[] visited, int[][] computers) {
		if(visited[comNum]==true) {
			return 0;
		}
		//방문하기
		visited[comNum] = true;
		
		for(int i=0; i<computers[comNum].length; i++) {
			//자기자신 당연있음
			if(i == comNum) {
				continue;
			}
			//간선 있는 곳이면 방문
			if(computers[comNum][i] == 1) {
				bfs_43162(i, visited, computers);
			}
		}
		
		//그냥 하나만 추가
		return 1;
	}
}