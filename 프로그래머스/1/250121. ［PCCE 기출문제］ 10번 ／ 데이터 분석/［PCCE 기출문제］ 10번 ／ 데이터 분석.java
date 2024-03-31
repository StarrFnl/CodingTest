import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

		int extNum = 0;
		if (ext.equals("code")) {
			extNum = 0;
			answer = compare(data, extNum, val_ext, sort_by);
		} else if (ext.equals("date")) {
			extNum = 1;
			answer = compare(data, extNum, val_ext, sort_by);
		} else if (ext.equals("maximum")) {
			extNum = 2;
			answer = compare(data, extNum, val_ext, sort_by);
		} else if (ext.equals("remain")) {
			extNum = 3;
			answer = compare(data, extNum, val_ext, sort_by);
		}
		
		return answer;
    }
    
    public int[][] compare(int[][] data, int extNum, int val_ext, String sort_by) {
		ArrayList<int[]> answer = new ArrayList<int[]>();
		for (int[] ele : data) {
			if (ele[extNum] < val_ext) {
				answer.add(ele);
			}
		}
		
		int[][] result = new int[answer.size()][];
		for(int i=0; i<answer.size(); i++) {
			result[i] = answer.get(i);
		}
		
		if (sort_by.equals("code")) {
			Arrays.sort(result, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
		} else if (sort_by.equals("date")) {
			Arrays.sort(result, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});

		} else if (sort_by.equals("maximum")) {
			Arrays.sort(result, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});

		} else if (sort_by.equals("remain")) {
			Arrays.sort(result, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[3] - o2[3];
				}
			});
			
		}
		
		
		
		
		return result;
	}
}