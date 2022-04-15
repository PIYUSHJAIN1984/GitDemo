
public class Sec32_257_3_ReversPyramid {

//	Problem: Print 
//	3
//	6 9
//	12 15 18
//	21 24 27 30

	public static void main(String[] args) {
		int k = 3;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(k);
				System.out.print(" ");
				k = k + 3;
			}
			System.out.println(" ");
		}
	}
}
