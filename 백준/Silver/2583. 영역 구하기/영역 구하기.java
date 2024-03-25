import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int M = 0;
	static int N = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		
		M = Integer.parseInt(st[0]);
		N = Integer.parseInt(st[1]);
		int K = Integer.parseInt(st[2]);
		
		char[][] matrix = new char[M][N]; 
		
		for(int i=0; i<K; i++) {
			st = br.readLine().split(" ");
			fill_matrix(matrix, st);
		}
		
		List<Integer> answerArr = new ArrayList<Integer>();
		
		int answer = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				//방문 가능 시 방문
				if(matrix[i][j] == 0) {
					answerArr.add(solution(matrix, i, j));
					answer++;
				}
			}
		}
		Collections.sort(answerArr);
		System.out.println(answer);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<answerArr.size(); i++) {
			sb.append(answerArr.get(i));
			sb.append(' ');
		}
		System.out.println(sb);
	}
	
	private static void fill_matrix(char[][] matrix, String[] st) {
		int lx = 0;
		int ly = 0;
		int rx = 0;
		int ry = 0;
		lx = Integer.parseInt(st[0]);
		ly = Integer.parseInt(st[1]);
		rx = Integer.parseInt(st[2]);
		ry = Integer.parseInt(st[3]);
		
		for(int i=lx; i<rx; i++) {
			for(int j=ly; j<ry; j++) {
				matrix[j][i] = 's';
			}
		}		
	}
	
	private static int solution(char[][] matrix, int x, int y) {
		int tx, ty = 0;
		matrix[x][y] = 'v';
		int result = 1;
		for(int i=0; i<4; i++) {
			tx = dx[i]+x;
			ty = dy[i]+y;
			if(tx >=0 && tx < M && ty >=0 && ty < N && matrix[tx][ty] == 0) {
				 result += solution(matrix, tx, ty);
			}
			
		}
		return result;
	}
}
