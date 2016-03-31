package Math;

public class ClockAngleProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double hour = 1;
		double minute = 55;
		double angle = clockAngle(hour, minute);
		System.out.println("Clock Angle: " + angle);

	}

	private static double clockAngle(double h, double m) {
		// TODO Auto-generated method stub
		if( h < 0 || h > 12 || m <0 || m > 60 )
		{
			System.out.println("Wrong input");
			return -1;
		}		
		if(h==12)
		{
			h = 0;
		}
		if(m==60)
		{
			m=0;
		}

		//double hour_angle = 0.5 *(60 * h + m);
		double hour_angle = (h * 30) + m * 0.5;
		double minute_angle = 6 *m;
		
		double angle = Math.abs(hour_angle - minute_angle);
		
		angle = angle < 360-angle ? angle: 360-angle;
		return angle;
	}

}
