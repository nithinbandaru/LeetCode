package DynamicProgramming;

public class LC072_EditDistanceBetweenTwoStrings {

	public static void main(String[] args) {

		String s = "azced";
		String t = "abcdef";
		
		int dist = getEditDistance(s,t);
		System.out.println("Edit Distance : " + dist);
		
	}

	private static int getEditDistance(String s, String t) {

		int lenS = s.length();
		int lenT = t.length();
		
		int[][] distanceMatrix = new int[lenS+1][lenT+1];
		
		for(int i = 0; i < distanceMatrix[0].length ; i++)
		{
			distanceMatrix[0][i] = i;
		}
		
		for(int i = 0; i < distanceMatrix.length ; i++)
		{
			distanceMatrix[i][0] = i;
		}
		
		for(int i = 1; i < distanceMatrix.length; i++)
		{
			for(int j = 1; j < distanceMatrix[0].length; j++)
			{
				if(s.charAt(i-1) == t.charAt(j-1))
				{
					distanceMatrix[i][j] = distanceMatrix[i-1][j-1];
				}
				else
				{
					distanceMatrix[i][j] = 1 + Math.min(distanceMatrix[i-1][j-1], Math.min(distanceMatrix[i][j-1], distanceMatrix[i-1][j]));
				}
			}
		}
		
		return distanceMatrix[lenS][lenT];
	}

}
