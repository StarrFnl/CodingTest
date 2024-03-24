import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] origin = new int[N][3];
		int[][] max_m = new int[N][3];
		int[][] min_m = new int[N][3];
		
		for(int i=0; i<N; i++) {
			origin[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		max_m[0] = origin[0];
		min_m[0] = origin[0];
		for(int i=1; i<N; i++) {
			max_m[i][0] = Math.max(max_m[i-1][0], max_m[i-1][1]) + origin[i][0];
			max_m[i][2] = Math.max(max_m[i-1][2], max_m[i-1][1]) + origin[i][2];
			max_m[i][1] = Math.max(Math.max(max_m[i-1][0], max_m[i-1][1]), max_m[i-1][2]) + origin[i][1];
			min_m[i][0] = Math.min(min_m[i-1][0], min_m[i-1][1]) + origin[i][0];
			min_m[i][2] = Math.min(min_m[i-1][2], min_m[i-1][1]) + origin[i][2];
			min_m[i][1] = Math.min(Math.min(min_m[i-1][0], min_m[i-1][1]), min_m[i-1][2]) + origin[i][1];
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(max_m[i]));
//		}
//		System.out.println("---------");
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(min_m[i]));
//		}
		
		System.out.println(Math.max(Math.max(max_m[N-1][0], max_m[N-1][1]), max_m[N-1][2])+" "+Math.min(Math.min(min_m[N-1][0], min_m[N-1][1]), min_m[N-1][2]));
	}

}