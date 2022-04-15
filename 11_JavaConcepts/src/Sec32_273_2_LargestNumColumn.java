
// Find largest number in column where minium number is present in array 
// 2 4 5            
// 3 0 7
// 1 10 9

public class Sec32_273_2_LargestNumColumn {
	public static void main(String[] args) {
		
		int a[][] = { { 2, 4, 5 }, { 3, 2, 10 }, { 1, 2, 0 } };
		int min = a[0][0];
		int k = 0;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (a[i][j] < min) {
					min = a[i][j];
					k = j;
				}
			}
		}
		System.out.println("minimum no is: " + min);
		System.out.println("column no of minimum no is: " + k);
		for (int i = 0; i <= 2; i++) {
			if (a[i][k] > min)
				min = a[i][k];
		}
		System.out.println("maximum no in column where minimum no is present: " + min);
	}
}
