package BackTracking;

import java.util.HashMap;
import java.util.Map;
public class Permutations {
	
	static void permute(Map<Integer,Integer> m, int[] a, int i){
		if(i==a.length){
			for(int k:a){
				System.out.print(k+" ");
			}
			System.out.println();
			return;
		}
		
		for(Integer key:m.keySet()){
			int v = m.get(key);
			if(v>0){
				a[i] = key;
				m.put(key,v-1);
				permute(m, a, i+1);
				m.put(key, v);
			}
			
		}
	}

	public static void main(String[] args) {
		int[] num = new int[]{1,2,3};
		
		Map<Integer,Integer> m = new HashMap<Integer, Integer>();
		for(int i:num){
			Integer v = m.get(i);
			if(v==null)
				v = 1;
			else
				v++;
			m.put(i, v);
		}
		
		permute(m, new int[num.length], 0);

	}

}
