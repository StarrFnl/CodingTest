class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] zero_board = new int[board.length+1][board[0].length+1];
        for(int[] value : skill) {
        	change(zero_board, value);
        }
        
        for(int i=0; i<zero_board.length; i++) {
        	for(int j=1; j<zero_board[0].length; j++) {
//        		누적합 계산?
        		zero_board[i][j] += zero_board[i][j-1];
        	}
        }
        
        for(int i=1; i<zero_board.length; i++) {
        	for(int j=0; j<zero_board[0].length; j++) {
//        		누적합 계산?
        		zero_board[i][j] += zero_board[i-1][j];
        	}
        }
        
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		board[i][j] += zero_board[i][j];
        		if(board[i][j]>0) {
        			answer++;
        		}
        	}
        }
        
        return answer;
    
    }
    
    public void change(int[][] zero_board, int[] value) {
		int type = value[0];
		int sx = value[1]; 
		int sy = value[2]; 
		int ex = value[3]; 
		int ey = value[4]; 
		int degree = value[5];
		if(degree==0){
            return;
        }
		
		if(type == 1) {
			zero_board[sx][sy] -= degree;
			zero_board[sx][ey+1] += degree;
			zero_board[ex+1][ey+1] -= degree;
			zero_board[ex+1][sy] += degree;
		}
		else if(type == 2) {
			zero_board[sx][sy] += degree;
			zero_board[sx][ey+1] -= degree;
			zero_board[ex+1][ey+1] += degree;
			zero_board[ex+1][sy] -= degree;
		}
		
	}
}