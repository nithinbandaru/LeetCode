package BitManipultation;

public class LC136_SingleNumberI {

	public static void main(String[] args) {

		
		int[] numbers = {2, 2, 11, 1, 11, 1, 7, 3 , 7};

		int nonRepeat = nonRepeatElement(numbers);
		
		System.out.println(nonRepeat);
		
	}

	private static int nonRepeatElement(int[] numbers) {

		int nonRepeat = 0;
		
		for(int i = 0 ; i < numbers.length; i++)
		{
			nonRepeat = nonRepeat ^ numbers[i];
		}		
		
		return nonRepeat;
	}

}
