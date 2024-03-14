import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int max = 0;
	static Integer[] dp;
	static int[] stairs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stairs = new int[n+1];
		//메모이제이션
		dp = new Integer[n+1];
		for(int i=1; i<=n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

//		//첫칸 시작
//		solution(n, stairs, false, 0, stairs[0]);
//		//둘째칸 시작
//		solution(n, stairs, false, 1, stairs[1]);
//		System.out.println(max);
		
		
		dp[0] = 0;
		dp[1] = stairs[1];
		
		//n이 2보다 작은 경우 있을 수 있음. 2보다 큰 경우 무조건 1+1의 결과
		if(n >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}
		
		System.out.println(find(n));
		
	}
	
	//참고함
	private static int find(int n) {
		//아직 탐색하지 않았으면
		if(dp[n]==null) {
			//-2칸에서 오거나, n-1 + n-1-2 칸에서 오거나
			dp[n] = Math.max(find(n-2), find(n-3)+stairs[n-1])+stairs[n];
		}
		
		return dp[n];
	}
	
	
	//1,2에 붙은 1을 줄 때는 warn을 true로. warn이 true이면 step은 무조건 2여야함.
	//시간 초과
	private static void solution(int n, int[] stairs, boolean warn, int step, int result) {
		//warn 경우가 아니고, 끝까지 도달하면 max 탐색
		if(step == n-1 && warn == false) {
			if(result > max) max = result;
			return;
		}
		//warn이 true일 경우 +2
		if(warn == true && step+2 <= n-1) {
			result += stairs[step+2];
			solution(n, stairs, false, step+2, result);
			return;
		}
		//무조건 +2여야 하는 경우가 아니면
		else {
			//1칸 가는 결과, 2칸 가는 결과 따로 필요?
			int tempR1 = result;
			int tempR2 = result;
			
			if(step+1<=n-1) {
				tempR1 += stairs[step+1];
				solution(n, stairs, true, step+1, tempR1);
			}
			if(step+2<=n-1) {
				tempR2 += stairs[step+2];
				solution(n, stairs, false, step+2, tempR2);
			}
			
		}
	}
}
