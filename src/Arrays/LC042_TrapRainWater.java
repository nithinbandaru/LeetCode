package Arrays;

public class LC042_TrapRainWater {

	public static void main(String[] args) {

		
		int[] towerHeights = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		int rainWater = trapRainWater(towerHeights);
		System.out.println(rainWater);
		

		int rainWater2 = trapRainWaterOptimal(towerHeights);
		System.out.println(rainWater2);
	}

	private static int trapRainWaterOptimal(int[] towerHeights) {

		int numTowers = towerHeights.length;
		
		if(numTowers <= 2)
		{
			return 0;
		}
		
		int rainWater = 0;
		
		int l = 0;
		int r = numTowers-1;
		
		// find the left and right tower which can hold water
		
		while(l < r && towerHeights[l] <= towerHeights[l+1])
		{
			l++;
		}
		
		while(l < r && towerHeights[r] <= towerHeights[r-1])
		{
			r--;
		}
		
		
		while(l < r)
		{
			int leftTower = towerHeights[l];
			int rightTower = towerHeights[r];
			
			if(leftTower < rightTower)
			{
				// add water until an edge greater than left is encountered
				
				while(l < r && leftTower >= towerHeights[++l])
				{
					rainWater = rainWater + leftTower - towerHeights[l];
				}
			}
			else
			{
				// add water until an edge greater than right is encountered
				
				while(l < r && rightTower >= towerHeights[--r])
				{
					rainWater = rainWater + rightTower - towerHeights[r];
				}
			}
		}
		
		return rainWater;
	}

	private static int trapRainWater(int[] towerHeights) {

		int numOfTowers = towerHeights.length;
		
		int[] maxTowerHeightToRight = new int[numOfTowers];
		
		
		
		int maxSeenSoFarToRight = 0;
		
		for(int i = numOfTowers-1; i >= 0; i--)
		{
			if(towerHeights[i] > maxSeenSoFarToRight)
			{
				maxSeenSoFarToRight = towerHeights[i];
				maxTowerHeightToRight[i] = maxSeenSoFarToRight;
			}
			else
			{
				maxTowerHeightToRight[i] = maxSeenSoFarToRight;
			}
		}
		
		int rainWater = 0;
		int maxSeenSoFarToLeft = 0;
		
		for(int i =0 ; i < numOfTowers; i++)
		{
			rainWater = rainWater +  
					Math.max(Math.min(maxSeenSoFarToLeft, maxTowerHeightToRight[i]) - towerHeights[i] , 0);
			
			if(towerHeights[i] > maxSeenSoFarToLeft)
			{
				maxSeenSoFarToLeft = towerHeights[i];
			}
		}
		
		
		return rainWater;
	}

}
