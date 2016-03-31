package DatabaseQueries;

public class LC197_RisingTemperature {

	public static void main(String[] args) {

		String query = "select w1.id from weather w1, weather w2 where w1.Temperature > w2.Temperature "
				+ "and TODAYS(w1.DATE) - TODAYS(w2.DATE) = 1";
		
		System.out.println(query);
		
	}

}
