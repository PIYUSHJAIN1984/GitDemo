
//Print minimum number 
// 2 4 5
// 3 4 7
// 1 2 9

public class Sec32_273_1_SmallestNumArray {

	public static void main(String[] args) {

		int a[][] = { { 2, 4, 5 }, { 3, 4, 7 }, { 1, 2, 9 } };
		int min = a[0][0];

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (a[i][j] < min)
					min = a[i][j];
			}
		}
		System.out.println("minimum no is: " + min);
	}
}
