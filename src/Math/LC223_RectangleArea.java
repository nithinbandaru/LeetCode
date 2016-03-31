package Math;

public class LC223_RectangleArea {

	public static void main(String[] args) {

		int A = -2;
		int B = -2;
		int C = 2;
		int D = 2;
		
		int E = -1;
		int F = -1;
		int G = 1;
		int H = 1;
		
		int area = rectangleArea(A, B, C, D, E, F, G, H);
		System.out.println(area);
		
	}

	private static int rectangleArea(int A, int B, int C, int D, int E, int F, int G, int H) {

		int area1 = (C-A) * (D-B);
		int area2 = (G-E) * (H-F);
		
		int leftBoundary = Math.max(A, E);
		int rightBoundary = Math.min(C, G);
		int topBoundary = Math.min(D, H);
		int bottomBoundary = Math.max(B, F);
		
		int overlapArea = 0;
		
		// check overlap 
		
		if(rightBoundary > leftBoundary && topBoundary > bottomBoundary)
		{
			overlapArea = (rightBoundary - leftBoundary) * (topBoundary - bottomBoundary);
		}
				
		return (area1 + area2 - overlapArea);
	}

}
