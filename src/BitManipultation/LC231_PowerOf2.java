package BitManipultation;

public class LC231_PowerOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 12;
		
		boolean powerof2 = IsPowerOfTwo(num);
		
		System.out.println(powerof2);
		
		
	}

	private static boolean IsPowerOfTwo(int num) {
		
		if(num <= 0)
		{
			return false;
		}
		
		if( ( num & (num-1) )== 0)
		{
			return true;
		}
		
		return false;
	}

}
