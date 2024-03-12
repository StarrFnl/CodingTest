class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

		// 결과는 target과 동일 시 +1, 아닐 시 0 return
		int result = bfs(numbers, target, 1, 0, 0) + bfs(numbers, target, -1, 0, 0);

		return result;
    }
    
    private int bfs(int[] numbers, int target, int sign, int next, int temp) {
		int result = 0;
		// 현재 회차값 계산
		temp += numbers[next] * sign;
		if (next == numbers.length - 1) {
			if (temp == target) {
				return 1;
			} else {
				return 0;
			}
		}

		result += bfs(numbers, target, 1, next + 1, temp);
		result += bfs(numbers, target, -1, next + 1, temp);

		return result;
	}
}