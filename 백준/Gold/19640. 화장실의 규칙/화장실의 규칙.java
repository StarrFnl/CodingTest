import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int N = Integer.parseInt(st[0]);
		int M = Integer.parseInt(st[1]);
		int K = Integer.parseInt(st[2]);
		
		PriorityQueue<Person> lineHeads = new PriorityQueue<Person>(Collections.reverseOrder());
		
		//각 줄을 Queue로 만들기
		Queue<Person>[] totalLines = new LinkedList[M];
		for(int i=0; i<M; i++) {
			totalLines[i] = new LinkedList<Person>();
		}
		//각 줄에 사람 만들어 넣기
		for(int i=0; i<N; i++) {
			st = br.readLine().split(" ");
			Person p = new Person(Integer.parseInt(st[0]), Integer.parseInt(st[1]), i%M, i);
			totalLines[i%M].add(p);
		}
		
		//선두 사람 뽑아서 넣기
		//맨 처음 직접 넣기
		Person p = totalLines[0].poll();
		lineHeads.add(p);
		for(int i=1; i<M; i++) {
			if(totalLines[i].size()!=0) {
				p = totalLines[i].poll();
				lineHeads.add(p);
			}
		}
		
		int result = 0;
		//첫 사람
		p = lineHeads.poll();
		while(p.n_num != K) {
			//줄에 사람이 남았으면 빼낸 줄에서 다시 넣기
			if(totalLines[p.m_num].size() != 0) {
				lineHeads.add(totalLines[p.m_num].poll());
			} 
			
			//p 업데이트
			p = lineHeads.poll();
			result++;
		}
		
		System.out.println(result);
		
	}
	
	private static class Person implements Comparable<Person>{
		int d_num;
		int h_num;
		int m_num;
		int n_num;

		public Person(int d_num,int h_num,int m_num, int n_num) {
			 this.d_num = d_num;
			 this.h_num = h_num;
			 this.m_num = m_num;
			 this.n_num = n_num;
		}
		
		@Override
		public int compareTo(Person p) {
			//근무 일수 가장 높을 때
			if(this.d_num > p.d_num) {
				return 1;
			}else if(this.d_num == p.d_num) {
				//근무 일수 같을 경우 급한 정도
				if(this.h_num > p.h_num) {
					return 1;
				}
				else if(this.h_num == p.h_num) {
					//앞 같을 경우 선두 번호 낮을 때
					if(this.m_num < p.m_num) {
						return 1;
					}else {
						return -1;
					}
				}
				else {
					return -1;
				}
			}else {
				return -1;
			}
		}
	}
	
}
