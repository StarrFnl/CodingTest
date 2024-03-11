import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
		Map<String, Integer> hsMap = new HashMap<String, Integer>();
		for(int i=0; i<phone_book.length; i++) {
			hsMap.put(phone_book[i], i);
		}
		
		for(int i=0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book[i].length(); j++) {
				//현 String의 접두 String이 Map에 존재하는지 판별
				if(hsMap.containsKey(phone_book[i].substring(0, j))) {
					return false;
				}
			}
		}
		

		return true;
    }
}