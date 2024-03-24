class Solution {
    public int[] solution(String[] wallpaper) {
        int ty = wallpaper.length;
		int tx = wallpaper[0].length();
		
		//각각 가장 바깥 값. r은 1씩 더해야함.
		int lmx = tx;
		int lmy = ty;
		int rmx = 0;
		int rmy = 0;

		//
		String[] temp = null;
		for(int i=0; i<ty; i++) {
			temp = wallpaper[i].split("");
			for(int j=0; j<tx; j++) {
				if(temp[j].equals("#")) {
					lmx = Math.min(lmx, j);//x값찾기
					lmy = Math.min(lmy, i);
					rmx = Math.max(rmx, j);//y값찾기
					rmy = Math.max(rmy, i);
				}
			}
		}
		
		int[] answer = {lmy, lmx, rmy+1, rmx+1};
		
		return answer;
    }
}