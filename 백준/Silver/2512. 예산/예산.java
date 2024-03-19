import java.util.*;
import java.util.stream.Stream;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] reqs = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int total = Integer.parseInt(br.readLine());
		
		Arrays.sort(reqs);
		//이진 탐색
		int start = 0;
		int end = reqs[N-1];
		int mid = 0;
		int answer = 0;
		
		//start가 end보다 더 커지는 순간의 mid가 가장 큰 값
		while(start<=end) {
			int sum = 0;
			mid = (start + end) / 2;
			
			//이미 mid보다 낮은 예산은 그대로 더하고, 큰 예산은 mid 더함
			for(int num : reqs) {
				sum += Math.min(num, mid);
			}
			
			//sum이 total보다 작을 경우 아직 mid가 커져도 됨. 일단 answer는 update(mid가 딱 떨어져 나눠지지 않을 가능성)
			if(sum <= total) {
				answer = mid;
				//start 옮겨서 다음 찾기
				start = mid + 1;
			}
			//sum이 total보다 클 경우 mid가 작아져야함(정답일 확률 없음)
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(answer);
		
		return;
		
	}
}
