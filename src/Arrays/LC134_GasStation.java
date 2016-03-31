package Arrays;

public class LC134_GasStation {

	public static void main(String[] args) {

		int[] gas = { 1,2,3,4,5};
		int[] cost = {1,3,2,4,5};
		
		int canTravel = canCompleteCircuit(gas, cost);
		System.out.println(canTravel);
		
	}

	private static int canCompleteCircuit(int[] gas, int[] cost) {

		if(gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length)
		{
			return -1;
		}
		
		int startStation = 0;
		int tankReserve = 0;
		int totalGasToTravelAllStations = 0;
		
		for(int i = 0; i< gas.length; i++)
		{
			int fuelLeftAfterTransport = gas[i] - cost[i];			
			tankReserve = tankReserve + fuelLeftAfterTransport;
			
			totalGasToTravelAllStations = totalGasToTravelAllStations + fuelLeftAfterTransport;
			// u cannot go to next station
			if(tankReserve < 0)
			{
				tankReserve = 0;
				startStation = i + 1; // start from next station
			}			
			
		}
		
		if(totalGasToTravelAllStations < 0)
		{
			return -1;
		}
		
		return startStation;
	}

}
