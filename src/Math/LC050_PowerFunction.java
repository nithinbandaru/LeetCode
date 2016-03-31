package Math;

public class LC050_PowerFunction {

	// Time complexity O(log n)
	public static void main(String[] args) {

		double num = 2;
		
		int pow = -3;
		
		double ans = power(num , pow);
		System.out.println(ans);
		
	}

	private static double power(double num, int pow) {
		
        if(pow == 0)
        {
        	return 1;            
        }
        if(pow < 0)
        {
        	return 1/power(num , -pow);
        }        
        
        if(pow%2==0)
        {
        	double temp = power(num, pow/2);
            
        	return temp*temp;            
        }
        else 
        {
            return num * power(num, pow-1);
        
        }
		
	}

}
