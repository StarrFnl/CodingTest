import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
	        
	        int[] ans1 = {1, 2, 3, 4, 5};
	        int[] ans2 = {2, 1, 2, 3, 2, 4, 2, 5};
	        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	        
	        int[] res = {0, 0, 0};
	        
	        for(int i=0; i<answers.length; i++){
	            if(answers[i] == ans1[i%5]){
	                res[0]++;
	            }
	            if(answers[i] == ans2[i%8]){
	                res[1]++;
	            }
	            if(answers[i] == ans3[i%10]){
	                res[2]++;
	            }
	        }
	        
	        List<Integer> arr = new ArrayList<Integer>();
	        
            int max = 1;
	        for(int i=0; i<3; i++){
	            if(res[i] >= max){
	                max = res[i];
	            }
	        }
        
            for(int i=0; i<3; i++){
	            if(res[i] == max){
	                arr.add(i+1);
	            }
	        }
        
            Collections.sort(arr);
            answer = arr.stream().mapToInt(i->i).toArray();
        
	        return answer;
    }
}