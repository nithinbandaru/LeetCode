package Arrays;

public class LC277_FindCelebrity {

	public static void main(String[] args) {

		int num = 3;
		
		int celebrity = findCelebrity(num);
		System.out.println("Celebrity Person "  + (celebrity + 1));
	}

	private static int findCelebrity(int num) {

		int celebrity = 0;
		// first scan find the celebrity candidate
		for(int i = 1; i < num; i++)
		{
			if(knows(celebrity, i))
			{
				celebrity = i;
			}
		}
		
		// second pass make sure he is indeed a celebrity
		
		for(int i = 0; i < num; i++)
		{
			if(i != celebrity && (knows(celebrity, i) || !knows(i,celebrity)))
			{
				return -1;
			}
		}
		
		return celebrity;
	}

	private static boolean knows(int person1, int person2) {

		if(person1 == 0 && person2 == 1)
		{
			return true;
		}
		if(person1 == 0 && person2 == 2)
		{
			return true;
		}
		if(person1 == 1 && person2 == 2)
		{
			return true;
		}
		
		if(person1 == 1 && person2 == 0)
		{
			return true;
		}
		
		return false;
	}

}
