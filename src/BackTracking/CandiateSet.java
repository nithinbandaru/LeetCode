package BackTracking;

public class CandiateSet {
	
	public static void recurse(int[] a, int t, int[] s, int c, int i, int j){
//		if(i>=a.length)
//			return;
		if(c==t){
			for(int k=0;k<j;k++){
				System.out.print(s[k]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int k=i;k<a.length && c+a[k]<=t;k++){
			s[j] = a[k];
			recurse(a,t,s,c+a[k],k,j+1);
		}
		
		
	}

	public static void main(String[] args) {
		recurse(new int[]{2,3,5,7}, 7, new int[7], 0,0,0);
	}

}
