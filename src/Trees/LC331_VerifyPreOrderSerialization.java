package Trees;

public class LC331_VerifyPreOrderSerialization {

	public static void main(String[] args) {

		String preOrder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		
		boolean verify = verifyPreOrderSerialization(preOrder);
		System.out.println(verify);		
		
	}

	private static boolean verifyPreOrderSerialization(String preOrder) {

		String[] nodes = preOrder.split(",");
		
		int nonLeaves = 0;
		int leaves = 0;
		
		int i=0;
		
		while( i < nodes.length && nonLeaves + 1 != leaves)
		{
			if(nodes[i].equals("#"))
			{
				leaves++;
			}
			else
			{
				nonLeaves++;
			}
			i++;
		}		
		
		return (nonLeaves + 1 == leaves && i == nodes.length);
	}

}
